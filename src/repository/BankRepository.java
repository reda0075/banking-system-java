package repository;
import model.Account;
import model.Transaction;
import model.User;

import java.util.ArrayList ;

public class BankRepository {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Account> accounts = new ArrayList<>();
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public void addUser (User user){
        users.add(user);
    }
    public void addAccount (Account account){
        accounts.add(account);
    }
    public void addTransaction (Transaction transaction){
        transactions.add(transaction);
    }

    public void displayUsers(){
        for (User user:users){
            System.out.println(user);
        }
    }

    public void displayAccounts(){
        for (Account account : accounts){
            System.out.println(account);
        }
    }

    public void displayTransactions(){
        for (Transaction transaction : transactions){
            System.out.println(transaction);
        }
    }
}
