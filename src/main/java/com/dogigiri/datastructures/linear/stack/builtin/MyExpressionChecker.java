package com.dogigiri.datastructures.linear.stack.builtin;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * Check if a string is balanced in case of opening and closing brackets
 */
public class MyExpressionChecker {
    private final List<Character> leftBrackets = List.of('(', '{', '[', '<');
    private final List<Character> rightBrackets = List.of(')', '}', ']', '>');
    private final Deque<Character> stack = new ArrayDeque<>();

    /**
     * checks if the string is balanced or not. We iterate over all characters and push every left bracket characters, then
     * if we encounter right bracket characters we check the stack of left characters and if they match we continue.
     * @param input string which is going to be checked
     * @return if the string is balanced or not
     */
    public boolean isBalanced(String input) {
        for (char c : input.toCharArray()) {
            if (isLeftBracket(c)) {
                stack.push(c);
            }
            if (isRightBracket(c)) {
                if (stack.isEmpty()) return false;
                if (!bracketsMatch(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * check if string char belongs to right bracketList or not
     * @param c string character
     * @return true if it exists in right bracketList
     */
    private boolean isRightBracket(char c) {
        return rightBrackets.contains(c);
    }

    /**
     * check if string character belongs to lefBracketList or not
     * @param c String character
     * @return true if it exists in left bracketList
     */
    private boolean isLeftBracket(char c) {
        return leftBrackets.contains(c);
    }

    /**
     * compare if two brackets are same kind
     * @param left left bracket character
     * @param right right bracket character
     * @return true if they are same kind
     */
    private boolean bracketsMatch(char left, char right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }
}
