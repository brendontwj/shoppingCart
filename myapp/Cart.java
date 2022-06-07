package myapp;
import java.util.*;

public class Cart {

    // Static variables used to store the cart info and index
    static List<String> cart = new ArrayList<>();
    static int i, j;
    static String item;

    public static void main(String[] args) 
    {
        // Initialize scanner and variable for while loop
        Scanner scan = new Scanner(System.in);
        boolean loopRun = true;

        while(loopRun == true)
        {
            // Prompt user for input and scans the first token which is transformed to lowercase
            System.out.println("Enter command: \n");
            String userInput = scan.next().toLowerCase();

            // Switch case using string variable
            switch(userInput)
            {
            case "add":

                // Transforms the rest of line into lower case
                String tempStore = scan.nextLine().toLowerCase();
                // Split full line into single words using comma as delimiter
                String[] tempArr = tempStore.split(",");

                // Check for duplicates
                for(i = 0; i < tempArr.length; i++)
                {
                    for(j = 0; j < cart.size(); j++)
                    {
                        // using trim to remove whitespace and have more accurate comparison
                        if(cart.get(j).equalsIgnoreCase(tempArr[i].trim()))
                        {
                            System.out.println("Error, duplicate " + tempArr[i].trim() + " in cart.");
                            break;
                        }
                    }

                    // If reaches the end of Cart list without duplicate and breaking above loop, is added to cart
                    if(j == cart.size())
                    {
                        cart.add(tempArr[i].trim());
                        System.out.println(tempArr[i].trim() + " added to the cart.");
                    }
                }
                break;

            case "remove":
                int r = scan.nextInt()-1;

                // check if number given is valid index
                if(r >= cart.size())
                {
                    System.out.println("Invalid index given.");
                    break;
                } else
                {
                    System.out.println("Removing " + cart.get(r) + " from the cart");
                    cart.remove(r);
                    break;
                }
            case "list":
                if (cart.size() < 1)
                {
                    System.out.println("Nothing in the cart!");
                } else
                {
                    list();
                }
                break;

            case "end":
                // Change loop variable to false to end loop
                loopRun = false;
                break;

            default:

                // error message if command not recognized
                System.out.println("Invalid command!");
                scan.nextLine();
                break;
            }
        }
            
            System.out.println("Thanks for using the cart.");
            scan.close();
        }

    
    // function to list everything in cart    
    public static void list() {
        for (int i = 0; i< cart.size(); i++)
        {
            System.out.println(i+1 + ". " + cart.get(i));
        }
    }
}