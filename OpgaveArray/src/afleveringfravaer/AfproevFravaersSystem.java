package afleveringfravaer;

public class AfproevFravaersSystem {

    public static void main(String[] args) {
        int[][] fravaer18V = { { 2, 0, 0, 0, 3, 1, 0, 2, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 2, 0, 0, 0, 3, 1, 0, 2, 0, 0, 0, 0 }, { 1, 2, 1, 2, 1, 2, 0, 2, 0, 0, 4, 0 },
                { 5, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0 } };
        int elevNr = +1;
        FravaersSystem karakterSystem = new FravaersSystem();
        karakterSystem.udskrivFravaer(fravaer18V);
        System.out.println();
        karakterSystem.samletFravaer(fravaer18V, elevNr);
        System.out.println();
        karakterSystem.gennemsnit(fravaer18V, elevNr);
        System.out.println();
        karakterSystem.antalUdenFravaer(fravaer18V);
        System.out.println();
        System.out.println("Elev med mest mest fravær er: " + karakterSystem.mestFravaer(fravaer18V));
        System.out.println();
        karakterSystem.nulstil(fravaer18V, 1);
        karakterSystem.udskrivFravaer(fravaer18V);
    }
}
