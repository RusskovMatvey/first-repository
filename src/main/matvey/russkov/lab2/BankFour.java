package main.matvey.russkov.lab2;

import main.matvey.russkov.lab5.GUI;

public class BankFour extends Bank implements FirstBank {
    private double usdExchangeRateBuy;
    private double eurExchangeRateBuy;
    private double usdExchangeRateSell;
    private double eurExchangeRateSell;

    public BankFour(double usdExchangeRateBuy, double eurExchangeRateBuy, double usdExchangeRateSell, double eurExchangeRateSell) {
        super(usdExchangeRateBuy, eurExchangeRateBuy, usdExchangeRateSell, eurExchangeRateSell);
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

    @Override
    void whoIAm(){
        //System.out.println("Bank Four:");
        GUI.textArea.append("Bank Four:\n");
    }

}
