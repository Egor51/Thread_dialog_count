public class TaskOne {
    public static void main(String[] args) throws InterruptedException {

        ThreadGroup mainGroup = new ThreadGroup("mainGroup");

        System.out.println("Создаю потоки ...");
        Thread thread1 = new Thread(mainGroup, new MyThread(), "One");
        Thread thread2 = new Thread(mainGroup, new MyThread(), "Two");
        Thread thread3 = new Thread(mainGroup, new MyThread(), "Three");
        Thread thread4 = new Thread(mainGroup, new MyThread(), "For");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        Thread.sleep(15000);
        mainGroup.interrupt();
        System.out.println("Завершаю все потоки.");

    }
}

class MyThread extends Thread {

    @Override
    public void run() {

        while (true) {

            System.out.println("Я поток " + MyThread.currentThread().getName() + " Всем привет!");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}


