<<<<<<< HEAD
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

	private int[][] cellTable;


	public IceField(){

	}

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
=======
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

	public IceField(){ }

	private void snowStorm() {
		System.out.println("IceField.snowStorm() meghívódott");
	}

	public void addIceCell(IceCell ic, IceCell removed) {
		System.out.println("IceField.addIceCell() meghívódott");
	}
	private void gameLost() {
		System.out.println("IceField.gameLost() meghívódott");
	}
	private void gameWon() {
		System.out.println("IceField.gameLost() meghívódott");
	}

	public void nextPlayer() {
		System.out.println("IceField.nextPlayer() meghívódott");
	}
	private void useEssentialItems() {
		System.out.println("IceField.useEssentialItems() meghívódott");
	}
	public void setPlayerWay(Way w){
		System.out.println("IceField.setPlayerWay() meghívódott");
	}
	public void usePlayerItem(PlayerActions pa) {
		System.out.println("IceField.usePlayerItem() meghívódott");
	}
	public void useAbility() {
		System.out.println("IceField.useAbility() meghívódott");
	}
	public void movePlayer(Way w) {
		System.out.println("IceField.movePlayer() meghívódott");
	}
	public void mineActualCell() {
		System.out.println("IceField.mineActualCell() meghívódott");
	}
}
>>>>>>> b12ba47ebb1f89d591314f7787d627e810936e85
