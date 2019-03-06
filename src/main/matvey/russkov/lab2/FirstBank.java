package main.matvey.russkov.lab2;

public interface FirstBank extends ExchangeRate {
    double USD_EXCHANGE_RATE_BUY = 66.0;
    double EUR_EXCHANGE_RATE_BUY = 75.0;
    double USD_EXCHANGE_RATE_SELL = 65.7;
    double EUR_EXCHANGE_RATE_SELL = 74.68;

    @Override
    default double buy(int n, double valBuy){
        double ruble;
        if (n == 1) {
            System.out.println("Кол-во покупаемой валюты: " + valBuy + " USD");
            ruble = valBuy * USD_EXCHANGE_RATE_BUY;
        } else {
            System.out.println("Кол-во покупаемой валюты: " + valBuy + " EUR");
            ruble = valBuy * EUR_EXCHANGE_RATE_BUY;
        }
        return ruble;
    }

    @Override
    default double sell(int n, double valSell){
        double ruble;
        if (n == 1) {
            System.out.println("Кол-во продаваемой валюты: " + valSell + " USD");
            ruble = valSell * USD_EXCHANGE_RATE_SELL;
        } else {
            System.out.println("Кол-во продаваемой валюты: " + valSell + " EUR");
            ruble = valSell * EUR_EXCHANGE_RATE_SELL;
        }
        return ruble;
    }
}
