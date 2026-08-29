class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        int result = 0;
        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int num =calculate(token,stack);
                stack.push(num);
            }
        }

        return stack.peek();
    }

    public int calculate(String operator, Stack<Integer> stack) {
        int b = stack.pop();
        int a = stack.pop();

        int result=calculate(a,b,operator);

        return result;
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
