package service;

import model.Account;
import model.Transaction;
import model.TransactionType;
import model.User;
import repository.BankRepository;

import java.time.LocalDate;

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
}
