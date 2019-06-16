
/**
 * Simulation for rolling a die
 * 
 * @author Javan Oyugi
 */

import java.util.LinkedList;
import java.util.Scanner;

public class DieRollingSimulation {

    /** Die object from class Die */
    protected static Die die = new Die();
    /** List that stores numbers from the rolled die */
    protected static LinkedList<Die.Face> faceShownList = new LinkedList<>();
    /** The number of times the die should be rolled */
    protected static int numberOfRolls = 1000;
    /** The index in the faceShown array */
    protected static int count = 0;
    /** A face on the die */
    protected static int probableNumber;
    /** Frequency of a face containing the number in the probability space */
    protected static int frequency = 0;
    /** Cummilative {@link #frequency frequency} */
    protected static int total = 0;
    /** Cumilative percentage for {@link #total total} */
    protected static float totalPercentage = 0;
    /** The percentage {@link #frequency frequency} */
    protected static float percentageFrequency = 0;

    DieRollingSimulation() {

    }

    public static void main(String args[]) {
        printResults(rollDie());
    }

    public static LinkedList<Die.Face> rollDie() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number of faces of the die:");
            die.setNumberOfFaces(sc.nextInt());
        }
        /** Roll the die 1000 times and store the results */
        for (count = 0; count < numberOfRolls; count++) {
            float faceNum = die.roll();
            Die.Face face = new Die.Face();
            face.setFaceShown(faceNum);
            face.setFaceNum(die.getNumberOfFaces());
            die.setFace(face);
            faceShownList.add(die.getFace());
        }
        /** Calculate the sum */
        return faceShownList;
    }

    public static void printResults(LinkedList<Die.Face> face) {
        System.out.println("Face\tFrequency\t% frequency");
        /** Loop through the numbers in the faces of the die */
        for (probableNumber = 1; probableNumber <= die.getNumberOfFaces(); probableNumber++) {
            frequency = 0;
            for (count = 0; count < faceShownList.size(); count++) {
                if (faceShownList.get(count).getFaceNumber() == probableNumber) {
                    frequency++;
                }
            }
            percentageFrequency = (float) 100 * frequency / numberOfRolls;
            total += frequency;
            totalPercentage += percentageFrequency;
            System.out.println(probableNumber + "\t" + frequency + "\t\t" + percentageFrequency);
        }
        System.out.println("*********************************************");
        System.out.println("TOTAL" + "\t" + total + "\t\t" + totalPercentage);
        System.out.println("*********************************************");
    }
}
