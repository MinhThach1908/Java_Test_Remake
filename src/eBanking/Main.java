package eBanking;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<AccountBank> accountBanks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Banking System");
        System.out.println("Creating a new bank account...");
        System.out.println("====================================");
        System.out.println("Enter account's number: ");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter account's holder name: ");
        String accountHolderName = scanner.nextLine();
        System.out.println("Enter account's current balance: ");
        double balance = scanner.nextDouble();
        AccountBank account = new AccountBank();
        account.setAccountNumber(accountNumber);
        account.setAccountHolderName(accountHolderName);
        account.setBalance(balance);
        System.out.println("Account registered successfully!");
        System.out.println("====================================");
        account.displayAccountInfo();
        // test deposit
        System.out.println("Test Deposit Method");
        System.out.println("-----------------------------");
        System.out.println("Please enter deposit amount: ");
        double depositAmount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Deposit amount is: " + depositAmount);
        account.deposit(depositAmount);
        System.out.println("Your account balance after deposit is: " + account.getBalance());
        // test withdraw
        System.out.println("==========================================");
        System.out.println("Test Withdraw Method");
        System.out.println("-----------------------------");
        System.out.println("Please enter withdraw amount");
        double withdrawAmount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Withdraw amount is: " + withdrawAmount);
        account.withdraw(withdrawAmount);
        System.out.println("Your account balance after withdraw is: " + account.getBalance());
        // test transfer
        System.out.println("==========================================");
        System.out.println("Test Transfer Method");
        System.out.println("-----------------------------");
        AccountBank destinationAccount = new AccountBank();
        destinationAccount.setAccountNumber("123456789");
        destinationAccount.setAccountHolderName("Huy");
        destinationAccount.setBalance(50000);
        accountBanks.add(destinationAccount);
        accountBanks.add(account);
        System.out.println("Destination Account Info:");
        destinationAccount.displayAccountInfo();
        System.out.println("Please enter transfer amount: ");
        double transferAmount = scanner.nextDouble();
        account.transfer("123456789", transferAmount);
        System.out.println("After Transfer Method");
        System.out.println("My account");
        account.displayAccountInfo();
        System.out.println("Destination account");
        destinationAccount.displayAccountInfo();
    }
}
