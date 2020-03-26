package logic;

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
	private List<List<IceCell>> field = new ArrayList<>();
	private ArrayList<Character> characters;
	private WinChecker wc = new WinChecker();
    private int chosenToSave = -1;

	private int[][] cellTable; //CSAK TESZT, KIKOMMENTELNI A configureCells() ELSŐ SORÁT ÉS KISZEDNI A KONSTRUKTORBÓL
	private void drawField(){

	} //CSAK TESZT, ÉS KISZEDNI AZ INPUT FV EK VÉGÉRŐL

	public IceField(){

	}

	//Pálya építést szolgáló fv-ek
	private void buildCells(){

	}
	private void buildNeighbours(IceCell ic, int y, int x){

	}
	private void configureCells(int numberOfWater, int numberOfUnstable) {
	} //VAN BENNE drawField();
	private void putPlayersToCell() {

	}
	private void placeItem(PlayerActions pa, int y, int x, int essentialID){

	}

	//Pálya működését szolgáló fv-ek
	private void snowStorm() {

	}
	private void snow(int seqNum, Way to, IceCell from, boolean subRoot){

	}
	public void addIceCell(IceCell ic, IceCell removed) {

	}
	private void gameLost() {  }
	private void gameWon() {  }
	private void actionHandler(){

	}
	public static int getMaxPlayer(){  }

	//Inputra reagáló fv-ek //VANNAK BENNE drawField() ek
	public void setChosenToSave(int i){

	}
	public Character getChosenToSave(){

	}
	public void nextPlayer() {

	}
	private void useEssentialItems() {

	}
	public void setPlayerWay(Way w){
	}
	public void usePlayerItem(PlayerActions pa) {

	}
	public void useAbility() {

	}
	public void movePlayer(Way w) {

	}
	public void mineActualCell() {

	}
}
