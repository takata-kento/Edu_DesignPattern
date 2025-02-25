package com.example.edu_design_pattern;


import com.example.edu_design_pattern.command.HourlyClassification;
import com.example.edu_design_pattern.command.PayClassification;
import com.example.edu_design_pattern.command.SalariedClassification;
import com.example.edu_design_pattern.command.TimeCard;

import java.util.Date;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		System.out.println("======Commandパターン======");
		List<PayClassification> employeeClassifications = List.of(
				new SalariedClassification(300000),
				new HourlyClassification(1000, List.of(new TimeCard(new Date(), 4)))
		);

		List<Integer> employeePays = employeeClassifications.stream().map(PayClassification::calculatePay).toList();
		employeePays.forEach(System.out::println);
	}
}
