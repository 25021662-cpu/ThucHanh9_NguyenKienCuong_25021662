package com.banking;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Customer customer = new Customer("Nguyen Kien Cuong");
        bank.addCustomer(customer);

        try {
            Account savings = new SavingAccount("SA001", 1000.0);
            customer.addAccount(savings);

            System.out.println("--- GIAO DỊCH HỢP LỆ ---");
            savings.deposit(500.0);
            savings.withdraw(200.0);

            System.out.println("\n--- GIAO DỊCH SINH CẢNH BÁO (WARN) ---");
            savings.withdraw(5000.0); // Rút quá số dư

        } catch (BankException e) {
            System.out.println(">> Báo lỗi: " + e.getMessage());
        }

        try {
            Account checking = new CheckingAccount("CA002", 500.0);
            System.out.println("\n--- GIAO DỊCH SINH LỖI (ERROR) ---");
            checking.withdraw(2000.0); // Rút vượt hạn mức thấu chi
        } catch (BankException e) {
            System.out.println(">> Báo lỗi: " + e.getMessage());
        }
    }
}