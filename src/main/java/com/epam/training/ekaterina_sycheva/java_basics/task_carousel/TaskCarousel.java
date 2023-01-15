package com.epam.training.ekaterina_sycheva.java_basics.task_carousel;

import java.util.LinkedList;


public class TaskCarousel {
    private final int capacity;
    private LinkedList<Task> tasks;


    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        this.tasks = new LinkedList<>();
    }


    public boolean addTask(Task task) {
        if (!isFull() && !task.isFinished()) {
            tasks.addLast(task);
            return true;
        } else {
            return false;
        }
    }


    public boolean execute() {
        boolean isExec;
        if (isEmpty()) {
            return false;
        } else {
            Task bufTask = tasks.pollFirst();
            bufTask.execute();
            isExec = true;
            if (!bufTask.isFinished()) {
                tasks.addLast(bufTask);
            }
        }
        return isExec;
    }

    public boolean isFull() {
        return tasks.size() == capacity;
    }

    public boolean isEmpty() {
        return tasks.size() == 0;
    }

}
