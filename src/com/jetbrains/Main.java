package com.jetbrains;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CreatingThread threadFileCreator = new CreatingThread();


        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        Task3 task3 = new Task3();

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        thread1.setPriority(3);
        thread2.setPriority(2);
        thread3.setPriority(1);
        threadFileCreator.start();

        thread1.start();
        thread2.start();
        thread3.sleep(250);
        thread3.start();

        boolean key1 = true, key2 = true;

        while(thread1.isAlive()||thread2.isAlive()||thread3.isAlive())
        {
            if(!thread1.isAlive() && key1) {
                System.out.println(thread1.getName() + " has completed the task.");
                key1 = false;
            }

            if(!thread2.isAlive() && key2) {
                System.out.println(thread2.getName() + " has completed the task.");
                key2 = false;
            }
        }
        System.out.println(thread3.getName() + " has completed the task.");
    }
}
