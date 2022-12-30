package datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class BasicQueue<T> {
    Queue<T> q;

    public BasicQueue() {
        q = new LinkedList<>();
    }

    void enqueue(T value) {
        q.offer(value);
    }

    void dequeue() {
        if (!q.isEmpty()) {
            q.remove();
            return;
        }
        throw new RuntimeException();
    }

    T peek() {
        if (!q.isEmpty()) {
            return q.peek();
        }
        throw new RuntimeException();
    }
}
