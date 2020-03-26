package logic;

public class WinChecker {
	private int assemblingEssentials = 0;
	private static int maxEssentials = 3;

	public void addEssentials(int i) {
		System.out.println("WinChecker.addEssentials meghívódott");
	}
	public void resetAssembledItems() {
		System.out.println("WinChecker.resetAssembledItems meghívódott");
	}
	public boolean isAssembled() {
		System.out.println("WinChecker.isAssembled meghívódott");
		return true;
	}
}
