package homework3;

import java.util.ArrayList;

public class BookEshop {

    public static void main(String[] args) {
        ArrayList<Publication> collection = new ArrayList<>();

        // Add sample publications
        collection.add(new AudioPublication("AUDIO1", "CAN'T HURT ME", 19.99, "DAVID GOGGINS", 720, "CREE SUMMER"));
        collection.add(new Ebook("EBOOK2", "BALL IS LIFE", 24.99, "PANAGIOTIS GIANNAKIS", 2500));
        collection.add(new PrintedPublication("PAPER3", "PYTHON BASICS", 49.99, "DAVID AMOS",
                true, 700, "REAL PYTHON", 100));
        collection.add(new PrintedPublication("PAPER4", "STRENGTH", 17.99, "MIKE TYSON",
                false, 200, "HARPER SPORT", 200));

        // Showing publication details
        for (Publication item : collection) {
            item.showDetails();
            System.out.println("-----------------------------");
        }
    }
}