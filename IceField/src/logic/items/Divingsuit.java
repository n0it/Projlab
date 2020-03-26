package logic.items;

import logic.characters.Character;

public class Divingsuit implements Items {

	public void use(Character actualch) {
		System.out.println("Divingsuit.use meghívódott");
		actualch.wearDivingSuit();
	}
	public boolean equip(Character ch) {
		System.out.println("Divingsuit.equip meghívódott");
		return false;
	}

}
