package code;

import java.util.PriorityQueue;

public class FCFS extends SchedulingAlgorithms {

    FCFS(PriorityQueue<Proces> queue) throws CloneNotSupportedException {
        super(queue);
    }

    @Override
    public double symulation() {

        while (!queue.isEmpty()) {
            if (sumaryTime < queue.peek().getPrepering())
                sumaryTime = queue.peek().getPrepering();
            averageWaitingTime += (sumaryTime - queue.peek().getPrepering());
            sumaryTime += queue.poll().getLength();
        }
        return averageWaitingTime / queueSize;
    }
}