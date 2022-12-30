package datastructure;

import java.util.Stack;

public class BasicStack<T> {
    Stack<T> st;

    public BasicStack() {
        st = new Stack<>();
    }

    void push(T value) {
        st.push(value);
    }

    T peek() {
        if (!st.isEmpty()) {
            return st.peek();
        }
        throw new RuntimeException();
    }

    void pop() {
        if (!st.isEmpty()) {
            st.pop();
            return;
        }
        throw new RuntimeException();
    }

    boolean isEmpty() {
        return st.isEmpty();
    }


}
