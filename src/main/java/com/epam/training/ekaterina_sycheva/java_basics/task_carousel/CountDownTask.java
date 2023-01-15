package com.epam.training.ekaterina_sycheva.java_basics.task_carousel;

public class CountDownTask implements Task{
    public int value;

    public CountDownTask(int value) {
        if (value >= 0) {
            this.value = value;
        } else {
            this.value = 0;
            isFinished();
        }
    }

    public int getValue() {
        return value;
    }


    @Override
    public void execute() {
        if (value > 0) {
            value--;
        } else {
            isFinished();
        }
    }

    @Override
    public boolean isFinished() {
        return value == 0;
    }
}
