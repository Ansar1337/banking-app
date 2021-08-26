package BankingApplication;

import java.math.BigDecimal;
import java.util.Scanner;

public class Account {
    // Class variables
    private BigDecimal balance = new BigDecimal("0.0");
    private BigDecimal previousTransaction;
    private final String customerName;
    private final String customerID;

    // Class constructor
    public Account(String customerName, String customerID) {
        this.customerName = customerName;
        this.customerID = customerID;
    }

    // Function for Depositing money
    public void deposit(BigDecimal amount) {
        if (amount.compareTo(balance) != 0) {
            balance = balance.add(amount);
            previousTransaction = amount;
        } else {
            balance = balance.add(amount);
            previousTransaction = amount;
        }
    }

    // Function for Withdrawing money
    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(balance) != 0) {
            balance = balance.subtract(amount);
            previousTransaction = amount;
        } else {
            balance = balance.add(amount);
            previousTransaction = amount;
        }
    }

    // Function showing the previous Transaction
    public void getPreviousTransaction() {
        if (previousTransaction.compareTo(balance) <= 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction.compareTo(balance) >= 0) {
            System.out.println("Withdrawn: " + previousTransaction);
        } else {
            System.out.println("No transaction occurred");
        }
    }

    // Function calculating interest of current funds after a number of years
    public void calculateInterest(BigDecimal years) {
        BigDecimal interestRate = new BigDecimal(".0185");
        BigDecimal interestRate2 = new BigDecimal("100.0");
        BigDecimal newBalance = (balance.multiply(interestRate).multiply(years)).add(balance);
        System.out.println("The current interest rate is: " + (interestRate.multiply(interestRate2)) + "%");
        System.out.println("After " + years + " years, your balance will be " + newBalance);
    }

    // Function showing the Main menu
    public void showMenu() {
        char option = '\0';
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = sc.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            // Case 'A' checks account balance
            // Case 'B' makes a deposit
            // Case 'C' makes a withdrawal
            // Case 'D' shows previous transaction
            // Case 'E' calculates the interest
            // Case 'F' exits the user from their account
            switch (option) {
                case 'A' -> {
                    System.out.println("===============================");
                    System.out.println("Balance = $" + balance);
                    System.out.println();
                }
                case 'B' -> {
                    System.out.println("Enter an amount to deposit: ");
                    BigDecimal amount = sc.nextBigDecimal();
                    deposit(amount);
                    System.out.println();
                }
                case 'C' -> {
                    System.out.println("Enter an amount to withdraw: ");
                    BigDecimal amount2 = sc.nextBigDecimal();
                    withdraw(amount2);
                    System.out.println();
                }
                case 'D' -> {
                    System.out.println("===============================");
                    getPreviousTransaction();
                    System.out.println("===============================");
                    System.out.println();
                }
                case 'E' -> {
                    System.out.println("Enter how many years of accrued interest: ");
                    BigDecimal years = sc.nextBigDecimal();
                    calculateInterest(years);
                }
                case 'F' -> System.out.println("===============================");
                default -> System.out.println("Error: invalid option. Please enter A, B ,C ,D ,E or F");
            }
        } while (option != 'F');
        {
            System.out.println("Thank you for banking with us");
        }
    }
}