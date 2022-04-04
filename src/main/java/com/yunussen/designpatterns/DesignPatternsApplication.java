package com.yunussen.designpatterns;

import adapter.XCodeAdapter;
import animal.Animal;
import builder.User;
import code.XCode;
import color.BridgeRed;
import color.Color;
import component.ChristmasTree;
import component.ChristmasTreeImpl;
import component.Customer;
import crypt.ACrypt;
import crypt.BCrypt;
import crypt.Crypt;
import decarator.BubbleLights;
import department.Department;
import department.FinancialDepartment;
import department.HeadDepartment;
import department.SalesDepartment;
import facade.Facade;
import factory.FactoryProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import shape.BridgeShape;
import shape.BridgeSquare;
import shape.Shape;
import shape.ShapeCache;
import singleton.SingletonClass;
import singleton.SingletonClassEagerInstance;

import java.math.BigDecimal;

@SpringBootApplication
public class DesignPatternsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DesignPatternsApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        abstractionFactoryPattern();
        builderPattern();
        prototypePattern();
        singletonPattern();
        adapterPattern();
        bridgePattern();
        compositePattern();
        decaratorPattern();
        facadePattern();
    }

    private static void abstractionFactoryPattern() {
        System.out.println("-------ABSTRACTION FACTORY PATTERN-------");
        // get animal instance
        Animal dog = (Animal) FactoryProvider.getFactory("animal").newInstance("dog");
        System.out.println("type of created instance which: " + dog.getType());
        System.out.println("sound of created instance which: " + dog.makeSound());

        //get dog instance
        Animal bear = (Animal) FactoryProvider.getFactory("animal").newInstance("bear");
        System.out.println("type of created instance which: " + bear.getType());
        System.out.println("sound of created instance which: " + bear.makeSound());

        //get red instance
        Color red = (Color) FactoryProvider.getFactory("color").newInstance("red");
        System.out.println("color of created instance which: " + red.getColor());

        //get yellow instance
        Color yellow = (Color) FactoryProvider.getFactory("color").newInstance("yellow");
        System.out.println("color of created instance which: " + yellow.getColor());
    }

    private static void builderPattern() {
        System.out.println("-------BUILDER PATTERN-------");
        User user1 = new User.UserBuilder("Yunus", "Şen")
                .age(24)
                .phone("1234567")
                .address("Fake address 1234")
                .build();
        System.out.println(user1);
    }

    private static void prototypePattern() {
        System.out.println("-------PROTOTYPE PATTERN-------");
        //created 3 instance
        ShapeCache.loadCache();

        Shape clonedShape = (Shape) ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType() + clonedShape.getId());

        Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());

        Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType());
    }

    private static void singletonPattern() {
        System.out.println("-------SINGLETON PATTERN-------");
        //Singleton Example
        SingletonClass singletonExample1 = SingletonClass.getInstance();
        SingletonClass singletonExample2 = SingletonClass.getInstance();

        System.out.println("singletonExample1 ==> " + singletonExample1);
        System.out.println("singletonExample2 ==> " + singletonExample2);

        System.out.println(singletonExample1 == singletonExample2);

        //Singleton Example Eager Initialization
        SingletonClassEagerInstance singletonExampleEagerInitialization1 = SingletonClassEagerInstance.getInstance();
        SingletonClassEagerInstance singletonExampleEagerInitialization2 = SingletonClassEagerInstance.getInstance();

        System.out.println("singletonExampleEagerInitialization1 ==> " + singletonExampleEagerInitialization1);
        System.out.println("singletonExampleEagerInitialization2 ==> " + singletonExampleEagerInitialization2);

        System.out.println(singletonExampleEagerInitialization1 == singletonExampleEagerInitialization2);
    }

    private static void adapterPattern() {
        System.out.println("-------ADAPTER PATTERN-------");
        //CrypteA
        Crypt aCrypt = new ACrypt();
        aCrypt.encrypt("yunus");
        aCrypt.decrypt("yunus");

        //BCrypte
        Crypt bCrypt = new BCrypt();
        bCrypt.encrypt("yunus");
        bCrypt.decrypt("yunus");

        //XCode
        XCode xCode = new XCode();
        Crypt xCodeAdapter = new XCodeAdapter(xCode);
        xCodeAdapter.encrypt("yunus");
        xCodeAdapter.decrypt("yunus");
    }

    private static void bridgePattern() {
        System.out.println("-------BRIDGE PATTERN-------");
        BridgeShape square = new BridgeSquare(new BridgeRed());
        System.out.println(square.draw());
    }

    private static void compositePattern() {
        System.out.println("-------COMPOSITE PATTERN-------");

        Department salesDepartment = new SalesDepartment(
                1, "Sales department");
        Department financialDepartment = new FinancialDepartment(
                2, "Financial department");
        HeadDepartment headDepartment = new HeadDepartment(
                3, "Head department");

        headDepartment.addDepartment(salesDepartment);
        headDepartment.addDepartment(financialDepartment);

        headDepartment.printDepartmentName();
    }

    private static void decaratorPattern() {
        System.out.println("-------DECARATOR PATTERN-------");
        ChristmasTree tree1 = new BubbleLights(new ChristmasTreeImpl());
        //expected: Christmas tree with Bubble Lights
        System.out.println(tree1.decorate());
    }

    private static void facadePattern() {
        System.out.println("-------FACADE PATTERN-------");
        Facade fcd = new Facade();
        Customer customer1 = new Customer();
        customer1.setCustomerId(123);
        customer1.setIdentityNo("1234");
        customer1.setName("yunus");
        fcd.useCredit(customer1, BigDecimal.valueOf(1000));
    }
}
