package com.example.task_2;

public class Main {
    public static void main(String[] args) {
        Group<Integer> nestedGroup = new Group<>();
        nestedGroup
            .addTask(new Signature<>(System.out::println))
            .addTask(new Signature<>(x -> System.out.println(x * x)));

        Group<Integer> group = new Group<>();
        group
            .addTask(nestedGroup)
            .addTask(new Signature<>(x -> System.out.println(x * x * x)));

        group.apply(10);

        System.out.println("Nested Group ID: " + nestedGroup.groupUuid);
        System.out.println("Outer Group ID: " + group.groupUuid);

    }
}
