package logic.characters;

import logic.Way;
import logic.icecells.IceCell;

public class Explorer extends Character {

	public Explorer() {

	}

	public void ability() {
		System.out.println("Character.ability meghívódott");
		IceCell ic = getOwnCell();
		Way w = getFacingWay();
		IceCell neighbour = ic.getNeighbour(w);
		neighbour.setCapacityKnown();
	}
}
