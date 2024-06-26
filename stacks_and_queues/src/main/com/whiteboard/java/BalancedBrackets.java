package com.whiteboard.java;

import java.util.*;

public final class BalancedBrackets {
    /**
     * Determine whether, in an expression containing various
     * kinds of brackets, the brackets are properly balanced
     * and nested.
     *
     * Our algorithm is straightforward. We scan the expression
     * from left to right. If we encounter an open bracket, we
     * push it on a stack. If we encounter a close bracket, we
     * pop an open bracket off the stack. (If the stack is empty,
     * the expression is not balanced.) If that open bracket
     * doesn't match the close bracket, the expression is not
     * balanced. If we reach the end of the expression, the
     * expression is balanced if and only if the stack is empty.
     *
     * @param expression A string containing various kinds of
     *                   open and close brackets.
     * @return A boolean indicating whether ('true') or not
     * ('false') the brackets in the expression are properly
     * balanced and nested.
     */
    public static boolean balancedBrackets(String expression) {
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put('(', ')');
        bracketMap.put('[', ']');
        bracketMap.put('{', '}');
        Stack<Character> openBracketStack = new Stack<>();
        for (int i = 0; i < expression.length(); ++i) {
            char c = expression.charAt(i);
            if (bracketMap.containsKey(c)) {
                openBracketStack.push(c);
            } else if (bracketMap.containsValue(c)) {
                if (openBracketStack.isEmpty()) {
                    return false;
                }
                char openBracket = openBracketStack.pop();
                if (bracketMap.get(openBracket) != c) {
                    return false;
                }
            }
        }
        return openBracketStack.isEmpty();
    }
}
