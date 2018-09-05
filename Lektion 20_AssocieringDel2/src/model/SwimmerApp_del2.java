package model;

import java.util.ArrayList;

public class SwimmerApp_del2 {

    public static void main(String[] args) {

        TrainingPlan_del2 tp1 = new TrainingPlan_del2('A', 16, 10);
        TrainingPlan_del2 tp2 = new TrainingPlan_del2('B', 10, 6);

        ArrayList<Double> lapTimes = new ArrayList<>();
        lapTimes.add(1.02);
        lapTimes.add(1.01);
        lapTimes.add(0.99);
        lapTimes.add(0.98);
        lapTimes.add(1.02);
        lapTimes.add(1.04);
        lapTimes.add(0.99);
        Swimmer_del2 s1 = new Swimmer_del2("Jan", 1994, lapTimes, "AGF", tp1);

        lapTimes = new ArrayList<>();
        lapTimes.add(1.05);
        lapTimes.add(1.01);
        lapTimes.add(1.04);
        lapTimes.add(1.06);
        lapTimes.add(1.08);
        lapTimes.add(1.04);
        lapTimes.add(1.02);
        Swimmer_del2 s2 = new Swimmer_del2("Bo", 1995, lapTimes, "Lyseng", tp2);

        lapTimes = new ArrayList<>();
        lapTimes.add(1.03);
        lapTimes.add(1.01);
        lapTimes.add(1.02);
        lapTimes.add(1.05);
        lapTimes.add(1.03);
        lapTimes.add(1.06);
        lapTimes.add(1.03);
        Swimmer_del2 s3 = new Swimmer_del2("Mikkel", 1993, lapTimes, "AIA-Tranbjerg", tp1);

        ArrayList<Swimmer_del2> swimmers = new ArrayList<>();
        swimmers.add(s1);
        swimmers.add(s2);
        swimmers.add(s3);

        for (Swimmer_del2 s : swimmers) {
            System.out.println(s.getName() + " bedste tid: " + s.bestLapTime());
        }
        s1.setTrainingPlan(tp1);
        s2.setTrainingPlan(tp1);
        s3.setTrainingPlan(tp2);

        System.out.println();

        for (Swimmer_del2 s : swimmers) {
            System.out.println(s.getName() + "'s Træningstid er: " + s.allTrainingHours());
        }
    }

}
