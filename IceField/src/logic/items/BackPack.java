package logic.items;

import java.util.ArrayList;
import java.util.HashMap;

public class BackPack {
	private HashMap<PlayerActions, ArrayList<Items>> obtainedItems = new HashMap<>();

	public Items hasItem(PlayerActions pa) {
		System.out.println("BackPack.hasItem meghívódott");
	}
	public boolean addItem(Items it, PlayerActions pa) {
		System.out.println("BackPack.addItem meghívódott");
	}
	public Food useFood() {
		System.out.println("BackPack.useFood meghívódott");
	}
	public int getEssentialItemNumber() {
		System.out.println("BackPack.getEssentialItemNumber meghívódott");
	}
	public int getNumber(PlayerActions pa){
		System.out.println("BackPack.getNumber meghívódott");
	}
}
