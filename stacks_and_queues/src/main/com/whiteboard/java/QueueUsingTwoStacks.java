package com.whiteboard.java;

import java.util.Stack;

/**
 * Implement a queue using two stacks.
 */
public class QueueUsingTwoStacks<E> {
    private Stack<E> addStack = new Stack<>();
    private Stack<E> pollStack = new Stack<>();

    public void add(E element) {
        addStack.push(element);
    }

    public E poll() {
        if (pollStack.isEmpty()) {
            while (!addStack.isEmpty()) {
                pollStack.push(addStack.pop());
            }
        }
        return pollStack.isEmpty() ? null : pollStack.pop();
    }
}
