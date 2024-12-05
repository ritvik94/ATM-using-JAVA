package JAVA;
import java.util.Scanner;

class OptionsMenu 
{
    private Scanner sc = new Scanner(System.in);
    private double checkingBalance = 0;
    private double savingsBalance = 0;

    private void displayMenu() 
    {
        System.out.println("----------Welcome to RITVIK'S ATM----------");
        System.out.print("Please enter your account number: ");
        int accountNumber = sc.nextInt();

        if (isValidAccount(accountNumber)) 
        {
            System.out.print("Please enter your password: ");
            sc.nextLine(); 
            String password = sc.nextLine();

            if (isValidPassword(accountNumber, password)) 
            {
                showAccountOptions();
            } 
            else 
            {
                System.out.println("The password is incorrect");
            }
        } 
        
        else 
        {
            System.out.println("The account number is incorrect");
        }
    }

    private boolean isValidAccount(int accountNumber) 
    {
        return accountNumber == 996255 || accountNumber == 559915;
    }

    private boolean isValidPassword(int accountNumber, String password) 
    {
        return (accountNumber == 996255 && password.equals("mybank99")) ||
               (accountNumber == 559915 && password.equals("myacc94"));
    }

    private void showAccountOptions() 
    {
        while (true) 
        {
            System.out.println("Enter 1 for CHECKING ACCOUNT");
            System.out.println("Enter 2 for SAVINGS ACCOUNT");
            System.out.println("Enter 3 to EXIT");
            System.out.print("Please select the account you want to access: ");
            int accountType = sc.nextInt();

            switch (accountType) 
            {
                case 1:
                    handleCheckingAccount();
                    break;
                case 2:
                    handleSavingsAccount();
                    break;
                case 3:
                    System.out.println("----------Thank you for using RITVIK'S ATM----------");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void handleCheckingAccount() 
    {
        while (true) 
        {
            System.out.println("----------CHECKING ACCOUNT----------");
            System.out.println("Enter 1 to VIEW BALANCE");
            System.out.println("Enter 2 to WITHDRAW MONEY");
            System.out.println("Enter 3 to DEPOSIT MONEY");
            System.out.println("Enter 4 to EXIT");
            System.out.print("Please enter the service you would like to use: ");
            int choice = sc.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.println("The Checking account balance is $" + checkingBalance);
                    break;
                case 2:
                    handleWithdrawal("checking");
                    break;
                case 3:
                    handleDeposit("checking");
                    break;
                case 4:
                    System.out.println("----------Thank you for using RITVIK'S ATM----------");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void handleSavingsAccount() 
    {
        while (true) 
        {
            System.out.println("----------SAVINGS ACCOUNT----------");
            System.out.println("Enter 1 to VIEW BALANCE");
            System.out.println("Enter 2 to WITHDRAW MONEY");
            System.out.println("Enter 3 to DEPOSIT MONEY");
            System.out.println("Enter 4 to EXIT");
            System.out.print("Please enter the service you would like to use: ");
            int choice = sc.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.println("The Savings account balance is $" + savingsBalance);
                    break;
                case 2:
                    handleWithdrawal("savings");
                    break;
                case 3:
                    handleDeposit("savings");
                    break;
                case 4:
                    System.out.println("----------Thank you for using RITVIK'S ATM----------");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void handleWithdrawal(String accountType) 
    {
        System.out.print("Please enter the amount to withdraw: ");
        double amount = sc.nextDouble();

        if (accountType.equals("checking")) 
        {
            if (checkingBalance >= amount) 
            {
                checkingBalance -= amount;
                System.out.println("New checking account balance: $" + checkingBalance);
            } 
            else 
            {
                System.out.println("Insufficient funds");
            }
        } 
        else if (accountType.equals("savings")) 
        {
            if (savingsBalance >= amount) 
            {
                savingsBalance -= amount;
                System.out.println("New savings account balance: $" + savingsBalance);
            } 
            else 
            {
                System.out.println("Insufficient funds");
            }
        }
    }

    private void handleDeposit(String accountType) 
    {
        System.out.print("Please enter the amount to deposit: ");
        double amount = sc.nextDouble();

        if (amount <= 0) 
        {
            System.out.println("Invalid amount");
            return;
        }

        if (accountType.equals("checking")) 
        {
            checkingBalance += amount;
            System.out.println("New checking account balance: $" + checkingBalance);
        } 
        else if (accountType.equals("savings")) 
        {
            savingsBalance += amount;
            System.out.println("New savings account balance: $" + savingsBalance);
        }
    }

    public void start() 
    {
        displayMenu();
    }
}

public class atm 
{
    public static void main(String[] args) 
    {
        OptionsMenu atm = new OptionsMenu();
        atm.start();
    }
}
