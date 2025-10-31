import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanStuff = new Scanner(System.in);
        int income;
        String response;

        System.out.println("Welcome to Finance manager! To get started, do tell me:");

        do {
            System.out.println("How much do you make per month?");

            income = Integer.parseInt(scanStuff.nextLine());

            System.out.println("You've entered " + income + " as your monthly income. Is that correct? y/n");

            response = scanStuff.nextLine();

            while (!response.equals("y") && !response.equals("n"))
            {
                System.out.println("Please enter y/n as your answer!");

                response= scanStuff.nextLine();
            }


        }
        while (!response.equals("y"));

    }
}