package main.java.homework2;

import java.util.ArrayList;

public class Scheduler {

    public static void scheduleAndRun(ArrayList<Process> processes) {
        ProcessQueue pq = new ProcessQueue();
        int currentTime = 0;
        int processIndex = 0;

        while (!pq.isEmpty() || processIndex < processes.size()) {
            // Add processes that have arrived by the current time
            while (processIndex < processes.size() && processes.get(processIndex).getArrivalTime() <= currentTime) {
                pq.addProcess(processes.get(processIndex));
                processIndex++;
            }

            if (!pq.isEmpty()) {
                Process currentProcess = pq.runNextProcess();
                System.out.println("t = " + currentTime + " -> " + currentProcess.getName() + " is running");

                // Decrement the burst time of the current process and re-add if it has remaining burst time
                if (currentProcess.getBurstTime() > 1) {
                    Process updatedProcess = new Process(
                            currentProcess.getName(),
                            currentProcess.getPriority(),
                            currentProcess.getBurstTime() - 1,
                            currentProcess.getArrivalTime()
                    );
                    pq.addProcess(updatedProcess);
                }
            } else {
                // If no process is ready to run, print 'no process'
                System.out.println("t = " + currentTime + " -> no process");
            }

            currentTime++;
        }

        // Print the total time taken
        System.out.println("Total time taken: " + currentTime);
    }


    public static void main(String[] args) {
        ArrayList<Process> processes = new ArrayList<>();

        // Example 1
        /*
        processes.add(new Process("P1", 1, 4, 0));
        processes.add(new Process("P2", 2, 3, 0));
        processes.add(new Process("P3", 1, 7, 6));
        processes.add(new Process("P4", 3, 4, 11));
        processes.add(new Process("P5", 2, 2, 12));
        /*
        p1 p1 p1 p1 p2 p2 p3 p3 p3 p3 p3 p3 p3 p2 p5 p5 p4 p4 p4 p4
        */

        // Example 2
        /*
        processes.add(new Process("P1", 5, 4, 0));
        processes.add(new Process("P2", 4, 3, 1));
        processes.add(new Process("P3", 2, 1, 2));
        processes.add(new Process("P4", 2, 5, 3));
        processes.add(new Process("P5", 2, 2, 4));
        /*
        p1 p2 p3p p4 p4 p4 p4 p4 p5 p5 p2 p2 p1 p1 p1
        */

        // Example 3
        /*
        processes.add(new Process("P1", 3, 3, 0));
        processes.add(new Process("P2", 2, 4, 1));
        processes.add(new Process("P3", 4, 6, 2));
        processes.add(new Process("P4", 6, 4, 3));
        processes.add(new Process("P5", 10, 2, 5));
        /*
        p1 p2 p2 p2 p2 p1 p1 p3 p3 p3 p3 p3 p3 p4 p4 p4 p4 p5 p5
        */

        // Example 4
        /*
        processes.add(new Process("P1", 2, 1, 0));
        processes.add(new Process("P2", 6, 7, 1));
        processes.add(new Process("P3", 3, 3, 2));
        processes.add(new Process("P4", 5, 6, 3));
        processes.add(new Process("P5", 4, 5, 4));
        processes.add(new Process("P6", 10, 15, 5));
        processes.add(new Process("P7", 9, 8, 15));
        /*
        p1 p2 p3 p3 p3 p5 p5 p5 p5 p5 p4 p4 p4 p4 p4 p4 p2 p2 p2 p2 p2 p2 p7 p7 p7 p7 p7 p7 p7 p7 p6 do kraja
        */

        // Example 5

        processes.add(new Process("P1", 2, 4, 1));
        processes.add(new Process("P2", 1, 1, 2));
        processes.add(new Process("P3", 3, 2, 8));
        /*
        no process p1 p2 p1 p1 p1 no process no process p3 p3
        */

        scheduleAndRun(processes);
    }
}
