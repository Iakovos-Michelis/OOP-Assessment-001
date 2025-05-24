package homework5;

import java.util.ArrayList;
import java.util.List;

public class AnimalData {

    public static List<Animals> getAllAnimals() {
        List<Animals> animals = new ArrayList<>();

        animals.add(new Animals("Cat", "C", "cat.png"));
        animals.add(new Animals("Dog", "D", "dog.png"));
        animals.add(new Animals("Lion", "L", "lion.png"));


        return animals;
    }
}


