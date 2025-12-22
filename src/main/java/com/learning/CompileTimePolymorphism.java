package com.learning;

class Addition{

    public int add (int a,int b){
        System.out.println("Adding integer");
        return a+b;
    }

    public double add(double a , double b){
        System.out.println("Adding Double");
        return a+b;
    }
}
    public class CompileTimePolymorphism {

        public static void main(String[] args) {
            Addition addition = new Addition();
            System.out.println(addition.add(1,2));
            System.out.println(addition.add(1.4,3.90));
        }
}
