package com.example.task_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Group<T> extends Task<T> {
    String groupUuid;
    private List<Task<T>> tasks;

    public Group() {
        tasks = new ArrayList<>();
    }

    public Group<T> addTask(Task<T> task) {
        tasks.add(task);
        return this;
    }

    @Override
    public void freeze() {
        if (groupUuid == null) {
            groupUuid = UUID.randomUUID().toString();
        }
        for (Task<T> task : tasks) {
            task.freeze();
            if (task instanceof Signature) {
                task.setHeader("groupId", groupUuid);
            } else if (task instanceof Group) {
                ((Group<T>) task).freeze();
            }
        }
    }

    @Override
    public void apply(T arg) {
        this.freeze();
        tasks = Collections.unmodifiableList(tasks);
        for (Task<T> task : tasks) {
            task.apply(arg);
        }
    }
}
