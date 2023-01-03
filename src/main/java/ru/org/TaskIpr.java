package ru.org;

public class TaskIpr implements Runnable {
    private int num;

    public TaskIpr(int n) {
        num = n;
    }

    @Override
    public void run() {
        System.out.println("Задача запущена: " + num + ", текущий поток: " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
