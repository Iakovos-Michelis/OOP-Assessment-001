package homework1;

public class Rectangle {
    public static void main(String[] args) {
        int width = 10;
        int height = 5;

        // top
        for (int i = 0; i < width; i++) {
            System.out.print("* ");
        }
        System.out.println();

        // middle
        for (int i = 0; i < height - 2; i++) {
            System.out.print("*");
            for (int j = 0; j < (width - 2) * 2 + 1; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }

        // bottom
        for (int i = 0; i < width; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}

