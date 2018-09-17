package com.alex.demo.lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.alex.demo.domain.User;


public class LambdaMain {

	public static void main(String[] args) {
		List<User> users =  Arrays.asList(new User(1, "Alex", "Wanig", 29), 
				new User(5, "Roshan", "Deas", 23),
				new User(3, "New", "User", 29),
				new User(6, "Kamal", "Dias", 30));
		
		users.stream().forEach(user -> System.out.println(user.getFirstName()));

		UserInter inter = user ->System.out.println(user.getFirstName());
		inter.run(users.get(0));
		
		doRun((user) -> System.out.println(user.getFirstName()));
		
		//sort
		Collections.sort(users, (u1, u2) -> u1.getLastName().compareTo(u2.getLastName()));
		users.stream().forEach(user -> System.out.println(user.getFirstName() +": "+user.getLastName()));

		users.stream().filter(user -> user.getLastName().startsWith("D")).forEach(user -> System.out.println(user.getFirstName() +": "+user.getLastName()));

		//anotherway 
		print(users, user -> user.getLastName().startsWith("D"), user -> System.out.println(user.getFirstName() +": "+user.getLastName()));
		//print all
		print(users, user -> true, user -> System.out.println(user.getFirstName() +": "+user.getLastName()));
	}
	
	static void print(List<User> users, Predicate<User> condition, Consumer<User> consumer) {
		for (User user : users) {
			if(condition.test(user))
				consumer.accept(user);
		}
	}
	
	
	static void doRun(UserInter inter) {
		inter.run(new User(1, "Kamal", "Dias", 30));
	}

}

interface UserInter{
	void run(User user);
}
//interface Condition{
//	boolean test(User user);
//}