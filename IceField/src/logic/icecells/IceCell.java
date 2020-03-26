package logic.icecells;

import logic.IceField;
import logic.Way;
import logic.characters.Character;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public abstract class IceCell {
	protected int capacity;
	protected boolean capacityKnown = false;
	protected int snow;
	protected static int maxSnow = 5;
	private HashMap<Way, IceCell> neighbours = new HashMap<>();
	protected ArrayList<Character> standingPlayers = new ArrayList<>();
	protected IceField ownField;


	public IceCell(){

	}

	public boolean setCapacityKnown() {
		System.out.println("IceCell.setCapacityKnown meghívódott");
	}
	public boolean loseSnow(boolean withShovel) {
		System.out.println("IceCell.loseSnow meghívódott");
	}
	public void gainOneSnow() {
		System.out.println("IceCell.gainOneSnow meghívódott");
	}
	public IceCell getNeighbour(Way w) {
		System.out.println("IceCell.getNeighbour meghívódott");
	}
	public void addNeighbour(Way w, IceCell ic) {
		System.out.println("IceCell.addNeighbour meghívódott");
	}
	public void removeCharacter(Character ch) {
		System.out.println("IceCell.removeCharacter meghívódott");
	}
	public void addCharacter(Character ch) {
		System.out.println("IceCell.addCharacter meghívódott");
	}

	public boolean movePlayerOut(Way from) {
		System.out.println("IceCell.movePlayerOut meghívódott");
	}
	public void mine(Character actual) {
		System.out.println("IceCell.mine meghívódott");
	}
	public boolean setIgloo(boolean b) {
		System.out.println("IceCell.setIgloo meghívódott");
	}
	public abstract void accept(Character ch);
	public abstract void snowing();
}
