package logic;

import logic.characters.Bear;
import logic.characters.Character;
import logic.icecells.IceCell;
import logic.icecells.StableIceCell;
import logic.icecells.UnstableIceCell;
import logic.icecells.WaterCell;
import logic.items.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IceField {
	private static int maxPlayer;
	private static int fieldLengths;
	private int currentPlayer = 0;
	public boolean gameWon = false;
	public boolean gameLost = false;
	public String gameLostString;
	private List<List<IceCell>> field = new ArrayList<>();
	private ArrayList<Character> characters;
	private WinChecker wc = new WinChecker();
    private int chosenToSave = -1;
	private Bear bear;


	public IceField(ArrayList<Character> c){
		maxPlayer = c.size();
		fieldLengths = maxPlayer + 4;
		characters = c;

		buildCells();
	}

	//Pálya építést szolgáló fv-ek
	private void buildCells(){
		for(int y = 0; y < fieldLengths; y++)  {
			List<IceCell> row = new ArrayList<>(fieldLengths);
			for(int x = 0; x < fieldLengths; x++) {
				row.add(new StableIceCell(this, null, null));
			}
			field.add(row);
		}

		for(int y = 0; y < fieldLengths; y++)
			for(int x = 0; x < fieldLengths; x++)
				buildNeighbours(field.get(y).get(x), y, x);

		switch(maxPlayer){
			case 6 : configureCells(20, 30); break;
			case 5 : configureCells(18, 27); break;
			case 4 : configureCells(8, 16); break;
			default: configureCells(7, 14); break;
		}
	}
	private void buildNeighbours(IceCell ic, int y, int x){
		if(y != 0) ic.addNeighbour(Way.up, field.get(y - 1).get(x));
		if(y != fieldLengths - 1) ic.addNeighbour(Way.down, field.get(y + 1).get(x));
		if(x != 0) ic.addNeighbour(Way.left, field.get(y).get(x - 1));
		if(x != fieldLengths - 1) ic.addNeighbour(Way.right, field.get(y).get(x + 1));
	}
	private void configureCells(int numberOfWater, int numberOfUnstable) {
		int[][] cellTable = new int[fieldLengths][fieldLengths];

		putWaterToCell(numberOfWater, cellTable);
		putUnstableToCell(numberOfUnstable, cellTable);
		putItemsToCell(cellTable);
		putBearToCell();
		putPlayersToCell();
	}
	private void putWaterToCell(int numberOfWater, int[][] cellTable){
		Random random = new Random();
		int x = random.nextInt(fieldLengths);
		int y = random.nextInt(fieldLengths);

		for(int i = 0; i < numberOfWater; i++){
			while(cellTable[y][x] != 0) {
				x = random.nextInt(fieldLengths);
				y = random.nextInt(fieldLengths);
			}
			cellTable[y][x] = 1;

			int connected = 0;
			if(y + 1 < fieldLengths - 1 && cellTable[y + 1][x] != 1) connected = checkIslands(cellTable, y + 1, x);
			else if(x + 1 < fieldLengths - 1 && cellTable[y][x + 1] != 1) connected = checkIslands(cellTable, y, x + 1);
			else if(y - 1 > 0 && cellTable[y - 1][x] != 1) connected = checkIslands(cellTable, y - 1, x);
			else if(x - 1 > 0 && cellTable[y][x - 1] != 1) connected = checkIslands(cellTable, y, x - 1);
			resetIslands(cellTable);

			if(connected != 0 && connected != fieldLengths*fieldLengths - i - 1){
				cellTable[y][x] = 0;
				i--;
				x = random.nextInt(fieldLengths);
				y = random.nextInt(fieldLengths);
			}
			else{
				WaterCell water = new WaterCell(this);
				field.get(y).set(x, water);
				buildNeighbours(water, y, x);
				for(Way w : Way.values()){
					if(water.getNeighbour(w) != null)
						water.getNeighbour(w).addNeighbour(w.opposite(), water);
				}
			}
		}
	}
	private void putUnstableToCell(int numberOfUnstable, int[][] cellTable){
		Random random = new Random();
		int x = random.nextInt(fieldLengths);
		int y = random.nextInt(fieldLengths);

		for(int i = 0; i < numberOfUnstable; i++){
			while(cellTable[y][x] != 0){
				x = random.nextInt(fieldLengths);
				y = random.nextInt(fieldLengths);
			}
			UnstableIceCell unstable = new UnstableIceCell(random.nextInt(maxPlayer - 2) + 2, this);
			field.get(y).set(x, unstable);
			buildNeighbours(unstable, y, x);
			for(Way w : Way.values()){
				if(unstable.getNeighbour(w) != null)
					unstable.getNeighbour(w).addNeighbour(w.opposite(), unstable);
			}
			cellTable[y][x] = 2;
		}
	}
	private void putItemsToCell(int[][] cellTable){
		Random random = new Random();
		int x = random.nextInt(fieldLengths);
		int y = random.nextInt(fieldLengths);

		int essentialID = 0;
		for (PlayerActions pa : PlayerActions.values()) {
			int itemNumber = (pa == PlayerActions.eating) ? 2 * maxPlayer : maxPlayer - 1;
			if (pa == PlayerActions.assemblingEssentials) itemNumber = 3;
			for (int i = 0; i < itemNumber; i++) {
				while (cellTable[y][x] != 0) {
					x = random.nextInt(fieldLengths);
					y = random.nextInt(fieldLengths);
				}
				cellTable[y][x] = 3;
				placeItem(pa, y, x, essentialID);
				if(pa == PlayerActions.assemblingEssentials) essentialID++;
			}
		}
	}
	private void putBearToCell(){
		Random random = new Random();
		int x = random.nextInt(fieldLengths);
		int y = random.nextInt(fieldLengths);

		bear = new Bear(field.get(y).get(x));
		while(!field.get(y).get(x).acceptBear(bear)){
			x = random.nextInt(fieldLengths);
			y = random.nextInt(fieldLengths);
			bear = new Bear(field.get(y).get(x));
		}
	}
	private void putPlayersToCell() {
		int bearX = -1, bearY = -1;
		for(int i = 0; i < fieldLengths; i++)
			for(int j = 0; j < fieldLengths; j++)
				if(field.get(j).get(i).hasBear()){
					bearX = i; bearY = j;
					break;
				}

		Random random = new Random();
		int x = random.nextInt(fieldLengths);
		int y = random.nextInt(fieldLengths);

		while(!field.get(y).get(x).safeToStart() || (Math.abs(bearX - x) < maxPlayer && Math.abs(bearY - y) < maxPlayer)){
			x = random.nextInt(fieldLengths);
			y = random.nextInt(fieldLengths);
		}
		for(int i = 0; i < maxPlayer; i++) {
			field.get(y).get(x).addCharacter(characters.get(i));
			characters.get(i).setOwnCell(field.get(y).get(x));
		}
	}
	private void placeItem(PlayerActions pa, int y, int x, int essentialID){
		Items item;
		PlayerActions playerAct;
		switch (pa){
			case eating: item = new Food(); playerAct = PlayerActions.eating; break;
			case shoveling: item = new Shovel(); playerAct = PlayerActions.shoveling; break;
			case wearingSuit: item = new Divingsuit(); playerAct = PlayerActions.wearingSuit; break;
			case savingWithRope: item = new Rope(); playerAct = PlayerActions.savingWithRope; break;
			case fragileshoveling: item = new FragileShovel(); playerAct = PlayerActions.fragileshoveling; break;
			case setUpTent: item = new Tent(); playerAct = PlayerActions.setUpTent; break;
			default: item = new EssentialItem(essentialID, wc); playerAct = PlayerActions.assemblingEssentials; break;
		}
		StableIceCell newCell = new StableIceCell(this, item, playerAct);
		buildNeighbours(newCell, y, x);
		for(Way w : Way.values()){
			if(newCell.getNeighbour(w) != null)
				newCell.getNeighbour(w).addNeighbour(w.opposite(), newCell);
		}
		field.get(y).set(x, newCell);
	}
	private int checkIslands(int[][] confTable, int y, int x){
		if(y < 0 || y > fieldLengths - 1 || x < 0 || x > fieldLengths - 1) return 0;
		if(confTable[y][x] == 1 || confTable[y][x] >= 10) return 0;
		confTable[y][x] += 10;
		return 1 + checkIslands(confTable, y + 1, x) + checkIslands(confTable, y - 1, x) + checkIslands(confTable, y, x + 1) + checkIslands(confTable, y, x - 1);
	}
	private void resetIslands(int[][] confTable) {
		for (int j = 0; j < fieldLengths; j++){
			for (int i = 0; i < fieldLengths; i++){
				if(confTable[j][i] >= 10) confTable[j][i] -= 10;
			}
		}
	}

	//Pálya működését szolgáló fv-ek
	private void snowStorm() {
		Random r = new Random();
		int x = r.nextInt(fieldLengths);
		int y = r.nextInt(fieldLengths);
		IceCell rootCell = field.get(y).get(x);

		int radius = (int)(Math.ceil(((double)fieldLengths)/2));
		rootCell.snowing();
		int i = 0;
		for(Way w : Way.values()){
			snow(radius - 1, w, rootCell.getNeighbour(w), i % 2 == 1);
			i++;
		}
	}
	private void snow(int seqNum, Way to, IceCell from, boolean subRoot){
		if(seqNum == 0 || from == null) return;
		from.snowing();

		snow(seqNum - 1, to, from.getNeighbour(to), subRoot);
		if(subRoot){
			snow(seqNum - 1, to.rotate(true), from.getNeighbour(to.rotate(true)), false);
			snow(seqNum - 1, to.rotate(false), from.getNeighbour(to.rotate(false)), false);
		}
	}
	public void addIceCell(IceCell ic, IceCell removed) {
		for(int j = 0; j < fieldLengths; j++)
			if(field.get(j).contains(removed)){
				int i = field.get(j).indexOf(removed);
				field.get(j).remove(i);
				field.get(j).add(i, ic);
			}
	}
	public void gameLost(String s) { gameLostString = s; gameLost = true; }
	public void gameWon() { gameWon = true; }
	private void actionHandler(){
		if(characters.get(currentPlayer).getActionsLeft() == 0 || characters.get(currentPlayer).getTurnsInWater() != 0)
			nextPlayer();
	}
	public static int getMaxPlayer(){ return maxPlayer; }

	//Inputra reagáló fv-ek //VANNAK BENNE drawField() ek
	public void setChosenToSave(int i){
		if(i >= 0 && i < maxPlayer) chosenToSave = i;
	}
	public Character getChosenToSave(){
		if(chosenToSave == -1) return null;
		Character c = characters.get(chosenToSave);
		chosenToSave = -1;

		return c;
	}
	public void nextPlayer() {
		characters.get(currentPlayer).resetActionsLeft();
		bear.move();

		Random r = new Random();
		int i = r.nextInt(5);
		if (i == 0) snowStorm();

		for(Character c : characters){
			if(c.getTurnsInWater() != 0)
				c.addOneTurnInWater();
			if(c.getBodyHeat() == 0)
				gameLost("A testhőmérsékletetek lecsökkent 0-ra!");
			if(c.getTurnsInWater() > maxPlayer && !c.getDivingSuit())
				gameLost("Túl régóta estetek vízbe!");
		}

		for (int y = 0; y < fieldLengths; y++) {
			for (int x = 0; x < fieldLengths; x++) {
				if (field.get(y).get(x).getTentTurnsLeft() > 0) {
					field.get(y).get(x).loseOneTentTurn();
				}
			}
		}

		int countAll;
		for(countAll = 0; countAll != maxPlayer; countAll++){
			currentPlayer = (currentPlayer + 1 == maxPlayer) ? 0 : (currentPlayer + 1);
			if(characters.get(currentPlayer).getTurnsInWater() == 0) break;
		}
		if(countAll == maxPlayer)
			gameLost("Rálépetetek egyszerre egy instabil cellára!");
	}
	private void useEssentialItems() {
		IceCell ic = characters.get(0).getOwnCell();

		for(Character ch : characters){
			if(ch.getOwnCell() != ic)
				return;
		}
		for(Character ch : characters){
			ch.useEssentials();
		}

		if(wc.isAssembled()){
			gameWon();
			characters.get(currentPlayer).loseOneAction();
		}
		else wc.resetAssembledItems();

		actionHandler();
	}
	public void setPlayerWay(Way w) {
		characters.get(currentPlayer).setFacingWay(w);
	}
	public void usePlayerItem(PlayerActions pa) {
		if(pa == PlayerActions.assemblingEssentials) useEssentialItems();
		else characters.get(currentPlayer).useItem(pa);

		actionHandler();
	}
	public void useAbility() {
		characters.get(currentPlayer).ability();
		actionHandler();
	}
	public void movePlayer(Way w) {
		setPlayerWay(w);
		characters.get(currentPlayer).move();
		actionHandler();
	}
	public void mineActualCell() {
		characters.get(currentPlayer).mine();
		actionHandler();
	}

	//Kirajzolást segító függvények
	public int getFieldLength(){ return fieldLengths; }
	public IceCell getCell(int x, int y){ return field.get(y).get(x); }
	public int getActualPlayerNumber(){ return currentPlayer; }
	public Character getActualPlayer(){ return characters.get(currentPlayer); }
	public Character getPlayersFromField(int i){ return characters.get(i); }
}
