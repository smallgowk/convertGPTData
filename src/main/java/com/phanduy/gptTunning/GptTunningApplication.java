package com.phanduy.gptTunning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GptTunningApplication {

	public static void main(String[] args) {
		SpringApplication.run(GptTunningApplication.class, args);
		System.out.println("Duyuno");
		ProcessPriceThread processPriceThread = new ProcessPriceThread();
		processPriceThread.start();
	}

}
