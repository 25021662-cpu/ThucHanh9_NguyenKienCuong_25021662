package com.practice.maven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MathUtils {
    // Khởi tạo Logger thay vì dùng System.out.println
    private static final Logger logger = LoggerFactory.getLogger(MathUtils.class);

    public int add(int a, int b) {
        logger.info("Đang thực hiện phép tính cộng: {} + {}", a, b);
        int result = a + b;
        logger.debug("Kết quả của phép cộng là: {}", result);
        return result;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            logger.error("Lỗi: Không thể chia cho 0!");
            throw new IllegalArgumentException("Không thể chia cho 0");
        }
        logger.info("Đang thực hiện phép tính chia: {} / {}", a, b);
        return a / b;
    }
}