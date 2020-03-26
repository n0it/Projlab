package logic.items;

import logic.WinChecker;

import java.util.ArrayList;
import java.util.HashMap;

public class BackPack {
	private HashMap<PlayerActions, ArrayList<Items>> obtainedItems = new HashMap<>();

	public Items hasItem(PlayerActions pa) {
		System.out.println("BackPack.hasItem meghívódott");
		switch(pa) {
			case assemblingEssentials:  return new EssentialItem(3, new WinChecker());
			case eating:  return new Food();
			case savingWithRope:  return new Rope();
			case shoveling:  return new Shovel();
			default:   return new Divingsuit();
		}
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
}
