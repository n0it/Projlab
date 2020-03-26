package logic;

import logic.characters.Eskimo;
import logic.characters.Explorer;
import logic.characters.Character;
import logic.icecells.IceCell;
import logic.icecells.StableIceCell;
import logic.icecells.WaterCell;
import logic.items.PlayerActions;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void SaveWithRope() {
        IceField icef = new IceField();
        IceCell water = new WaterCell();
        IceCell stable = new StableIceCell();
        Character actual = new Explorer();
        Character other = new Explorer();
        icef.usePlayerItem(PlayerActions.savingWithRope);
    }
    public static void main(String[] args) {
        System.out.println("1. Játékos lép egyet");
        System.out.println("2. Hó eltakarítása kézzel a saját mezőről");
        System.out.println("3. Tárgy kibányászása");
        System.out.println("4. Kötél használata");
        System.out.println("5. Képesség használat");
        System.out.println("7. Jelzőpisztoly összerakása");
        System.out.println("8. Hó eltakarítása lapáttal a saját mezőről");
        System.out.println("9. Búvárruha felvétele");
        System.out.println("10. Karakter eszik egy ételt");
        System.out.println("11. Játék vége egy játékos megfulladása miatt");
        System.out.println("12. Hóvihar");
        System.out.println("13. Játék vége egy játékos életerejének elfogyása miatt");
        Scanner actionScan = new Scanner(System.in);
        String ac = actionScan.nextLine();
        switch(ac) {
            case "1" :   break;
            case "2":  break;
            case "3":  break;
            case "4" :  break;
            case "5" :  break;
            case "6" :  break;
            case "7":  break;
            case "8" :  break;
            case "9" :  break;
            case "10" :  break;
            case "11" :  break;
            case "12" :  break;
            case "13" :  break;
            default : System.out.println("Nincs ilyen opció!"); break;
        }
    }
}
