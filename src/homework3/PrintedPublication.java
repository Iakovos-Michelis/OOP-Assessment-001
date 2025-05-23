package homework3;

public class PrintedPublication extends Publication {

    private boolean isHardCover;
    private int TotalPages;
    private String Publisher;
    private int StockCount;

    // Creating a printed book with print details
    public PrintedPublication(String ID, String Title, double cost, String Author,
                              boolean isHardCover, int TotalPages, String Publisher, int StockCount) {
        super(ID, Title, cost, Author);
        this.isHardCover = isHardCover;
        this.TotalPages = TotalPages;
        this.Publisher = Publisher;
        this.StockCount = StockCount;
    }

    // Showing full details including print info
    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Format: " + (isHardCover ? "Hardcover" : "Paperback"));
        System.out.println("Pages: " + TotalPages);
        System.out.println("Publisher: " + Publisher);
        System.out.println("Stock: " + StockCount + " copies available");
    }
}