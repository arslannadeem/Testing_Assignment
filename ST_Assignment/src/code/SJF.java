package code;

import java.util.PriorityQueue;

public class SJF extends SchedulingAlgorithms {
    private PriorityQueue<Proces> ready = new PriorityQueue<>(new DurationComparator());

    SJF(PriorityQueue<Proces> queue) throws CloneNotSupportedException {
        super(queue);
    }

    @Override
    public double symulation() {

        while (!queue.isEmpty() || !ready.isEmpty()) {
            fillReady();
            Proces proces = ready.poll();
            averageWaitingTime += (sumaryTime - proces.getPrepering());
            sumaryTime += proces.getLength();
        }
        return averageWaitingTime / queueSize;
    }

    private void fillReady() {
        if (ready.isEmpty() && sumaryTime < queue.peek().getPrepering())
            sumaryTime = queue.peek().getReadyTime();

        while (!queue.isEmpty() && queue.peek().getPrepering() <= sumaryTime)
            ready.offer(queue.poll());
    }
}