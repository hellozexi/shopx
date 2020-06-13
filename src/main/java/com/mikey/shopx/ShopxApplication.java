package com.mikey.shopx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.convert.Jsr310Converters;

@SpringBootApplication
@EntityScan(basePackageClasses = {
        ShopxApplication.class,
        Jsr310Converters.class
})
public class ShopxApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopxApplication.class, args);
    }

}
