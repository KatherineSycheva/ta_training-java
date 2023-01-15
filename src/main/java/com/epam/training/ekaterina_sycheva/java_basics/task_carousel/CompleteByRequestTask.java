package com.epam.training.ekaterina_sycheva.java_basics.task_carousel;

public class CompleteByRequestTask implements Task {

    private boolean isCompleted = false;
    private boolean isExecuteCompleted = false;

    @Override
    public void execute() {
        if (isCompleted) {
            isExecuteCompleted = true;
        }
    }

    @Override
    public boolean isFinished() {
        return isCompleted && isExecuteCompleted;
    }

    public void complete() {
        isCompleted = true;
    }
}
