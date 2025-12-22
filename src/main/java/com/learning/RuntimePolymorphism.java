package com.learning;

class Car {
    void type() {
        System.out.println("A Car");
    }
}

class Suv extends Car {
    @Override
    void type() {
        System.out.println("A SUV Car");
    }
}

public class RuntimePolymorphism {

    public static void main(String[] args) {
        Car car = new Suv();
        car.type();
    }
}
