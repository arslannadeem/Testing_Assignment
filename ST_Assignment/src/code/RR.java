package code;

import java.util.PriorityQueue;

public class RR extends SchedulingAlgorithms {
    private PriorityQueue<Proces> ready = new PriorityQueue<>();
    private int quantTime;
    private int averageProcessDuring;

    public RR(int quantTime, PriorityQueue<Proces> queue) throws CloneNotSupportedException {
        super(queue);
        this.quantTime = quantTime;
    }

    RR(PriorityQueue<Proces> queue, int quantTimePercent) throws CloneNotSupportedException {
        super(queue);
        for (Proces p : queue)
            averageProcessDuring += p.getLength();
        this.quantTime = (int) Math.round((averageProcessDuring / queueSize) * (quantTimePercent / 100.0));
    }

    @Override
    public double symulation() {

        while (!queue.isEmpty() || !ready.isEmpty()) {
            fillReady();
            Proces proces = ready.poll();

            if (proces.getDuration() > quantTime) {
                proces.reduceDuration(quantTime);
                sumaryTime += quantTime;
                
                proces.setReadyTime(sumaryTime);
                ready.offer(proces);
            } else {
                sumaryTime += proces.getDuration();
                averageWaitingTime += (sumaryTime - proces.getLength() - proces.getPrepering());
            }
        }
        return averageWaitingTime / queueSize;
    }

    private void fillReady() {
        if (ready.isEmpty() && sumaryTime < queue.peek().getReadyTime())
            sumaryTime = queue.peek().getReadyTime();

        while (!queue.isEmpty() && queue.peek().getReadyTime() <= sumaryTime)
            ready.offer(queue.poll());
    }
}
