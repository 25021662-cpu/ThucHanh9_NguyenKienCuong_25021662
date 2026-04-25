package com.practice.maven;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    // Khởi tạo đối tượng cần test
    private final MathUtils mathUtils = new MathUtils();

    @Test
    public void testAdd() {
        // Kiểm tra phép cộng có ra đúng 5 không (2 + 3 = 5)
        assertEquals(5, mathUtils.add(2, 3), "Phép cộng 2 + 3 phải bằng 5");
    }

    @Test
    public void testDivide() {
        // Kiểm tra phép chia bình thường (10 / 2 = 5)
        assertEquals(5, mathUtils.divide(10, 2), "Phép chia 10 / 2 phải bằng 5");
    }

    @Test
    public void testDivideByZero() {
        // Kiểm tra xem hệ thống có quăng lỗi IllegalArgumentException khi chia cho 0 không
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            mathUtils.divide(10, 0);
        });
        assertEquals("Không thể chia cho 0", exception.getMessage());
    }
}