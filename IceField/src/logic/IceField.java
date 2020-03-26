package logic;

import logic.characters.Character;
import logic.characters.Eskimo;
import logic.characters.Explorer;
import logic.icecells.IceCell;
import logic.icecells.StableIceCell;
import logic.icecells.UnstableIceCell;
import logic.icecells.WaterCell;
import logic.items.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class IceField {
	private static int maxPlayer;
	private static int fieldLengths;
	private int currentPlayer = 0;
	public boolean gameWon = false;
	public boolean gameLost = false;
	private List<List<IceCell>> field = new ArrayList<>();
	private ArrayList<Character> characters;
	private WinChecker wc = new WinChecker();
    private int chosenToSave = -1;

	public IceField(){
		characters = new ArrayList<>();
		characters.add(new Eskimo());
		characters.add(new Explorer());
		characters.add(new Explorer());
	}

	private void snowStorm() {
		System.out.println("IceField.snowStorm meghívódott");
		IceCell stableic = new StableIceCell();
		IceCell unstableic = new UnstableIceCell();
		IceCell water = new WaterCell();

		stableic.snowing();
		unstableic.snowing();
		water.snowing();
	}

	public void addIceCell(IceCell ic, IceCell removed) {
		System.out.println("IceField.addIceCell meghívódott");
	}
	private void gameLost() {
		System.out.println("IceField.gameLost meghívódott");
	}
	private void gameWon() {
		System.out.println("IceField.gameLost meghívódott");
	}

	public void nextPlayer() {
		System.out.println("IceField.nextPlayer meghívódott");
	}
	private void useEssentialItems() {
		System.out.println("IceField.useEssentialItems meghívódott");
		for(Character ch : characters){
			ch.useEssentials();
		}
		wc.isAssembled();
		gameWon();
	}
	public void setPlayerWay(Way w){
		System.out.println("IceField.setPlayerWay meghívódott");
	}
	public void usePlayerItem(PlayerActions pa) {
		System.out.println("IceField.usePlayerItem meghívódott");
		characters.get(0).useItem(pa);
	}
	public void useAbility() {
		System.out.println("IceField.useAbility meghívódott");
		System.out.println("Melyik játékos képessége használódjon?(Eskimo = E, Explorer = EX)");
		Scanner actionScan = new Scanner(System.in);
		String ac = actionScan.nextLine();
		switch(ac){
			case "E" :  characters.get(0).ability();
			case "Ex" : characters.get(1).ability();
		}
	}
	public void movePlayer(Way w) {
		System.out.println("IceField.movePlayer meghívódott");
		characters.get(0).move();
	}
	public void mineActualCell() {
		System.out.println("IceField.mineActualCell meghívódott");
		characters.get(0).mine();
	}
}

