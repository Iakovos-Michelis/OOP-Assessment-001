package homework1;

// Represents an animal in the clinic with a type and name
public class Animal {

    // Stores the type (species) and name of the animal
    private String type;
    private String nickname;

    // Create a new animal with given type and name
    public Animal(String type, String nickname) {
        this.type = type;
        this.nickname = nickname;
    }

    // Get the type of the animal
    public String getType() {
        return type;
    }

    // Get the name of the animal
    public String getNickname() {
        return nickname;
    }
}