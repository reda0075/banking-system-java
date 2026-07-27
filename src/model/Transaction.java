package model;

import java.time.LocalDate;

public class Transaction {
   private int id;
    private LocalDate date ;
    private TransactionType type;
    private double amount;
    private String description;

    public Transaction(int id, LocalDate date, TransactionType type, double amount, String description) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", date=" + date +
                ", type=" + type +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
