package com.example.edu_design_pattern;


import com.example.edu_design_pattern.active_object.ActiveObjectEngine;
import com.example.edu_design_pattern.active_object.DelayedTyperCommand;
import com.example.edu_design_pattern.active_object.SleepCommand;
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

		System.out.println("======Active Objectパターン======");
		ActiveObjectEngine engine = new ActiveObjectEngine();
		engine.addCommand(new DelayedTyperCommand(100, '1', engine));
		engine.addCommand(new DelayedTyperCommand(300, '3', engine));
		engine.addCommand(new DelayedTyperCommand(500, '5', engine));
		engine.addCommand(new DelayedTyperCommand(700, '7', engine));
		engine.addCommand(new SleepCommand(DelayedTyperCommand::stopExecute, engine, 20000));
		engine.run();
	}
}
