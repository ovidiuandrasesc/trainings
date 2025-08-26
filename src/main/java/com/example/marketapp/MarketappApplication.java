package com.example.marketapp;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Objects;

@SpringBootApplication
public class MarketappApplication {

	public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        System.setProperty("STRIPE_SECRET_KEY", Objects.requireNonNull(dotenv.get("STRIPE_SECRET_KEY")));

        SpringApplication.run(MarketappApplication.class, args);
	}

}
