import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        netCalculation();

    }

    public static void netCalculation()
    {

        Scanner scanStuff = new Scanner(System.in);
        int income = 0;
        String response;

        System.out.println("Welcome to Finance manager! \nTo get started, do tell me:");

        do {
            boolean incomeScanning = false;
            System.out.println("How much do you make per month before taxes in EUR?");


            while (!incomeScanning) {
                try {
                    income = Integer.parseInt(scanStuff.nextLine());
                    incomeScanning = true;
                } catch (Exception e) {
                    System.out.println("Please give your income as an integer number!");
                }
            }

            System.out.println("You've entered " + income + " as your monthly income before taxes. Is that correct? y/n");

            response = scanStuff.nextLine();

            while (!response.equals("y") && !response.equals("yes") && !response.equals("n") && !response.equals("no")) {
                System.out.println("Please enter y/n as your answer!");

                response = scanStuff.nextLine();
            }


        } while (!response.equals("y") && !response.equals("yes"));

        System.out.println("After taxes, you are making " + (Math.round(income * 0.335)) + "EUR a month!");

        System.out.println("\nWould you like to add your monthly expenses to see how much leftover money you have? y/n");


        do {
            response = scanStuff.nextLine();

            if (!response.equals("y") && !response.equals("yes") && !response.equals("n") && !response.equals("no")) {
                System.out.println("Please enter y/n as your answer!");
            }

        } while (!response.equals("y") && !response.equals("yes") && !response.equals("n") && !response.equals("no"));

        if (response.equals("n") || response.equals("no")) {
            System.out.println("\nThank you for using our service, have a nice day!");

            System.exit(0);
        }

    }

}