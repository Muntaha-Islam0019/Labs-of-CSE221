package Tasks;

import java.util.Stack;

public class TaskOne {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        System.out.println();

        System.out.println("Pushing " + stack.push(10) + "....");
        System.out.println("Printing top:\n" + stack.peek());
        System.out.println("Pushing " + stack.push(5) + "....");
        System.out.println("Printing top:\n" + stack.peek());
        System.out.println("Pushing " + stack.push(6) + "....");
        System.out.println("Printing top:\n" + stack.peek());

        System.out.println("Popping...");
        stack.pop();
        System.out.println("Printing top:\n" + stack.peek());

        System.out.println("Pushing " + stack.push(9) + "....");
        System.out.println("Printing top:\n" + stack.peek());
        System.out.println("Pushing " + stack.push(3) + "....");
        System.out.println("Printing top:\n" + stack.peek());
        System.out.println("Pushing " + stack.push(2) + "....");
        System.out.println("Printing top:\n" + stack.peek());

        System.out.println("Popping...");
        stack.pop();
        System.out.println("Printing top:\n" + stack.peek());
        System.out.println("Popping...");
        stack.pop();
        System.out.println("Printing top:\n" + stack.peek());
    }
}
