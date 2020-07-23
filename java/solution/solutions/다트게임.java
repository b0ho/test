package solutions;

import java.util.Stack;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class 다트게임 {
    public static void main(String args[]) {
        다트게임 s = new 다트게임();
        String str = "";
        s.solution(str);
    }

    public int solution(String dartResult) {
        Stack<String> stack = new Stack<>();
        int answer = 0;

        // 숫자일때, 보너스일때, 옵션일때 각각 계산식을 스택에 추가
        for (int i = 0; i < dartResult.length(); i++) {
            int tmp = dartResult.charAt(i);
            // System.out.println(dartResult.substring(i, i + 1));
            if (dartResult.equals("")) {
                return 0;
            }
            if ('0' <= tmp && tmp <= '9') {
                if (i != 0 && tmp == '0' && dartResult.charAt(i - 1) == '1') {
                    stack.pop();
                    stack.push("10");
                } else {
                    stack.push(dartResult.substring(i, i + 1));
                }
            } else if (dartResult.substring(i, i + 1).equals("S")) {
                stack.push("Math.pow(" + stack.pop() + ",1)");
                stack.push("+");
            } else if (dartResult.substring(i, i + 1).equals("D")) {
                stack.push("Math.pow(" + stack.pop() + ",2)");
                stack.push("+");
            } else if (dartResult.substring(i, i + 1).equals("T")) {
                stack.push("Math.pow(" + stack.pop() + ",3)");
                stack.push("+");
            } else if (dartResult.substring(i, i + 1).equals("*")) {
                if (stack.size() > 2) {
                    stack.pop();
                    String now_peek = stack.pop();
                    stack.pop();
                    stack.push("*2");
                    stack.push("+");
                    stack.push(now_peek);
                    stack.push("*2");
                    stack.push("+");
                } else {
                    stack.pop();
                    stack.push("*2");
                    stack.push("+");

                }
            }

            else {
                stack.pop();
                stack.push("*(-1)");
                stack.push("+");
            }

            // System.out.println(stack.toString());
        }

        stack.pop();

        String ex = "";
        for (int i = stack.size() - 1; i >= 0; i--) {
            ex = stack.pop() + ex;
            // System.out.println(ex);
        }

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        try {
            double num = (double) engine.eval(ex);
            answer = (int) num;
        } catch (ScriptException e) {
        }
        System.out.println(answer);

        return answer;
    }
}
