package main.matvey.russkov.lab2;

public class BankOne extends Bank implements FirstBank{
    @Override
    void whoIAm(){
        System.out.println("Bank One:");
    }
}
