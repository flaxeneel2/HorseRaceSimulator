package net.flaxeneel2.uni.sem2.oop.coursework;


public class Main {
    
    public static void main(String[] args) {
        testRace();
    }


    public static void testEncapsulation() {
        Horse horse = new Horse('a', "horse1", 0.5);
        horse.setName("b");
        horse.setConfidence(0);
        horse.setSymbol('b');
        System.out.println(horse.getName());
    }

    /**
     * Start a test race.
     */
    public static void testRace() {
        Race race = new Race(3);
        race.addHorse(new Horse('♕', "horse1", 1), 1);
        race.addHorse(new Horse('b', "horse2", 1), 2);
        race.addHorse(new Horse('c', "horse3", 1), 3);
        race.startRace();
    }
}
