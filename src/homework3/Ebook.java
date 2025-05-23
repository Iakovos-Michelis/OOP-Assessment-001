package homework3;

public class Ebook extends Publication {

    private int FileSizeKB;

    // Creating an ebook
    public Ebook(String id, String title, double cost, String author, int FileSizeKB) {
        super(id, title, cost, author);
        this.FileSizeKB = FileSizeKB;
    }

    // Showing full details including file size
    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Format: Digital");
        System.out.println("File Size: " + FileSizeKB + " KB");
    }
}