package homework5;

public class Animals {
    private String Name;
    private String FirstLetter;
    private String ImagePath;

    // Add an animal with a name, letter, and image path
    public Animals(String Name, String FirstLetter, String ImagePath) {
        this.Name = Name;
        this.FirstLetter = FirstLetter;
        this.ImagePath = ImagePath;
    }


    public String getName() {
        return Name;
    }

    public String getFirstLetter() {
        return FirstLetter;
    }

    public String getImagePath() {
        return ImagePath;
    }
}