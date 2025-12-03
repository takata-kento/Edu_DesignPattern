package com.example.edu_design_pattern;


import com.example.edu_design_pattern.active_object.ActiveObjectEngine;
import com.example.edu_design_pattern.active_object.DelayedTyperCommand;
import com.example.edu_design_pattern.active_object.SleepCommand;
import com.example.edu_design_pattern.builder.RiskUser;
import com.example.edu_design_pattern.builder.StandardUser;
import com.example.edu_design_pattern.builder.User;
import com.example.edu_design_pattern.command.HourlyClassification;
import com.example.edu_design_pattern.command.PayClassification;
import com.example.edu_design_pattern.command.SalariedClassification;
import com.example.edu_design_pattern.command.TimeCard;
import com.example.edu_design_pattern.template_method.BubbleSorter;
import com.example.edu_design_pattern.template_method.DoubleBubbleSorter;
import com.example.edu_design_pattern.template_method.IntBubbleSorter;
import com.example.edu_design_pattern.typesafe_heterogeneous_container.Favorites;

import static com.example.edu_design_pattern.builder.User.Cource.*;
import static com.example.edu_design_pattern.builder.RiskUser.RiskCategory.*;

import java.util.Arrays;
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

		// 動作が重たいのでコメントアウトする
		// System.out.println("======Active Objectパターン======");
		// ActiveObjectEngine engine = new ActiveObjectEngine();
		// engine.addCommand(new DelayedTyperCommand(100, '1', engine));
		// engine.addCommand(new DelayedTyperCommand(300, '3', engine));
		// engine.addCommand(new DelayedTyperCommand(500, '5', engine));
		// engine.addCommand(new DelayedTyperCommand(700, '7', engine));
		// engine.addCommand(new SleepCommand(DelayedTyperCommand::stopExecute, engine, 20000));
		// engine.run();

		System.out.println("======Template Methodパターン======");
		BubbleSorter<Integer> sorterInt = new IntBubbleSorter();
		BubbleSorter<Double> sorterDouble = new DoubleBubbleSorter();
		Integer[] intList = {2,1,5,3,4};
		Double[] doubleList = {1.445, 5.22212, 5.11123, 4.9837, 3.5876};
		sorterInt.sort(intList);
		sorterDouble.sort(doubleList);
		Arrays.stream(intList).forEach(System.out::println);
		Arrays.stream(doubleList).forEach(System.out::println);

		System.out.println("======Builderパターン======");
		StandardUser standardUser = new StandardUser.Builder().addCource(AUTOMOBILE).build();
		RiskUser riskUser = new RiskUser.Builder(SMOKING).addCource(MEDIUM_MOTORCYCLE).addCource(LARGE_MOTORCYCLE).build();
		List<User> userList = List.of(standardUser, riskUser);
		userList.stream().forEach(System.out::println);
	
		System.out.println("======型安全な異種コンテナ======");
		Favorites favorites = new Favorites();
		favorites.putFavorite(String.class, "java");
		favorites.putFavorite(Integer.class, 12345);
		favorites.putFavorite(Class.class, Favorites.class);
		String favoriteString = favorites.getFavorite(String.class);
		int favoriteInt = favorites.getFavorite(Integer.class);
		Class<?> favoriteFavorites = favorites.getFavorite(Class.class);
	
		System.out.println(favoriteString + " " + favoriteInt + " " + favoriteFavorites);
	}
}
