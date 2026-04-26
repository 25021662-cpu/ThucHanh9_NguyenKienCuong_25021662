package com.banking;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bank {
    private static final Logger logger = LoggerFactory.getLogger(Bank.class);
    private final List<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
        logger.info("Hệ thống ngân hàng đã được khởi tạo.");
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        logger.debug("Đã thêm khách hàng mới vào hệ thống: {}", customer.getName());
    }
}