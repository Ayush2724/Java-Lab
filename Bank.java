// Base Account class
class Account {
    String customerName;
    int accountNumber;
    String accountType;
    double balance;

    Account(String name, int accNo, String type, double initialBalance) {
        customerName = name;
        accountNumber = accNo;
        accountType = type;
        balance = initialBalance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void displayBalance() {
        System.out.println("Balance: " + balance);
    }
}

// Savings Account class
class SavAcct extends Account {
    SavAcct(String name, int accNo, double initialBalance) {
        super(name, accNo, "Savings", initialBalance);
    }

    void computeInterest(double rate, int years) {
        double interest = balance * Math.pow((1 + rate / 100), years) - balance;
        balance += interest;
        System.out.println("Interest added: " + interest);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }
}

// Current Account class
class CurAcct extends Account {
    final double MIN_BALANCE = 500.0;
    final double SERVICE_CHARGE = 50.0;

    CurAcct(String name, int accNo, double initialBalance) {
        super(name, accNo, "Current", initialBalance);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            checkMinimumBalance();
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }

    void checkMinimumBalance() {
        if (balance < MIN_BALANCE) {
            balance -= SERVICE_CHARGE;
            System.out.println("Service charge imposed: " + SERVICE_CHARGE);
        }
    }

    void chequeBookFacility() {
        System.out.println("Cheque book facility is available.");
    }
}

// Main class to test the program
public class Bank {
    public static void main(String[] args) {
        SavAcct savings = new SavAcct("Alice", 1001, 1000);
        CurAcct current = new CurAcct("Bob", 2001, 600);

        System.out.println("\n--- Savings Account ---");
        savings.deposit(500);
        savings.computeInterest(5, 2);
        savings.withdraw(300);
        savings.displayBalance();

        System.out.println("\n--- Current Account ---");
        current.deposit(400);
        current.withdraw(600); // triggers service charge
        current.chequeBookFacility();
        current.displayBalance();
    }
}