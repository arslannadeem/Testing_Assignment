package code;

import java.util.Random;

public class Proces implements Comparable<Proces>, Cloneable {
    private static int cout=1;
    private final Integer id=cout++;
    private final int length;
    private final int preparTime;
    private Integer duration;
    private Integer readyTime;

    public Proces(int startTime, int duration) {
        this.readyTime =startTime;
        this.duration = duration;
        length =duration;
        preparTime=readyTime;
    }

    Proces(){
        readyTime = new Random().nextInt(100);
        if (new Random().nextInt(100) < 80)
            duration = new Random().nextInt(90) + 10;
        else
            duration = new Random().nextInt(900) + 100;
        length =duration;
        preparTime=readyTime;
    }

    int getId() {
        return id;
    }

    public int getLength() {
        return length;
    }

    int getPrepering() {
        return preparTime;
    }

    int getDuration() {
        return duration;
    }

    void reduceDuration(int time){
        duration-=time;
    }

    int getReadyTime() {
        return readyTime;
    }

    void setReadyTime(Integer readyTime) {
        this.readyTime = readyTime;
    }

    @Override
    protected Proces clone() throws CloneNotSupportedException {
        return (Proces) super.clone();
    }

    @Override
    public String toString() {
        return "Proces{" +
                "id=" + id +
                ", duration=" + duration +
                ", readyTime=" + readyTime +
                '}';
    }

    @Override
    public int compareTo(Proces o) {
        int result=readyTime.compareTo(o.getReadyTime());
        return result==0?id.compareTo(o.getId()):result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Proces proces = (Proces) o;

        return length == proces.length && preparTime == proces.preparTime && (id != null ? id.equals(proces.id) : proces.id == null && (duration != null ? duration.equals(proces.duration) : proces.duration == null && (readyTime != null ? readyTime.equals(proces.readyTime) : proces.readyTime == null)));

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + length;
        result = 31 * result + preparTime;
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (readyTime != null ? readyTime.hashCode() : 0);
        return result;
    }
}
