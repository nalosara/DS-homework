package main.java.homework2;

public class ProcessQueue {
    public Process[] pq = new Process[2];
    public int length = 0;

    /* Add a new process into the priority queue */
    public void addProcess(Process process) {
        if (length == pq.length - 1) {
            resize(2 * pq.length);
        }
        pq[++length] = process;
        swim(length);
    }

    /* Return and remove the next Process that should be run */
    public Process runNextProcess() {
        if (length == 0) {
            return null;
        }
        Process min = pq[1];
        swap(1, length--);
        sink(1);
        pq[length + 1] = null; // Avoid loitering
        if (length > 0 && length == (pq.length - 1) / 4) {
            resize(pq.length / 2);
        }
        return min;
    }

    /* Return the next Process that should be run (but do not delete it) */
    public Process peekNextProcess() {
        if (length == 0) {
            return null;
        }
        return pq[1];
    }

    /* Helper methods */

    public boolean isEmpty() {
        return length == 0;
    }
    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= length) {
            int j = 2 * k;
            if (j < length && greater(j, j + 1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    private boolean greater(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    private void swap(int i, int j) {
        Process temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void resize(int capacity) {
        Process[] temp = new Process[capacity];
        for (int i = 1; i <= length; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }
}
