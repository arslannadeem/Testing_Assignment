package code;

import java.util.PriorityQueue;

public abstract class SchedulingAlgorithms {
    protected PriorityQueue<Proces> queue = new PriorityQueue<>();
    double averageWaitingTime = 0;
    int sumaryTime = 0;
    int queueSize;

    SchedulingAlgorithms(PriorityQueue<Proces> queue) throws CloneNotSupportedException {
        for (Proces p : queue)
            this.queue.offer(p.clone());
        queueSize = queue.size();
    }

    public abstract double symulation();
}