package com.banking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Account {
    private static final Logger logger = LoggerFactory.getLogger(Account.class);

    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        logger.info("Tài khoản {} được tạo với số dư ban đầu: ${}", accountNumber, initialBalance);
    }

    public void deposit(double amount) throws InvalidFundingAmountException {
        if (amount <= 0) {
            logger.warn("Cố gắng nạp số tiền không hợp lệ: ${} vào tài khoản {}", amount, accountNumber);
            throw new InvalidFundingAmountException("Số tiền nạp phải lớn hơn 0");
        }
        balance += amount;
        logger.info("Đã nạp ${} vào tài khoản {}. Số dư mới: ${}", amount, accountNumber, balance);
    }

    public abstract void withdraw(double amount) throws BankException;

    public double getBalance() {
        return balance;
    }
}