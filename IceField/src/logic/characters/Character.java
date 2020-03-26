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

	}
	public void dig(boolean withShovel) {

	}
	public void mine() {  }
	public void gainOneHeat() {

	}
	public void loseOneHeat() {

	}
	public void setOwnCell(IceCell ic) { }
	public IceCell getOwnCell() { }
	public void addOneTurnInWater() {}
	public int getTurnsInWater() { }
	public void resetTurnsInWater() { }
	public boolean putItemtoBackPack() {}
	public void wearDivingSuit() {

	}
	public boolean getDivingSuit() { }
	public void setFacingWay(Way w) { }
	public Way getFacingWay() { }
	public void useItem(PlayerActions pa) {

	}
	public void useEssentials() {

	}
	public int getBodyHeat() { }
	public BackPack getBackPack(){ }
	public int getActionsLeft(){  }
	public void resetActionsLeft(){  }
	public void loseOneAction(){  }

	public abstract void ability();
}
