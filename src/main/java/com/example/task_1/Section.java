package com.example.task_1;

public abstract class Section {
    protected int denomination;
    private Section next;

    public Section(int denomination) {
        this.denomination = denomination;
    }

    public void setNext(Section next) {
        this.next = next;
    }

    public void process(int amount) {
        if (amount < 0) {
            System.out.println("Invalid amount.");
            return;
        }

        int numNotes = amount / denomination;
        int remainder = amount % denomination;

        if (numNotes > 0) {
            System.out.println("Dispensing " + numNotes + " notes of " + denomination);
        }

        if (remainder > 0) {
            if (next != null) {
                next.process(remainder);
            } else {
                System.out.println("Cannot dispense remaining amount: " + remainder);
            }
        }
    }
}
