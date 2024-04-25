package net.flaxeneel2.uni.sem2.oop.coursework.util;

import net.flaxeneel2.uni.sem2.oop.coursework.UI.components.Horse;

import java.util.ArrayList;

public class OddsCalculator {
    public static void calculateOdds(ArrayList<Horse> horses) {
        int totalDistance = 0;
        double totalAvgSpeed = 0;
        double totalWinRate = 0;

        double totalOdds = 0;

        for (Horse horse : horses) {
            totalDistance += horse.getHorseData().getTotalDistanceTravelled();
            totalAvgSpeed += horse.getHorseData().getAverageSpeed();
            totalWinRate += getWinRate(horse);
        }
        for (Horse horse : horses) {
            double distanceWeight = (double) horse.getHorseData().getTotalDistanceTravelled() / totalDistance;
            double speedWeight = horse.getHorseData().getAverageSpeed() / totalAvgSpeed;
            double winRateWeight = getWinRate(horse) / totalWinRate;

            double overallWeight = distanceWeight + speedWeight + winRateWeight;

            double horseOdds = overallWeight / (totalDistance + totalAvgSpeed +  totalWinRate);
            if(Double.isNaN(horseOdds)) {
                horse.setOdds(1.0);
                totalOdds = horses.size();
            } else {
                totalOdds+=horseOdds;
                horse.setOdds(horseOdds);
            }
        }

        for(Horse horse : horses) {
            horse.setOdds(horse.getOdds()/totalOdds);
        }

    }

    private static double getWinRate(Horse horse) {
        return ((double) horse.getHorseData().getRacesWon())/((double) horse.getHorseData().getRacesWon() + horse.getHorseData().getRacesLost());
    }
}
