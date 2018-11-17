package com.wzh.design_pattern.future;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class GoodUseExample {
    public static void main(String[] args) throws Exception {
        try {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                    3, 4,
                    3000, TimeUnit.MILLISECONDS,
                    new ArrayBlockingQueue<Runnable>(5), new CustomizableThreadFactory("futureTask"),
                    new ThreadPoolExecutor.AbortPolicy());
            // runTask(threadPoolExecutor);
            invokeAll(threadPoolExecutor);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    private static void runTask(ThreadPoolExecutor threadPoolExecutor) throws InterruptedException, ExecutionException {
        SupportForTerminationOfTasks(false, threadPoolExecutor);
    }

    private static void interrputTask(ThreadPoolExecutor threadPoolExecutor) throws InterruptedException, ExecutionException {
        SupportForTerminationOfTasks(true, threadPoolExecutor);
    }

    private static void SupportForTerminationOfTasks(boolean supportTerninated, ThreadPoolExecutor threadPoolExecutor) throws InterruptedException, ExecutionException {
        FutureTask task = new FutureTask(1000);
        Future<Boolean> future = threadPoolExecutor.submit(task);
        System.out.println("committed the task");
        if (supportTerninated) {
            System.out.println("cancle the task");
            future.cancel(true);
        } else {
            System.out.println("get the result of task begin");
        }

        System.out.println("get the result =" + Boolean.toString(future.get()));
        System.out.println("task end");
    }

    public static void invokeAll(ThreadPoolExecutor threadPoolExecutor) throws InterruptedException, ExecutionException {
        FutureTask task = new FutureTask(1000);
        Collection<FutureTask> futureTasks = new ArrayList<FutureTask>();
        futureTasks.add(new FutureTask(100000));
        futureTasks.add(new FutureTask(200000));
        List<Future<Boolean>> futures = threadPoolExecutor.invokeAll(futureTasks, 10000, TimeUnit.MILLISECONDS);

        for (int i = 0; i < futures.size(); i++) {
            System.out.println("handle the task" + i);
            if (!futures.get(i).isCancelled()) {
                System.out.println("result of task " + i + " =" + futures.get(i).get());
                System.out.println("end_________________________");
            }
        }

        //如果任务正在执行，执行cancle后， future仍旧执行
        // 在打印 all end 后，future任务仍旧在跑
        System.out.println(" all end_________________________");


    }
}
