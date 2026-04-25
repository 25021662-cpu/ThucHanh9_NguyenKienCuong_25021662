package com.banking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckingAccount extends Account {
    private static final Logger logger = LoggerFactory.getLogger(CheckingAccount.class);
    private final double overdraftLimit = 500.0;

    public CheckingAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    public void withdraw(double amount) throws BankException {
        if (amount <= 0) {
            throw new InvalidFundingAmountException("Số tiền rút phải lớn hơn 0");
        }
        if (balance + overdraftLimit - amount < 0) {
            logger.error("Giao dịch từ chối! Tài khoản {} vượt quá hạn mức thấu chi khi rút ${}", accountNumber, amount);
            throw new InsufficientFundsException("Vượt quá hạn mức thấu chi");
        }
        balance -= amount;
        logger.info("Đã rút ${} từ tài khoản vãng lai {}. Số dư mới: ${}", amount, accountNumber, balance);
    }
}