package logic.items;

import logic.Way;
import logic.characters.Character;
import logic.icecells.IceCell;
import logic.icecells.WaterCell;

public class Rope implements Items {

	public void use(Character actualch) {
		System.out.println("Rope.use meghívódott");
		IceCell own = actualch.getOwnCell();
		Way w = actualch.getFacingWay();
		IceCell water = own.getNeighbour(w);
		water.movePlayerOut(w.opposite());
	}
	public boolean equip(Character ch) {
		System.out.println("Rope.equip meghívódott");
		return ch.putItemtoBackPack(this, PlayerActions.savingWithRope);
	}
}
