import model.Account;
import model.Transaction;
import model.TransactionType;
import model.User;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("User");
        User user1 = new User(1,"reda","elhamdaoui","redaa","reda1234");
        System.out.println(user1);
        System.out.println("Account");
       Account acc1 = new Account(1,10000.00,user1);
        System.out.println(acc1);
        System.out.println("Transaction");
        Transaction trs1 = new Transaction(1, LocalDate.of(2026, 7, 27),TransactionType.DEPOSIT, 500, "Transaction1");
        System.out.println(trs1);



    }
}