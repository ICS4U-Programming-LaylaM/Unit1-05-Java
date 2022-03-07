import java.util.Scanner;

/**
* This program asks the user for the width and height of a board
* and displays what the length should be in order to get a board
* foot (144 inches^3). Here is another sentence.
*
* @author Layla Michel
* @version 1.0
* @since 2022-03-02
*/

class BoardFoot {
    /**
    * Declaring variables.
    */
    static Scanner myObj;
    static String userWidth;
    static double userWidthDbl;
    static String userHeight;
    static double userHeightDbl;
    static double userLength;

    /**
    * Creating private constructor due to
    * public/default constructor error.
    *
    * @throws IllegalStateException if there is an issue
    */
    private BoardFoot() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * Creating function to calculate the length of the board.
    *
    * @param width as double
    * @param height as double
    *
    * @return length as double
    */
    public static double calculateBoardFoot(double width, double height) {
        double length = 144 / (width * height);
        return length;
    }

    /**
    * Creating main function.
    *
    * @param args nothing passed in
    */
    public static void main(String[] args) {
        myObj = new Scanner(System.in);

        outerloop: {
            while (true) {
                // Get the width from the user
                System.out.print("Enter the width(inches): ");
                userWidth = myObj.nextLine();

                try {
                    userWidthDbl = Double.parseDouble(userWidth);

                    // Check that width isn't 0 or negative
                    if (userWidthDbl <= 0) {
                        System.out.println("Please enter a valid"
                            + " number.\n");
                    } else {
                        while (true) {
                            // Get the height from the user
                            System.out.print("\nEnter the height(inches): ");
                            userHeight = myObj.nextLine();

                            try {
                                userHeightDbl =
                                Double.parseDouble(userHeight);

                                // Check that height isn't 0 or negative
                                if (userHeightDbl <= 0) {
                                    System.out.println("Please enter a "
                                        + "valid number.\n");
                                } else {
                                    userLength =
                                    calculateBoardFoot(userWidthDbl,
                                         userHeightDbl);
                                    System.out.print("\nThe length should be: "
                                        + userLength + " inches.\n");
                                    break outerloop;
                                }
                            } catch (NumberFormatException ex) {
                                // Error message if input isn't a number
                                System.out.println("Please enter "
                                    + "a valid number.\n");
                            }
                        }
                    }
                } catch (NumberFormatException ex) {
                    // Error message if input isn't a number
                    System.out.println("Please enter a valid number.\n");
                }
            }
        }
        myObj.close();
    }
}
