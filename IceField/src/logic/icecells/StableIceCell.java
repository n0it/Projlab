package logic.icecells;

import logic.IceField;
import logic.characters.Character;
import logic.items.Items;
import logic.items.Rope;

public class StableIceCell extends IceCell  {
	private boolean hasIgloo = false;
	private Items item;

	public StableIceCell(){ }

	private void removeItem() {
		System.out.println("StableIceCell.removeItem meghívódott");
	}
	public void mine(Character ch) {
		System.out.println("StableIceCell.mine meghívódott");
		item = new Rope();
		item.equip(ch);
		removeItem();
	}
	public boolean setIgloo(boolean b) {
		System.out.println("StableIceCell.setIgloo meghívódott");
		return false;
	}

	public void snowing() {
		System.out.println("StableIceCell.snowing meghívódott");
	}
	public void accept(Character ch) {
		System.out.println("StableIceCell.accept meghívódott");
		addCharacter(ch);
		ch.setOwnCell(this);
	}
}
