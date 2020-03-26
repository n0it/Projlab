package logic.icecells;

import logic.IceField;
import logic.Way;
import logic.characters.Character;
import logic.characters.Explorer;

public class WaterCell extends IceCell {
	private boolean broken = false;

	public int getIgloo(){
		System.out.println("WaterCell.getIgloo meghívódott");
		return 0;
	}

	public WaterCell(){

	}

	public void setBroken() {
		System.out.println("WaterCell.setBroken meghívódott");
	}
	public boolean movePlayerOut(Way from) {
		System.out.println("WaterCell.movePlayerOut meghívódott");
		Character other = new Explorer();
		other.setFacingWay(from);
		other.move();
		other.resetTurnsInWater();

		return false;
	}

	public void snowing() {
		System.out.println("WaterCell.snowing meghívódott");
	}
	public void accept(Character ch) {
		System.out.println("WaterCell.accept meghívódott");
		System.out.println("WaterCell.accept meghívódott");
		addCharacter(ch);
		ch.addOneTurnInWater();
		ch.setOwnCell(this);
		setBroken();
	}
}
