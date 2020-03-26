package logic.icecells;

import logic.IceField;
import logic.Way;
import logic.characters.Character;

public class UnstableIceCell extends IceCell  {
	private boolean hasIgloo = false;

	public UnstableIceCell(){ }

	public boolean setIgloo(boolean b) {
		System.out.println("UnstableIceCell.setIgloo meghívódott");
		return false;
	}
	public void snowing() {
		System.out.println("UnstableIceCell.snowing meghívódott");
	}
	public void accept(Character ch) {
		System.out.println("UnstableIceCell.accept meghívódott");
		addCharacter(ch);
		WaterCell water = new WaterCell();
		for(Way w : Way.values()){
			IceCell neighbour = getNeighbour(w);
			water.addNeighbour(w, neighbour);
			neighbour.addNeighbour(w.opposite(), water);
		}
		water.addCharacter(ch);
		ch.setOwnCell(water);
		ch.addOneTurnInWater();
		water.setBroken();
	}

}
