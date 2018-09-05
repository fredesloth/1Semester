package string;

public class StringLektion5 {
    public static void main(String[] arg) {
        // Dette er opgave 2

        String ord1 = "Datamatiker";
        String ord2 = "Uddannelsen";
        String ord3 = ord1 + " " + ord2.toLowerCase();

        System.out.println(ord1.toUpperCase());
        System.out.println(ord2.toLowerCase());
        System.out.println(ord1 + " " + ord2);
        System.out.println(ord3);
        System.out.println(ord3.length());
        System.out.println(ord1.substring(0, 7));
        System.out.println(ord2.substring(2, 7));
        System.out.println(ord3.substring(14, 23));

    }
}
