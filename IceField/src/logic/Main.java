package logic;

import logic.characters.Eskimo;
import logic.characters.Explorer;
import logic.characters.Character;
import logic.icecells.IceCell;
import logic.icecells.StableIceCell;
import logic.items.PlayerActions;
import java.util.ArrayList;
import java.util.Scanner;
//Hibák:
//Rope rossz kiválasztás(Ropeban kommentelve, elv megcsinálva)
//Csökken az food amikor max a hp(Elv useItem ben javítva)
//Nem resetelődött passnál a kör (Elv megcsinálva)

//Teszt:
//Character -> adattag      -> private static int maxActions = 100;
//IceField  -> nextPlayer() -> //if (i == 0) snowStorm();
//IceCell   -> Konstruktor  -> snow = /*r.nextInt(maxSnow + 1)*//*0;
public class Main {

    public static void main(String[] args) {

    }
    public static void action(String ac, IceField field){

    }
    public static int selectPlayer(){

    }
}
