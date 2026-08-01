import model.Account;
import model.Transaction;
import model.TransactionType;
import model.User;
import repository.BankRepository;
import service.BankService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        BankRepository repository = new BankRepository();
        BankService service = new BankService(repository);
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        System.out.println("User");
        User user1 = new User(1,"reda","elhamdaoui","redaa","reda1234");
        System.out.println(user1);
        System.out.println("Account");
       Account acc1 = new Account(1,10000.00,user1);
        System.out.println(acc1);
        System.out.println("Transaction");
        Transaction trs1 = new Transaction(1, LocalDate.of(2026, 7, 27),TransactionType.DEPOSIT, 500, "Transaction1");
        System.out.println(trs1);


        do {
            System.out.println("=================================");
            System.out.println("        BANKING SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Login");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. View Transactions");
            System.out.println("6. Exit");
            System.out.print("Choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.println("=== Login ===");
                    System.out.print("User name : ");
                    String userName = scanner.nextLine();
                    System.out.print("Password : ");
                    String pswd = scanner.nextLine();
                    boolean valid = service.login(userName,pswd);
                    if(valid){
                        System.out.print("you are logged successfully");
                    }else {
                        System.out.print("Invalid username or password.");
                    }
                    break;

                case 2:
                    System.out.print("option 2 selected :");
                    System.out.print("Account number : ");
                    int accNbr = scanner.nextInt();
                    System.out.print("Amount : ");
                    double amount = scanner.nextDouble();

                    boolean succes = service.deposit(accNbr,amount);
                    if (succes){
                        System.out.print("Operation completed successfully ");
                    }else {
                        System.out.print("something wrong try again");
                    }
                    break;

                case 3:
                    System.out.print("=== Withdraw ===");
                    System.out.print("Account number : ");
                    accNbr = scanner.nextInt();
                    System.out.print("Amount : ");
                    amount = scanner.nextDouble();

                    succes = service.withdraw(accNbr, amount);
                    if (succes){
                        System.out.print("Operation completed successfully ");
                    }else {
                        System.out.print("something wrong try again");
                    }
                    break;

                case 4:
                    System.out.print("=== Transfer ===");
                    System.out.print("Account sender number : ");
                    accNbr = scanner.nextInt();
                    System.out.print("Account sender number : ");
                    int accNbrReceiver = scanner.nextInt();
                    System.out.print("Amount : ");
                    amount = scanner.nextDouble();

                    succes = service.transfer(accNbr,accNbrReceiver,amount);
                    if (succes){
                        System.out.print("Operation completed successfully ");
                    }else {
                        System.out.print("something wrong try again");
                    }
                    break;

                case 5:
                    System.out.print("=== All transactions ===");
                    ArrayList<Transaction> transactions = service.getTransactionHistory();

                    if (transactions.isEmpty()) {
                        System.out.println("No transactions found.");
                    } else {
                        for (Transaction transaction : transactions) {
                            System.out.println(transaction);
                        }
                    }
                    break;

                case 6:
                    System.out.print("Goodbye!");
                    break;

                default:
                    System.out.print("Invalid choice.");
            }

        } while (choice != 6);


    }
}