package com.yunussen.designpatterns;

import animal.Animal;
import builder.User;
import color.Color;
import factory.FactoryProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class DesignPatternsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DesignPatternsApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		abstractionFactoryPattern();
		builderPattern();

	}

	private static void abstractionFactoryPattern(){
		// get animal instance
		Animal dog= (Animal) FactoryProvider.getFactory("animal").newInstance("dog");
		System.out.println("type of created instance which: "+dog.getType());
		System.out.println("sound of created instance which: "+dog.makeSound());

		//get dog instance
		Animal bear=(Animal) FactoryProvider.getFactory("animal").newInstance("bear");
		System.out.println("type of created instance which: "+bear.getType());
		System.out.println("sound of created instance which: "+bear.makeSound());

		//get red instance
		Color red =(Color) FactoryProvider.getFactory("color").newInstance("red");
		System.out.println("color of created instance which: "+red.getColor());

		//get yellow instance
		Color yellow =(Color) FactoryProvider.getFactory("color").newInstance("yellow");
		System.out.println("color of created instance which: "+yellow.getColor());
	}

	private static void builderPattern(){
		User user1 = new User.UserBuilder("Yunus", "Şen")
				.age(24)
				.phone("1234567")
				.address("Fake address 1234")
				.build();
		System.out.println(user1);
	}
}
