package logic.items;

import logic.Way;
import logic.characters.Character;

public class Rope implements Items {

	public void use(Character actualch) {
		System.out.println("Rope.use meghívódott");
	}
	public boolean equip(Character ch) {
		System.out.println("Rope.equip meghívódott");
	}
}
