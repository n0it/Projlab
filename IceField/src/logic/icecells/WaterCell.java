package logic.icecells;

import logic.IceField;
import logic.Way;
import logic.characters.Character;

public class WaterCell extends IceCell {
	private boolean broken = false;

	public int getIgloo(){
		System.out.println("WaterCell.getIgloo meghívódott");
	}

	public WaterCell(){

	}

	public void setBroken() {
		System.out.println("WaterCell.setBroken meghívódott");
	}
	public boolean movePlayerOut(Way from) {
		System.out.println("WaterCell.movePlayerOut meghívódott");
	}

	public void snowing() {
		System.out.println("WaterCell.snowing meghívódott");
	}
	public void accept(Character ch) {
		System.out.println("WaterCell.accept meghívódott");
	}
}
