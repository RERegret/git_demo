import java.util.Scanner;
import java.util.TreeMap;
public class Main {
    public static void main(String[] args) {
        Scanner scanStuff = new Scanner(System.in);

        System.out.println("Choose your application! \n1: Finance planner \n2: BMI calculator \n3: ... \n0: Exit");

        switch (scanStuff.nextLine()){
            case "0":
                System.out.println("Have a nice day!");
                System.exit(0);
                break;
            case "1":
                netCalculation(scanStuff);
                break;
            case "2":
                bmiCalculator(scanStuff);
                break;
            default:
                System.out.println("Choose an appropriate option!");
                break;
        }
    }

    public static void netCalculation(Scanner scanStuff)
    {
        int income = 0;
        int expendable;
        TreeMap<String, Integer> monthlyExpenses = new TreeMap<>();
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

        expendable = Math.toIntExact(Math.round(income * 0.665));
        System.out.println("After taxes, you are making " + expendable + "EUR a month!");

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

        System.out.println("What type of fix expenses (rent, etc...) do you have on a monthly basis? Give them in 'expense type,paid amount' format, and type 'exit' in 'expense type' when you want to stop.");
        while(!monthlyExpenses.containsKey("exit")){
            try {
                String[] expenses = scanStuff.nextLine().split(",");
                monthlyExpenses.put(expenses[0], Integer.parseInt(expenses[1]));
            } catch (Exception e) {
                System.out.println("Give them in the 'expense type,paid amount' format!");
            }

        }
        monthlyExpenses.remove("exit");

        for (String i : monthlyExpenses.keySet()) {
            System.out.println("\nExpense type: " + i + "\nPaid amount: " + monthlyExpenses.get(i) + "EUR");
            expendable -= monthlyExpenses.get(i);
        }
        System.out.println("\nRemaining money after paying all your fix expenses: "+expendable +"EUR ");
    }

    public static void bmiCalculator(Scanner scanStuff){
        double bmi;
        double weight=0;
        double height=0;
        boolean correctInput;
        String[] parameters;
        System.out.println("Welcome to BMI calculator!\nTo get started, do tell me:");

        do {
            System.out.println("Do you use the Metric(1), or the Imperial(2) system?");
            switch (scanStuff.nextLine()) {
                case "1":
                    System.out.println("What's your weight in kg, and height in cm using 'kg,cm' format?");
                    try {
                        parameters = scanStuff.nextLine().split(",");
                        weight = Double.parseDouble(parameters[0]);
                        height = Double.parseDouble(parameters[1]) / 100.0;
                        correctInput = true;
                        break;
                    }catch (Exception e)
                    {
                        System.out.println("Use the correct input format!\n");
                        correctInput = false;
                        break;
                    }

                case "2":
                    System.out.println("What's your weight in lb, and height in feet and inches using 'lb,feet,inches' format?");
                    
                    try {
                        parameters = scanStuff.nextLine().split(",");
                        weight = 0.4536 * Double.parseDouble(parameters[0]);
                        height = ((30.48 * Double.parseDouble(parameters[1])) + (2.54 * Double.parseDouble(parameters[2]))) / 100.0;
                        correctInput = true;
                        break;
                    }catch (Exception e)
                    {
                        System.out.println("Use the correct input format!\n");
                        correctInput = false;
                        break;
                    }
                default:
                    correctInput = false;

            }
        }while (!correctInput) ;

        bmi = weight / Math.pow(height,2);

        if (bmi <18.5)
        {
            System.out.println("Your BMI value is the following: " + bmi + "\nThis value is considered underweight.");
        } else if (bmi <25.0)
        {
            System.out.println("Your BMI value is the following: " + bmi + "\nThis value is considered normal.");
        } else if (bmi <30.0)
        {
            System.out.println("Your BMI value is the following: " + bmi + "\nThis value is considered overweight.");
        } else
        {
            System.out.println("Your BMI value is the following: " + bmi + "\nThis value is considered obese.");
        }

        }
    }