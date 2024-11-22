package cn.originmc.iServerCore.task;

import java.util.concurrent.*;

public class TaskManager {
    private final ConcurrentHashMap<String, TaskQueue> taskQueues = new ConcurrentHashMap<>();

    public TaskQueue getOrCreateTaskQueue(String identifier) {
        return taskQueues.computeIfAbsent(identifier, k -> new TaskQueue());
    }

    public void removeTaskQueue(String identifier) {
        TaskQueue queue = taskQueues.remove(identifier);
        if (queue != null) {
            queue.shutdown();
        }
    }

    public static class TaskQueue {
        private final ExecutorService executor;
        private final BlockingQueue<Runnable> taskQueue;

        public TaskQueue() {
            this.executor = Executors.newSingleThreadExecutor();
            this.taskQueue = new LinkedBlockingQueue<>();
            startProcessing();
        }

        private void startProcessing() {
            executor.execute(() -> {
                while (true) {
                    try {
                        Runnable task = taskQueue.take();
                        task.run();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            });
        }

        public void submitTask(Runnable task) {
            taskQueue.add(task);
        }

        public void shutdown() {
            executor.shutdownNow();
        }
    }
}
