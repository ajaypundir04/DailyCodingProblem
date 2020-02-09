package demo.code.threads;

import java.util.List;

public class SequencePrinter {

    public static void main(String[] args) {
        List<String> threadNames = List.of(
                "1", "2", "3", "4"
        );

        Task t = new Task(threadNames.size());
        threadNames.forEach(name -> new Thread(t, name).start());
    }

    static class Task implements Runnable {

        private final int threads;
        private final Object MUTEX;

        public Task(int threads) {
            this.threads = threads;
            this.MUTEX = new Object();
        }

        public void run() {

            for (int i = 1; i <= 40; i++) {
                synchronized (MUTEX) {
                    MUTEX.notifyAll();

                    long id = Thread.currentThread().getId();
                    String name = Thread.currentThread().getName();

                    if (id % threads == i % threads) {
                        System.out.println("Thread [" + name + "] - " + i);
                    }

                    try {
                        MUTEX.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            synchronized (MUTEX) {
                MUTEX.notifyAll();
            }

        }
    }
}
