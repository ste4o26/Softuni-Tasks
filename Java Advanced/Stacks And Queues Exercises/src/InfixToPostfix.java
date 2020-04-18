import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class InfixToPostfix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().split(" ");

        ArrayDeque<String> operatorsStack = new ArrayDeque<>();
        ArrayDeque<String> outputQueue = new ArrayDeque<>();

        Map<String, Integer> operatorsPrecedenceMap = new LinkedHashMap<>();
        fillOperatorPrecedence(operatorsPrecedenceMap);


        for (int i = 0; i < tokens.length; i++) {
            boolean isOperator = tokens[i].equals("*") || tokens[i].equals("/") || tokens[i].equals("+")
                    || tokens[i].equals("-") || tokens[i].equals("(") || tokens[i].equals(")");

            if (!isOperator) {
                String operand = tokens[i];
                outputQueue.offer(operand);
            } else {
                String operator = tokens[i];
                String lastOperator;
                int lastOperatorPrecedence = -1;
                if (!operatorsStack.isEmpty()) {
                    lastOperator = operatorsStack.peek();
                    lastOperatorPrecedence = getOperatorPrecedence(lastOperator);
                }

                if (operatorsStack.contains("(") && operator.equals(")")) {
                    while (!operatorsStack.peek().equals("(")) {
                        outputQueue.offer(operatorsStack.pop());
                    }
                    operatorsStack.pop();
                } else if (lastOperatorPrecedence == operatorsPrecedenceMap.get(operator)) {
                    outputQueue.offer(operatorsStack.pop());
                    operatorsStack.push(operator);
                } else {
                    operatorsStack.push(operator);
                }
            }
        }
        printResult(outputQueue, operatorsStack);
    }

    static int getOperatorPrecedence(String operator) {
        if (operator.equals("+") || operator.equals("-")) {
            return 1;
        } else if (operator.equals("*") || operator.equals("/")) {
            return 2;
        } else {
            return -1;
        }
    }

    static void fillOperatorPrecedence(Map<String, Integer> operatorsPrecedence) {
        operatorsPrecedence.put("(", 0);
        operatorsPrecedence.put(")", 0);
        operatorsPrecedence.put("+", 1);
        operatorsPrecedence.put("-", 1);
        operatorsPrecedence.put("*", 2);
        operatorsPrecedence.put("/", 2);
    }

    static void printResult(ArrayDeque<String> outputQueue, ArrayDeque<String> operatorsStack) {
        while (!operatorsStack.isEmpty()) {
            outputQueue.offer(operatorsStack.pop());
        }

        while (!outputQueue.isEmpty()) {
            System.out.print(outputQueue.poll() + " ");
        }
    }
}