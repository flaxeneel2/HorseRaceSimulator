# Horse Race simulator

This project is a 2 part project for making a horse race betting simulator.

Part 1 is the start of the program as a text-only program, without features such as statistics, a UI, etc.

Part 2 is the GUI version made using java swing.

## Requirements
- Java 17
- Maven (Tested with 3.9.6)


## Running the program

### Part 1

You can build the project using the following commands:
```shell
git clone https://github.com/flaxeneel2/HorseRaceSimulator
cd HorseRaceSimulator
mvn compile exec:java -pl Part1 -am
```

### Part 2

You can build the project using the following command:
```shell
git clone https://github.com/flaxeneel2/HorseRaceSimulator
cd HorseRaceSimulator
mvn compile exec:java -pl Part2 -am
```


#### Known issues with part 2

- More accurate horse odds do not populate on random horses until at least 3 runs have been done with the random horse.
- Light scroll bar thumbs. This seems to be a limitation with recent java swing UIManager as it no longer follows the behaviour as the official documentation would suggest.