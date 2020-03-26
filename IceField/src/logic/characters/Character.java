package logic.characters;

import logic.icecells.IceCell;
import logic.icecells.StableIceCell;
import logic.icecells.UnstableIceCell;
import logic.icecells.WaterCell;
import logic.items.Items;
import logic.items.PlayerActions;
import logic.Way;
import logic.items.BackPack;

import java.util.Scanner;

import static logic.Way.up;

public abstract class Character {
	private int maxBodyHeat;
	private int bodyHeat;
	private int turnsInWater = 0;
	private boolean wearingDivingSuit = false;
	private Way facingWay = Way.up;
	private IceCell ownCell;
	private BackPack backpack;
	private static int maxActions = 4;
	private int actionsLeft;

	Character() { }

	public void move() {
		System.out.println("Character.move meghívódott");

		ownCell = new StableIceCell();
		ownCell.getNeighbour(facingWay);
		ownCell.removeCharacter(this);
		IceCell neighbour;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Milyen cellára akar lépni?");
		System.out.println("1: unstable, 2: stable, 3: water");
		String cell = scanner.nextLine();
		switch (cell){
			case "1":
				neighbour = new UnstableIceCell();
				neighbour.accept(this);
				break;
			case "2":
				neighbour = new StableIceCell();
				neighbour.accept(this);
				break;
			case "3":
				neighbour = new WaterCell();
				neighbour.accept(this);
				break;
			default: break;
		}
	}
	public void dig(boolean withShovel) {
		System.out.println("Character.dig meghívódott");
		ownCell = new StableIceCell();
		ownCell.loseSnow(withShovel);
	}
	public void mine() {
		System.out.println("Character.mine meghívódott");
		ownCell = new StableIceCell();
		ownCell.mine(this);
	}
	public void gainOneHeat() {
		System.out.println("Character.gainOneHeat meghívódott");
	}
	public void loseOneHeat() {
		System.out.println("Character.loseOneHeat meghívódott");
	}
	public void setOwnCell(IceCell ic) {
		System.out.println("Character.setOwnCell meghívódott");
	}
	public IceCell getOwnCell() {
		System.out.println("Character.getOwnCell meghívódott");
		return new StableIceCell();
	}
	public void addOneTurnInWater() {
		System.out.println("Character.addOneTurnInWater meghívódott");
	}
	public int getTurnsInWater() {
		System.out.println("Character.getTurnsInWater meghívódott");
	}
	public void resetTurnsInWater() {
		System.out.println("Character.resetTurnsInWater meghívódott");
	}
	public boolean putItemtoBackPack(Items it, PlayerActions pa) {
		System.out.println("Character.putItemtoBackPack meghívódott");
		backpack = new BackPack();
		return backpack.addItem(it, pa);
	}
	public void wearDivingSuit() {
		System.out.println("Character.wearDivingSuit meghívódott");
	}
	public boolean getDivingSuit() {
		System.out.println("Character.getDivingSuit meghívódott");
	}
	public void setFacingWay(Way w) {
		System.out.println("Character.setFacingWay meghívódott");
	}
	public Way getFacingWay() {
		System.out.println("Character.getFacingWay meghívódott");
	}
	public void useItem(PlayerActions pa) {
		System.out.println("Character.useItem meghívódott");
		backpack = new BackPack();
		backpack.hasItem(pa).use(this);
	}
	public void useEssentials() {
		System.out.println("Character.useEssentials meghívódott");
		Items e = backpack.hasItem(PlayerActions.assemblingEssentials);
		e.use(this);
	}
	public int getBodyHeat() {
		System.out.println("Character.getBodyHeat meghívódott");
	}
	public BackPack getBackPack(){
		System.out.println("Character.getBackPack meghívódott");
	}
	public int getActionsLeft(){
		System.out.println("Character.getActionsLeft meghívódott");
	}
	public void resetActionsLeft(){
		System.out.println("Character.resetActionsLeft meghívódott");
	}
	public void loseOneAction(){
		System.out.println("Character.loseOneAction meghívódott");
	}

	public abstract void ability();
}
