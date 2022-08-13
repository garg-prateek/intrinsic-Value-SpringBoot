package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.OutputVariable;
import com.example.demo.service.CashFlow;

@SpringBootApplication
public class IntrinsicValueClaculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntrinsicValueClaculatorApplication.class, args);

		CashFlow cashFlow = new CashFlow();
		OutputVariable output = cashFlow.averageCashFlow();
		System.out.println(output);
	}

}
