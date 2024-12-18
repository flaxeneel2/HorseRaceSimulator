# Horse Race simulator

This project is a 2 part project for making a horse race betting simulator.

Part 1 is the start of the program as a text-only program, without features such as statistics, a UI, etc.

Part 2 is the GUI version made using java swing.


## Contributors
- McFarewell (Parts of Part 1)
- Siddhant Misra (Parts of Part 1 and the entirety of Part 2)


## Requirements
- Java 17
- [Maven](https://maven.apache.org/download.cgi) (Tested with 3.9.6)


## Running the program

### Part 1

Ensure you have fulfilled the [requirements](#requirements) above

You can build the project using the following commands:
```shell
git clone https://github.com/flaxeneel2/HorseRaceSimulator
cd HorseRaceSimulator
mvn compile exec:java -pl Part1 -am
```

### Part 2

Ensure you have fulfilled the [requirements](#requirements) above

You can build the project using the following command:
```shell
git clone https://github.com/flaxeneel2/HorseRaceSimulator
cd HorseRaceSimulator
mvn compile exec:java -pl Part2 -am
```


#### Ideal running conditions
- full screen for all 10 lanes
- 1440p screen or larger

#### Known issues with part 2

- More accurate horse odds do not populate on random horses until at least 3 runs have been done with the random horse.
- Light scroll bar thumbs. This seems to be a limitation with recent java swing UIManager as it no longer follows the behaviour as the official documentation would suggest.