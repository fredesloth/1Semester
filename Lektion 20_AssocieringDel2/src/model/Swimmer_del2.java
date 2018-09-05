package model;

import java.util.*;

/**
 * Modeling a Swimmer
 */
public class Swimmer_del2 {
    private String name;
    private String club;
    private int yearGroup;
    private ArrayList<Double> lapTimes;
    private TrainingPlan_del2 TrainingPlan;

    /**
     * Initialize a new swimmer with name, club, yearGroup, and lap times.
     */

    public Swimmer_del2(String name, int yearGroup, ArrayList<Double> lapTimes, String club,
            TrainingPlan_del2 TrainingPlan) {
        this.name = name;
        this.yearGroup = yearGroup;
        this.lapTimes = lapTimes;
        this.club = club;
        this.TrainingPlan = TrainingPlan;

    }

    /**
     * Return the name of the swimmer
     */
    public String getName() {
        return this.name;
    }

    /**
     * Return the yearGroup of the swimmer
     */
    public int getYearGroup() {
        return this.yearGroup;
    }

    /**
     * Return the club of the swimmer
     */
    public String getClub() {
        return this.club;
    }

    /**
     * Register the club of the swimmer
     *
     * @param club
     */
    public void setClub(String club) {
        this.club = club;
    }

    /**
     * Return the fastest lap time
     */
    public double bestLapTime() {
        double bestTime = 0;
        for (int i = 0; i < lapTimes.size(); i++) {
            if (bestTime < lapTimes.get(i)) {
                bestTime = lapTimes.get(i);
            }
        }
        return bestTime;
    }

    public TrainingPlan_del2 getTrainingPlan() {
        return TrainingPlan;
    }

    public void setTrainingPlan(TrainingPlan_del2 TrainingPlan) {
        this.TrainingPlan = TrainingPlan;
    }

    public int allTrainingHours() {
        int allTrainingHours = TrainingPlan.getWeeklyStrengthHours() + TrainingPlan.getWeeklyWaterHours();
        return allTrainingHours;

    }

}
