package com.example.demo.service;

public class IRPFCalculator {

    public double calculateIRPF(double amount){
        System.out.println("calculateIRPF: " + amount);
        return amount * 0.15;
    }
}
