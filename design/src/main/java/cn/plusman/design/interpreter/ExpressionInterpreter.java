package cn.plusman.design.interpreter;

import java.util.Deque;
import java.util.LinkedList;

/**
 * cn.plusman.design.interpreter
 *
 * @author plusman
 * @since 2020/11/8
 */
public class ExpressionInterpreter {
    private Deque<Long> numbers = new LinkedList<>();

    public long interpret(String expression) {
        String[] words = expression.split(" ");
        for (int i = 0; i <= (words.length / 2); i++) {
            numbers.addLast(Long.valueOf(words[i]));
        }

        int j = words.length / 2 + 1;
        while (numbers.size() > 1) {
            long l1 = numbers.removeFirst();
            long l2 = numbers.removeFirst();

            switch (words[j]) {
                case "-":
                    numbers.addFirst(l1 - l2);
                    break;
                case "+":
                    numbers.addFirst(l1 + l2);
                    break;
                case  "*":
                    numbers.add(l1 * l2);
                    break;
                default:;
            }

            j++;
        }

        if (numbers.size() != 1) {
            throw new RuntimeException("Express is invalid: " + expression);
        }

        return numbers.removeFirst();
    }

    public static void main(String[] args) {
        ExpressionInterpreter expressionInterpreter = new ExpressionInterpreter();
        System.out.println(expressionInterpreter.interpret("8 3 2 4 - + *"));
    }
}
