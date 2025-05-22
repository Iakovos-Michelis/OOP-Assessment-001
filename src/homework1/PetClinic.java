package homework1;

import java.util.Scanner;

public class PetClinic {

    public static void main(String[] args) {

        // Loading sample animals
        Animal[] allAnimals = createSampleAnimals();

        Scanner input = new Scanner(System.in);

        // Asking the user the type of animal he is looking for
        System.out.print("Enter animal type (e.g. dog, other): ");
        String desiredType = input.nextLine().trim().toLowerCase();

        // Showing matching animals and counting them
        int totalMatches = showMatchingAnimals(allAnimals, desiredType);

        System.out.println("Found " + totalMatches + " animal(s) of type: " + desiredType);

        input.close();
    }

    // Creating a list of sample animals
    public static Animal[] createSampleAnimals() {
        Animal[] animals = new Animal[10];

        animals[0] = new Animal("Fox", "Fedite");
        animals[1] = new Animal("Hedgehog", "Teruar");
        animals[2] = new Animal("Cat", "Mia");
        animals[3] = new Animal("Raccoon", "Rocky");
        animals[4] = new Animal("Dog", "Bruno");
        animals[5] = new Animal("Armadillo", "Oscar");
        animals[6] = new Animal("Rabbit", "Coco");
        animals[7] = new Animal("Badger", "Ocella");
        animals[8] = new Animal("Marmot", "Pattee");
        animals[9] = new Animal("Weasel", "Ziggy");

        return animals;
    }

    // Showing the animals that match the given type
    public static int showMatchingAnimals(Animal[] all, String type) {
        int count = 0;

        System.out.println("Matching animals:");

        for (Animal a : all) {
            if (a.getType().equalsIgnoreCase(type)) {
                System.out.println("- " + a.getNickname());
                count++;
            }
        }

        return count;
    }
}

