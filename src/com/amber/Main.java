package com.amber;


public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        var user = new Greeting("Amber", "Jones");
        String sayHello = user.greetUser();
        System.out.println(sayHello);
        //------------------------

        var house = new Mortgage();
        String monthlyPayment = house.getCalculatedMortgage();
        System.out.println("Monthly Payment: " + monthlyPayment);
        house.printSchedule();

    }

}
//B = L[(1 + c)n - (1 + c)p]/[(1 + c)n - 1]
