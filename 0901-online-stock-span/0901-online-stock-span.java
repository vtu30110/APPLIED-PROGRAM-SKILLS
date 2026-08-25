import java.util.*;

class StockSpanner {

    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {

        int span = 1;

        // Remove all previous prices <= today's price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        // Store {price, span}
        stack.push(new int[]{price, span});

        return span;
    }
}