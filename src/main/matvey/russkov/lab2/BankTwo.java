package main.matvey.russkov.lab2;

public class BankTwo extends Bank implements SecondBank{
    @Override
    void whoIAm(){
        System.out.println("Bank Two:");
    }
}
