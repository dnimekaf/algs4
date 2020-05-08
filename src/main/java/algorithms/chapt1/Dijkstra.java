package algorithms.chapt1;

import java.util.Stack;

public class Dijkstra {

    public double Evaluate(String expression) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        String[] parts = expression.split(" ");
        for (String part : parts) {
            switch (part) {
                case "(": break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "sqrt":
                    ops.push(part);
                    break;
                case ")": {
                    String op = ops.pop();
                    double v = vals.pop();
                    switch (op) {
                        case "+": v = vals.pop() + v; break;
                        case "-": v = vals.pop() - v; break;
                        case "*": v = vals.pop() * v; break;
                        case "/": v = vals.pop() / v; break;
                        case "sqrt": v = Math.sqrt(v); break;
                    }
                    vals.push(v);
                } break;
                default: vals.push(Double.parseDouble(part));
            }
        }
        return vals.pop();
    }
}
