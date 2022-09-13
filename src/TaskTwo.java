import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TaskTwo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final int countMyCallable = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Integer result = executorService.invokeAny(callableTasks(countMyCallable));
        System.out.println("Выведенных в консоль сообщений:" + result);
        executorService.shutdown();
    }

       public static List<Callable<Integer>> callableTasks(int countMyCallable) {
        List<Callable<Integer>> callableTasks = new ArrayList<>();
        for (int i = 1; i <= countMyCallable; i++) {
            MyCallable myCallable = new MyCallable(i);
            callableTasks.add(myCallable);
        }
        return callableTasks;
    }
}
 class MyCallable implements Callable<Integer> {
    private int id;
    final private int MESSAGE = 5;
    final private int SLEEP = 200;

    public MyCallable(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public Integer call() throws Exception {
        int count = 0;
        try {
            for (int i = 1; i <= MESSAGE; i++) {
                TimeUnit.MILLISECONDS.sleep(SLEEP);
                System.out.println("Я поток " + getId() + ". Всем привет!");
                count++;
            }
        } catch (InterruptedException e) {

        }
        return count;
    }
}


