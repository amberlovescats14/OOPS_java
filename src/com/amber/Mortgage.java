package com.amber;

import java.text.NumberFormat;
import java.util.Scanner;

public class Mortgage {
    private int principal;
    private double monthlyInterest;
    private int months;
    private String mortgage;
    public static int numberOfPaymentsMade = 0;

    public Mortgage () throws IllegalAccessException{
        setPrincipal();
        setInterest();
        setYears();
        setCalculateMortgage();

    }
    // SET PRIVATE PRINCIPAL
    private void setPrincipal() throws IllegalAccessException {
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.print("Principal amount?");
            principal = scan.nextInt();
            if(principal > 1000 && principal < 1000000) break;
            System.out.println("Please enter an amount between 1K - 1M");
        }
        this.principal = principal;
    }

    // PRIVATE GET PRINCIPAL
    private int getPrincipal() {
     return principal;
    }

    // PRIVATE SET MONTHLY INTEREST
    private void setInterest() throws IllegalAccessException {
        Scanner scan = new Scanner(System.in);
        double monthlyInterest;
        while(true){
            System.out.print("Annual Interest?");
            monthlyInterest = (scan.nextDouble() / 100) /12;
            if(monthlyInterest > 0 && monthlyInterest < 10) break;
            System.out.println("Please enter a rate between .1 - 10");
        }
        this.monthlyInterest = monthlyInterest;
    }
    // PRIVATE GET MONTHLY INTEREST
    private double getMonthlyInterest(){
        return monthlyInterest;
    }

    private void setYears() throws IllegalAccessException {
        Scanner scan = new Scanner(System.in);
        int months;
        while(true) {
            System.out.print("How many years would you like to finance?");
            int years = scan.nextInt();
            months = years * 12;
            if(years > 10 && years < 51) break;
            System.out.println("Please choose between 10 - 50 years.");
        }
        this.months = months;
    }
    // PRIVATE GET YEARS
    private int getYears(){
        return months;
    }
    // SET MONTHLY MORTGAGE
    private void setCalculateMortgage() {
        double top = monthlyInterest * Math.pow(1 + monthlyInterest, months);
        double bottom = Math.pow(1 + monthlyInterest, months) -1;
        double divide = top / bottom;
        double multiply = principal * divide;

        String mortgage = NumberFormat.getCurrencyInstance().format(multiply);
        this.mortgage = mortgage;

    }

    //PUBLIC GET MONTHLY PAYMENT
    public String getCalculatedMortgage(){
        return mortgage;
    }


    private double paymentSchedule(
            int principal,
            double monthlyInterest,
            int months,
            int numberOfPaymentsMade
    ) {
        double top = (Math.pow(1+monthlyInterest, months) )- Math.pow(1 + monthlyInterest, numberOfPaymentsMade);
        double bottom = Math.pow(1+monthlyInterest, months) -1;
        double b = principal * (top / bottom);
        return b;
    }

    public void printSchedule(){
        System.out.println("----------------");
        System.out.println("Payment Schedule: ");

        for(short i =0; i < months; i++){
            numberOfPaymentsMade++;
            double b = paymentSchedule(principal, monthlyInterest, months, numberOfPaymentsMade);
            System.out.println(
                    NumberFormat.getCurrencyInstance().format(b)
            );
        }
    }



}