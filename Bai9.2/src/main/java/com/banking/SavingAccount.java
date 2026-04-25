package com.banking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SavingAccount extends Account {
    private static final Logger logger = LoggerFactory.getLogger(SavingAccount.class);

    public SavingAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    public void withdraw(double amount) throws BankException {
        if (amount <= 0) {
            throw new InvalidFundingAmountException("Số tiền rút phải lớn hơn 0");
        }
        if (balance - amount < 0) {
            logger.warn("Tài khoản {} không đủ số dư để rút ${}", accountNumber, amount);
            throw new InsufficientFundsException("Số dư không đủ");
        }
        balance -= amount;
        logger.info("Đã rút ${} từ tài khoản tiết kiệm {}. Số dư mới: ${}", amount, accountNumber, balance);
    }
}