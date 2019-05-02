package entities;

import exception.InvalidAmountException;
import exception.NotEnoughBalanceException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Account {

    private static final double OVERDRAFT_VALUE = 200;

    private BigDecimal balance;
    // LinkedList because add operations are expected to be more frequent than gets
    private List<Operation> operations;
    private double overdraft;

    public Account(BigDecimal balance, double overdraft) {
        this.balance = balance;
        this.overdraft = overdraft;
        this.operations = new LinkedList<>();
    }

    public Account() {
        this.balance = BigDecimal.ZERO;
        this.overdraft = OVERDRAFT_VALUE;
        this.operations = new LinkedList<>();
    }
    public void deposit(BigDecimal amount) {
        checkAmount(amount);
        BigDecimal oldBalance = this.balance;
        this.balance = this.balance.add(amount);
        this.operations.add(new DepositOperation(amount,oldBalance));
    }

    public void withdraw(BigDecimal amount){
        checkAmount(amount);
        checkBalanceIsSufficient(amount);
        BigDecimal oldBalance = this.balance;
        this.balance = this.balance.subtract(amount);
        this.operations.add(new WithdrawOperation(amount,oldBalance));
    }

    private void checkAmount(BigDecimal amount) {
        if(amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new InvalidAmountException();
    }

    private void checkBalanceIsSufficient(BigDecimal amount) {
        if(amount.compareTo(this.balance.add(BigDecimal.valueOf(this.overdraft))) > 0)
            throw new NotEnoughBalanceException();
    }

    public List<Operation> getOperationsBetween(LocalDate fromDate, LocalDate toDate) {
        return this.operations.stream()
                .filter(operation ->
                        isBetween(fromDate, toDate, operation))
                .collect(Collectors.toList());
    }

    private  boolean isBetween(LocalDate fromDate, LocalDate toDate, Operation operation) {
        return (operation.getDateTime().toLocalDate().isAfter(fromDate) || operation.getDateTime().toLocalDate().isEqual(fromDate))
                && operation.getDateTime().toLocalDate().isBefore(toDate);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    @Override
    public String toString() {
        return "account{" +
                "balance=" + balance +
                ", operations=" + operations +
                ", overdraft=" + overdraft +
                '}';
    }
}
