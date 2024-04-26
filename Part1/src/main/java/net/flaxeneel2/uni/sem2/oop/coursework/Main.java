package net.flaxeneel2.uni.sem2.oop.coursework;


public class Main {
    
    public static void main(String[] args) {
        startRace();
    }


    public static void testEncapsulation() {
        Horse horse = new Horse('a', "horse1", 0.5);
        //This code will error:

//        System.out.println(horse.name);
//        System.out.println(horse.confidence);
//        System.out.println(horse.symbol);
//        horse.name = "Horse 1";
//        horse.confidence = 0.4;
//        horse.symbol = 'b';

        //This code does not error:


        horse.setName("b");
        horse.setConfidence(0.4);
        horse.setSymbol('b');
        System.out.println(horse.getName());
    }

    /**
     * Start a test race.
     */
    public static void startRace() {
        Race race = new Race(20);
        race.addHorse(new Horse('♕', "horse1", 0.5), 1);
        race.addHorse(new Horse('b', "horse2", 0.9), 2);
        race.addHorse(new Horse('c', "horse3", 0.25), 3);
        race.startRace();
    }
}
