package homework3;

public class Publication {

    protected String id;
    protected String title;
    protected double cost;
    protected String author;

    // Creating a new publication
    public Publication(String ID, String Title, double cost, String Author) {
        this.id = ID;
        this.title = Title;
        this.cost = cost;
        this.author = Author;
    }

    // Showing information about this publication
    public void showDetails() {
        System.out.println("Publication ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + cost);
    }
}