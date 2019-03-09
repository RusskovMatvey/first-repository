package main.matvey.russkov.lab2;

public interface ExchangeRate {
    default double buy(int n, double valBuy){
        return valBuy;
    }

    default double sell(int n, double valSell){
        return valSell;
    }
}
