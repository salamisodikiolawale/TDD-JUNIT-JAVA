package org.example;

import Calculator.Calculator;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(String.valueOf(50).length());
        Calculator calculator = new Calculator();
        Set<Integer> values = calculator.digitsSet(10);
        for(int value: values){
            int v = value;
        }
    }
}