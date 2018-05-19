package code;

import java.util.PriorityQueue;

public class SJFw extends SchedulingAlgorithms {
    protected PriorityQueue<Proces> ready = new PriorityQueue<>(new DurationComparator());

    private int toNextReady = 0;

    SJFw(PriorityQueue<Proces> queue) throws CloneNotSupportedException {
        super(queue);
    }

    @Override
    public double symulation() {

        while (!queue.isEmpty() || !ready.isEmpty()) {
            fillReady();
            boolean checkNext = false;
            while (!checkNext && !ready.isEmpty()) {
                Proces proces = ready.poll();
                if (toNextReady - proces.getDuration() >= 0 || queue.isEmpty()) {
                    sumaryTime += proces.getDuration();
                    averageWaitingTime += (sumaryTime - proces.getLength() - proces.getPrepering());
                    toNextReady -= proces.getDuration();
                } else {
                    proces.reduceDuration(toNextReady);
                    ready.offer(proces);
                    sumaryTime += toNextReady;
                    checkNext = true;
                    toNextReady = 0;
                }
            }
        }
        return averageWaitingTime / queueSize;
    }

    protected void fillReady() {
        if (ready.isEmpty())
            sumaryTime = queue.peek().getPrepering();

        while (!queue.isEmpty() && queue.peek().getPrepering() == sumaryTime)
            ready.offer(queue.poll());

        if (!queue.isEmpty())
            toNextReady = queue.peek().getPrepering() - sumaryTime;
    }
}
