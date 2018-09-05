package opgave1;

import java.util.ArrayList;

public class Opgave1Test {

    public static double beregnSamletLøn(ArrayList<Mekaniker> list) {
        double sum = 0.0;

        for (Mekaniker mek : list) {
            sum += mek.getWeeklyPay();
        }
        return sum;
    }

    public static void Mekanikere(ArrayList<Mekaniker> Meks) {
        System.out.println("Liste af mekanikere: ");
        for (Mekaniker mek : Meks) {
            System.out.println(mek.getName());
        }
    }

    public static void main(String[] args) {
        ArrayList<Mekaniker> list = new ArrayList<>();
        ArrayList<Mekaniker> Meks = new ArrayList<>();

        Person p1 = new Person("Frederik Sloth Stræde", "Tordenskjoldsgade");
        Mekaniker m1 = new Mekaniker("Peter Petersen", "Klassevej 43", 2010, 130);
        Værkfører v1 = new Værkfører("Lars Larsen", "Jyskvej", 1993, 150, 2008, 50);
        Mekaniker m2 = new Mekaniker("Poul Poulsen", "Brabrand", 2015, 120);
        Mekaniker m3 = new Mekaniker("Jens Jensen", "Viby", 2013, 200);
        Mekaniker m4 = new Mekaniker("Erik Eriksen", "Aarhus", 1950, 300);
        Synsmand s1 = new Synsmand("Fie Laursen", "Hammel", 2000, 300, 3);

        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);
        list.add(v1);
        list.add(s1);

        Meks.add(s1);
        Meks.add(m1);
        Meks.add(m2);
        Meks.add(m3);
        Meks.add(m4);
        Meks.add(v1);
        Meks.add(s1);

        System.out.println(m4.toString());
        System.out.println();
        System.out.println("Samlet løn: " + Opgave1Test.beregnSamletLøn(list));
        System.out.println();
        System.out.println(v1);
        System.out.println();
        System.out.println(m1);
        System.out.println();
        System.out.println(m1.getWeeklyPay());
        System.out.println();
        System.out.println(v1.getForemanPay());
        System.out.println();
        System.out.println(v1.getWeeklyPay());
        System.out.println();
        System.out.println("Synsmand s1 ugeløn: " + s1.getWeeklyPay());
        System.out.println();
        System.out.println(s1.toString());
        System.out.println();
        Opgave1Test.Mekanikere(Meks);
        System.out.println();
        System.out.println(p1);

    }

}
