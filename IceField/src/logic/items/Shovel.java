package logic.items;

import logic.characters.Character;

public class Shovel implements Items {

	public void use(Character actualch) {
		System.out.println("Shovel.use meghívódott");
	}
	public boolean equip(Character ch) {
		System.out.println("Shovel.equip meghívódott");
	}
}
