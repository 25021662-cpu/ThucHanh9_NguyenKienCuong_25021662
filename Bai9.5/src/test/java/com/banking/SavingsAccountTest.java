package com.banking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {
    @Test
    public void testDeposit() throws BankException {
        SavingsAccount account = new SavingsAccount("SA001", 1000.0);
        account.deposit(500.0);

        assertEquals(1500.0, account.getBalance());
    }
}