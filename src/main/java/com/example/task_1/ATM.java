package com.example.task_1;

public class ATM {
    private Section first;

    public ATM() {
        this.first = new Section_500();
        Section section200 = new Section_200();
        Section section100 = new Section_100();

        first.setNext(section200);
        section200.setNext(section100);
    }

    public void getMeMoney(int amount) {
        System.out.println("Processing request for " + amount + "...");
        first.process(amount);
    }
}
