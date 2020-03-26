package logic.items;

import logic.WinChecker;
import logic.characters.Character;

public class EssentialItem implements Items {
	private int ID;
	private WinChecker wc;

	public EssentialItem(int id, WinChecker winch){ }

	public void use(Character actualch) {
		System.out.println("EssentialItem.use() meghívódott");
	}
	public boolean equip(Character ch) {
		System.out.println("EssentialItem.equip() meghívódott");
	}
}
