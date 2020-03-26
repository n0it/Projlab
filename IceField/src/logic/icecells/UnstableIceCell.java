package logic.icecells;

import logic.IceField;
import logic.Way;
import logic.characters.Character;

public class UnstableIceCell extends IceCell  {
	private boolean hasIgloo = false;


	public UnstableIceCell(){

	}

	public boolean setIgloo(boolean b) {
		System.out.println("UnstableIceCell.setIgloo meghívódott");
	}
	public void snowing() {
		System.out.println("UnstableIceCell.snowing meghívódott");
	}
	public void accept(Character ch) {
		System.out.println("UnstableIceCell.accept meghívódott");
	}

}
