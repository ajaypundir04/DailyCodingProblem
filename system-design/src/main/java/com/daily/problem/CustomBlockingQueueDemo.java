package com.daily.problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class CustomBlockingQueue<T> {
    private final Queue<T> queue = new LinkedList<>();
    private final int capacity;
    private final ReentrantLock lock = new ReentrantLock(true);
    private final Condition fullLock = lock.newCondition();
    private final Condition emptyLock = lock.newCondition();

    public CustomBlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public CustomBlockingQueue() {
        this.capacity = 5;
    }

    public void put(T element) throws InterruptedException {
        try {
            lock.lock();
            while (queue.size() == this.capacity) {
                fullLock.await();
            }
            queue.add(element);
            emptyLock.signalAll();

        } finally {
            lock.unlock();
        }

    }

    public T take() throws InterruptedException {
        try {
            lock.lock();
            while (queue.isEmpty()) {
                emptyLock.await();
            }
            T ele = queue.remove();
            fullLock.signalAll();
            return ele;
        } finally {
            lock.unlock();
        }

    }

}


public class CustomBlockingQueueDemo {
    public static void main(String[] args) {
        CustomBlockingQueue<String> customBlockingQueue = new CustomBlockingQueue<>();


        Thread producer = new Thread(() -> {

            try {
                for (int i = 0; i < 5; i++) {
                    String ele = UUID.randomUUID().toString();
                    customBlockingQueue.put(ele);
                    System.out.println(String.format("Produced:::%s", ele));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        Thread consumer = new Thread(() -> {

            try {
                for (int i = 0; i < 5; i++) {

                    String ele = customBlockingQueue.take();
                    System.out.println(String.format("Consumed:::%s", ele));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        });

        producer.start();
        consumer.start();

    }
}
