package leetCode.model;

import java.util.LinkedList;
import java.util.List;

public class MinStack {

    private List<Integer> list;
    private int minVal = 0;

    public MinStack() {
        if (list == null) {
            list = new LinkedList<Integer>();
        }
    }

    public void push(int val) {
        if (list.size() == 0) {
            minVal = val;
        }
        if (val < minVal) {
            minVal = val;
        }
        list.add(val);
    }

    public void pop() {
        list.remove(list.size() - 1);
        minVal = list.size() > 0 ? list.get(0) : 0;
        for (Integer num : list) {
            if (num < minVal) {
                minVal = num;
            }
        }
    }

    public int top() {
        return list.size() > 0 ? list.get(list.size() - 1) : 0;

    }

    public int getMin() {
        return minVal;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());// return -3
        minStack.pop();
        System.out.println(minStack.top()); // return 0
        System.out.println(minStack.getMin()); // return -2
    }

}
