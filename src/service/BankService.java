package service;

import model.Account;
import model.Transaction;
import model.TransactionType;
import model.User;
import repository.BankRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class BankService {

    private BankRepository repository;
    private int nextTransactionId = 1;






    public BankService(BankRepository repository) {
        this.repository = repository;
    }

    public boolean login(String userName, String pswd){
      User user = repository.findByUsername(userName);
       if (user == null){
           return false;
       }
       if (pswd.equals(user.getPassword())){
           return true;
       };

        return false;
    }


    public boolean deposite(int accountnumber, double amount){
        Account account = repository.findByAccountNbr(accountnumber);
        if (account == null){
            return false;
        }
        account.setBalance(account.getBalance()+amount);
        Transaction transaction = new Transaction(nextTransactionId, LocalDate.now(), TransactionType.DEPOSIT,amount,"Deposit into account " + accountnumber);
        repository.addTransaction(transaction);
        nextTransactionId++;
        return true;
    }

    public boolean withdraw(int accountnumber , double amount){

        Account account = repository.findByAccountNbr(accountnumber);
        if (account == null){
            return false;
        }
            if (account.getBalance()<amount){
                return false;
            }
        account.setBalance(account.getBalance()-amount);

        Transaction transaction = new Transaction(nextTransactionId, LocalDate.now(), TransactionType.WITHDRAW,amount,"Withdraw from account " + accountnumber);
        repository.addTransaction(transaction);
        nextTransactionId++;


        return true;
    }

    public boolean transfer(int accountSender,int accountReciver, double amount){

    Account  senderAccount = repository.findByAccountNbr(accountSender);
        if ( senderAccount == null){
            return false;
        }
        Account receiverAccount = repository.findByAccountNbr(accountReciver);
        if (receiverAccount == null){
            return false;
        }

        if ( senderAccount.getBalance()<amount){
            return false;
        }

        senderAccount.setBalance( senderAccount.getBalance()-amount);
        receiverAccount.setBalance(receiverAccount.getBalance()+amount);

        Transaction transaction = new Transaction(nextTransactionId, LocalDate.now(), TransactionType.TRANSFER,amount,"Transfer from " + accountSender + " to "+accountReciver);
        repository.addTransaction(transaction);
        nextTransactionId++;
        return true;

    }

    public ArrayList<Transaction> getTransactionHistory() {
        return repository.getAllTransactions();
    }
}
