//-------------------Task-4 :ATM Interface-----------------


import java.util.Scanner;


public class ATMInterface {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000000.0);
        ATM atm = new ATM(bankAccount);

        System.out.println("!! Welcome to the ATM !!");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                int option = scanner.nextInt();
                atm.processOption(option);
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume invalid input
            }
        }
    }
}


class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient balance!");
            return false;
        }
    }
}

class ATM {
    private BankAccount bankAccount;
    private static final int CHECK_BALANCE = 1;
    private static final int DEPOSIT = 2;
    private static final int WITHDRAW = 3;
    private static final int EXIT = 4;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        Scanner scanner = new Scanner(System.in);

        switch (option) {
            case CHECK_BALANCE:
                System.out.println("Current Balance: Rs. " + String.format("%.2f", bankAccount.getBalance()));
                break;
            case DEPOSIT:
                System.out.print("Enter deposit amount: Rs. ");
                if (scanner.hasNextDouble()) {
                    double depositAmount = scanner.nextDouble();
                    bankAccount.deposit(depositAmount);
                    System.out.println("Deposit successful!");
                } else {
                    System.out.println("Invalid input for deposit amount.");
                    scanner.next(); // Consume invalid input
                }
                break;
            case WITHDRAW:
                System.out.print("Enter withdrawal amount: Rs. ");
                if (scanner.hasNextDouble()) {
                    double withdrawalAmount = scanner.nextDouble();
                    bankAccount.withdraw(withdrawalAmount);
                } else {
                    System.out.println("Invalid input for withdrawal amount.");
                    scanner.next(); // Consume invalid input
                }
                break;
            case EXIT:
                System.out.println("Thanks for using the ATM");
                System.out.println("Have a great day ahead!!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option! Please try again!");
                break;
        }
    }
}

