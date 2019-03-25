package main.matvey.russkov.lab2;

import main.matvey.russkov.lab5.GUI;

public class Bank implements ExchangeRate {
    private double usdExchangeRateBuy;
    private double eurExchangeRateBuy;
    private double usdExchangeRateSell;
    private double eurExchangeRateSell;

    public Bank(double usdExchangeRateBuy, double eurExchangeRateBuy, double usdExchangeRateSell, double eurExchangeRateSell) {
        this.usdExchangeRateBuy = usdExchangeRateBuy;
        this.eurExchangeRateBuy = eurExchangeRateBuy;
        this.usdExchangeRateSell = usdExchangeRateSell;
        this.eurExchangeRateSell = eurExchangeRateSell;
    }

    public double getEurExchangeRateBuy() {
        return eurExchangeRateBuy;
    }

    public void setEurExchangeRateBuy(double eurExchangeRateBuy) {
        this.eurExchangeRateBuy = eurExchangeRateBuy;
    }

    public double getUsdExchangeRateBuy() {
        return usdExchangeRateBuy;
    }

    public void setUsdExchangeRateBuy(double usdExchangeRateBuy) {
        this.usdExchangeRateBuy = usdExchangeRateBuy;
    }

    public double getEurExchangeRateSell() {
        return eurExchangeRateSell;
    }

    public double getUsdExchangeRateSell() {
        return usdExchangeRateSell;
    }

    public void setUsdExchangeRateSell(double usdExchangeRateSell) {
        this.usdExchangeRateSell = usdExchangeRateSell;
    }

    public void setEurExchangeRateSell(double eurExchangeRateSell) {
        this.eurExchangeRateSell = eurExchangeRateSell;
    }

    void whoIAm(){
        System.out.println("Bank");
    }

    @Override
    public double buy(int n, double valBuy){
        double ruble;
        if (n == 1) {
            //System.out.println("Кол-во покупаемой валюты: " + valBuy + " USD");
            GUI.textArea.append("Кол-во покупаемой валюты: " + valBuy + " USD\n");
            ruble = valBuy * this.usdExchangeRateBuy;
        } else {
            //System.out.println("Кол-во покупаемой валюты: " + valBuy + " EUR");
            GUI.textArea.append("Кол-во покупаемой валюты: " + valBuy + " EUR\n");
            ruble = valBuy * this.eurExchangeRateBuy;
        }
        return ruble;
    }

    @Override
    public double sell(int n, double valSell){
        double ruble;
        if (n == 1) {
            //System.out.println("Кол-во продаваемой валюты: " + valSell + " USD");
            GUI.textArea.append("Кол-во продаваемой валюты: " + valSell + " USD\n");
            ruble = valSell * this.usdExchangeRateSell;
        } else {
            //System.out.println("Кол-во продаваемой валюты: " + valSell + " EUR");
            GUI.textArea.append("Кол-во продаваемой валюты: " + valSell + " EUR\n");
            ruble = valSell * this.eurExchangeRateSell;
        }
        return ruble;
    }
}
