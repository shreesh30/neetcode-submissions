class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        int result = 0;
        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                stack.push(calculate(token,stack));
            }
        }

        return stack.peek();
    }

    public int calculate(String operator, Stack<Integer> stack) {
        int b = stack.pop();
        int a = stack.pop();

        return calculate(a,b,operator);
    }

    public static int calculate(int a, int b, String operator) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        };
    }

    public boolean isNumeric(String token) {
        try {
            Integer num = Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
