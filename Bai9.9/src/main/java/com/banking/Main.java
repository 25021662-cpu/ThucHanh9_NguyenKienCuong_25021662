package com.banking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    // 1. Khai báo Logger cho class Main (Thay thế cho việc in ra Console thủ công)
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Bank bank = new Bank();
        Customer customer = new Customer("Nguyen Kien Cuong");
        bank.addCustomer(customer);

        try {
            Account savings = new SavingAccount("SA001", 1000.0);
            customer.addAccount(savings);

            // 2. Sử dụng INFO để đánh dấu các mốc quan trọng
            logger.info("--- BAT DAU CHUOI GIAO DICH HOP LE ---");
            savings.deposit(500.0);
            savings.withdraw(200.0);

            // 3. Sử dụng WARN cho các tình huống cần lưu ý (như rút quá số dư nhưng chưa văng Exception)
            logger.warn("--- THU NGHIEM GIAO DICH CO THE SINH CANH BAO (WARN) ---");
            savings.withdraw(5000.0);

        } catch (BankException e) {
            // 4. Sử dụng ERROR và Parameterized Logging ({}) để ghi log lỗi chuyên nghiệp
            logger.error("Da xay ra loi nghiep vu: {}", e.getMessage());
        }

        try {
            Account checking = new CheckingAccount("CA002", 500.0);
            logger.info("--- THU NGHIEM GIAO DICH VUOT HAN MUC (ERROR) ---");
            checking.withdraw(2000.0);
        } catch (BankException e) {
            // Không dùng dấu "+" để cộng chuỗi, hãy dùng {} để tối ưu hiệu suất
            logger.error("Loi nghiep vu tai khoan Checking: {}", e.getMessage());
        }

        logger.info("--- KET THUC CHUONG TRINH ---");
    }
}