package logic.characters;

import logic.icecells.IceCell;
import logic.items.Items;
import logic.items.PlayerActions;
import logic.Way;
import logic.items.BackPack;

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

	Character() {

	}

	public void move() {
		System.out.println("Character.move meghívódott");
	}
	public void dig(boolean withShovel) {
		System.out.println("Character.dig meghívódott");
	}
	public void mine() {
		System.out.println("Character.mine meghívódott");
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
	public boolean putItemtoBackPack() {
		System.out.println("Character.putItemtoBackPack meghívódott");
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
	}
	public void useEssentials() {
		System.out.println("Character.useEssentials meghívódott");
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
