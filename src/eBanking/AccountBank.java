package eBanking;

public class AccountBank {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public AccountBank() {
        this.accountNumber = "";
        this.accountHolderName = "";
        this.balance = 0;
    }

    public void deposit(double amount){
        if (amount <= 0){
            System.out.println("You can't deposit negative amount");
            return;
        }
        this.balance += amount;
        System.out.println("Deposit Successfully");
    }

    public void withdraw(double amount){
        if (amount <= 0){
            System.out.println("You can't withdraw negative amount");
            return;
        }
        if (amount > this.balance){
            System.out.println("You don't have enough money");
            return;
        }
        this.balance -= amount;
        System.out.println("Withdraw Successfully");
    }

    public void transfer(String destinationAccountNumber, double amount){
        if (amount <= 0){
            System.out.println("You can't transfer negative amount");
            return;
        }
        if (amount > this.balance){
            System.out.println("You don't have enough money");
            return;
        }
        int destinationAccountIndex = -1;
        for (int i = 0; i < Main.accountBanks.size(); i++){
            AccountBank accountBank = Main.accountBanks.get(i);
            if (accountBank.getAccountNumber().equals(destinationAccountNumber)){
                destinationAccountIndex = i;
            }
        }
        if (destinationAccountIndex == -1){
            System.out.println("Can't find Destination Account");
            return;
        }
        this.balance -= amount;
        AccountBank destinationAccount = Main.accountBanks.get(destinationAccountIndex);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);
    }

    public void displayAccountInfo(){
        System.out.println("Detailed Account Information:");
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Account Holder Name: " + this.accountHolderName);
        System.out.println("Balance: " + this.balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
