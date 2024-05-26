package main.java.homework2;

public class Process implements Comparable<Process> {
    private String name;
    private int priority;
    private int burstTime;
    private int arrivalTime;

    public Process(String name, int priority, int burstTime, int arrivalTime) {
        this.name = name;
        this.priority = priority;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public int compareTo(Process other) {
        if (this.priority == other.priority) {
            return Integer.compare(this.arrivalTime, other.arrivalTime);
        }
        return Integer.compare(this.priority, other.priority);
    }
}
