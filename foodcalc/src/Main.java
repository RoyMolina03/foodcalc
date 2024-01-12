import java.util.*;

public class Main {
    public static void main(String[] args) {

        //user object creation for user input
        Scanner user = new Scanner(System.in);

        //variable to hold user choice for menu system
        int choice;

        //menu system
        do {

            System.out.println("Welcome to the Food Ordering Calculator! Calculate how much each individual on an order should pay");
            System.out.println("\n1. Calculate Totals" + "\n2. Calculate Tip" + "\n3. Quit Program.");

            choice = user.nextInt();

            //switch system to route user choice
            switch(choice)
            {
                case 1:
                    calcCost();
                    break;
                case 2:
                    calcTip();
                    break;
                case 3:
                    System.out.println("Thank you for using my program. Cheers!");
                default: //input validation
                    System.out.println("You know that isn't an option. Try again");
            }
        }while (choice != 3);

    }

    public static void calcCost(){

        //user object creation for user input
        Scanner user = new Scanner(System.in);

        //array declaration for costs
        ArrayList<Double> foodCost = new ArrayList<>();

        //variable declaration for number of users and costs
        int numUsers;
        double cost;

        //user input
        System.out.println("How many users are ordering?");
        numUsers = user.nextInt();

        //user input into an array
        for(int i = 0; i < numUsers; i++)
        {
            do {
                System.out.println("Please enter the food cost for User " + (i+1));
                cost = user.nextDouble();

                if (cost < 0)
                    System.out.println("The cost of food can't be negative. Try again");

                }while (cost < 0);

            foodCost.add(cost);
        }

        //fees and taxes variables
        double tip, fees, totalExtra;

        //user inputs w/ do-while loops for input validation
        do {
            System.out.println("How much were you charged in fees + taxes?");
            fees = user.nextDouble();

            if (fees < 0)
                System.out.println("Fees and taxes can't be negative. Try again.");

        }while (fees < 0);

        do{
            System.out.println("How much was the tip?");
            tip = user.nextDouble();

            if (tip < 0)
                System.out.println("The tip can't be negative. Try again");

        }while (tip < 0);

        //calculate total extra cost to add to each individual
        totalExtra = (tip + fees) / numUsers;

        //display results
        for (double d : foodCost)
        {
            int i = 0;
            System.out.println("User " + (i+1) + "'s total is: " + String.format("%.2f", (d + totalExtra)));
            i++;
        }

    }

    public static void calcTip(){

        //user input
        Scanner user = new Scanner(System.in);
        double total;

        //variables to work with
        double tenPer, fifteenPer, twentyPer;

        do {

            System.out.println("How much was the order total? (including tax)");
            total = user.nextDouble();

            if (total < 0)
                System.out.println("The total cannot be negative. Try again.");

        }while (total < 0);

        //calculations
        tenPer = total * 0.10;
        fifteenPer = total * 0.15;
        twentyPer = total * 0.20;

        System.out.println("If you'd like to tip 10%: " + String.format("%.2f", tenPer));
        System.out.println("If you'd like to tip 15%: " + String.format("%.2f", fifteenPer));
        System.out.println("If you'd like to tip 20%: " + String.format("%.2f", twentyPer));
    }
}