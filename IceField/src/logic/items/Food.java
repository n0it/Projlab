package logic.items;

import logic.characters.Character;

public class Food implements Items {

	public void use(Character actualch) {
		System.out.println("Food.use() meghívódott");
	}
	public boolean equip(Character ch) {
		System.out.println("Food.equip() meghívódott");
	}
}
