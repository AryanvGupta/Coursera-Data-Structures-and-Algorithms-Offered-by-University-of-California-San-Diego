package com.company;

import java.util.*;

// Check brackets in the code

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();
        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            // create a new bracket, populate bracket type and bracket position
            Bracket bracket = new Bracket(next, position + 1);

            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code here

                // push a new bracket into a stack
                opening_brackets_stack.push(bracket);
            }

            if (next == ')' || next == ']' || next == '}') {
                // Process closing bracket, write your code here

                if (opening_brackets_stack.empty()) {
                    // This is bad, because the closing bracket cannot occur before the opening bracket.
                    // So we push a new bracket into a stack, and exit the loop.

                    // push a new bracket into a stack
                    opening_brackets_stack.push(bracket);

                    break;
                } else {
                    Bracket peek_bracket = opening_brackets_stack.peek();

                    if (peek_bracket.Match(next)) {
                        opening_brackets_stack.pop();
                    } else {
                        // This is bad, because the new bracket doesn't match the previous bracket.
                        // So we push a new bracket into a stack, and exit the loop.
                        opening_brackets_stack.push(bracket);

                        break;
                    }
                }
            }
        }

        // Printing answer, write your code here
        if (opening_brackets_stack.empty()) {
            // The stack is empty, which means all the brackets in the text matched correctly.
            System.out.println("Success");
        } else {
            // The stack is not empty, which means there were unmatched brackets.
            // The first unmatched bracket is the one at the top of the stack.
            Bracket bracket = opening_brackets_stack.peek();
            System.out.println(bracket.position);
        }
    }
}

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }
    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }
    char type;
    int position;
}


//public class Main {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
////        System.out.println(checkBalancedParentesis(str));
//
//    }
////    public static int checkBalancedParentesis(String expr)
////    {
////        if (expr.isEmpty())
////            return 1;
////
////        Stack<Character> stack = new Stack<Character>();
////        for (int i = 0; i < expr.length(); i++)
////        {
////            char current = expr.charAt(i);
////            if (current == '{' || current == '(' || current == '[')
////            {
////                stack.push(current);
////            }
////            if (current == '}' || current == ')' || current == ']')
////            {
////                if (stack.isEmpty())
////                    return 0;
////                char last = stack.peek();
////                if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[')
////                    stack.pop();
////                else
////                    return 0;
////            }
////        }
////        return stack.isEmpty()?1:0;
//    }
//
////    public static void main(String[] args) {
////        Scanner scanner = new Scanner(System.in);
////        String str = scanner.nextLine();
////
////        int i = 0;
////        char[] new_brackets = new char[str.length()];
////        char[] brackets = new char[str.length()];
////        for (int position=0; position<str.length(); position++) {
////            char next = str.charAt(position);
////            if (next == '[' || next == '{' || next == '(' || next == ']' || next == '}' || next == ')') {
////                brackets[i] = next;
////                i++;
////            }
////            new_brackets[position] = next;
////        }
////
////        System.out.println(areParenthesisBalanced(brackets));
////
//////        if (IsBalanced(str) == -1) {
//////            System.out.println("Success");
//////        }
//////        else {
//////            System.out.println(IsBalanced(str));
//////        }
////    }
////
////    static class stack
////    {
////        int top=-1;
////        char items[] = new char[100];
////
////        void push(char x)
////        {
////            if (top == 99)
////            {
////                System.out.println("Stack full");
////            }
////            else
////            {
////                items[++top] = x;
////            }
////        }
////
////        char pop()
////        {
////            if (top == -1)
////            {
////                System.out.println("Underflow error");
////                return '\0';
////            }
////            else
////            {
////                char element = items[top];
////                top--;
////                return element;
////            }
////        }
////
////        boolean isEmpty()
////        {
////            return top == -1;
////        }
////    }
////
////    /* Returns true if character1 and character2
////       are matching left and right Parenthesis */
////    static boolean isMatchingPair(char character1, char character2)
////    {
////        if (character1 == '(' && character2 == ')')
////            return true;
////        else if (character1 == '{' && character2 == '}')
////            return true;
////        else if (character1 == '[' && character2 == ']')
////            return true;
////        else
////            return false;
////    }
////
////    /* Return true if expression has balanced
////       Parenthesis */
////    static int areParenthesisBalanced(char exp[])
////    {
////        /* Declare an empty character stack */
////        stack st=new stack();
////
////       /* Traverse the given expression to
////          check matching parenthesis */
////        for(int i=0;i<exp.length;i++)
////        {
////
////          /*If the exp[i] is a starting
////            parenthesis then push it*/
////            if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[')
////                st.push(exp[i]);
////
////          /* If exp[i] is an ending parenthesis
////             then pop from stack and check if the
////             popped parenthesis is a matching pair*/
////            if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']')
////            {
////
////              /* If we see an ending parenthesis without
////                 a pair then return false*/
////                if (st.isEmpty())
////                {
////                    return 0;
////                }
////
////             /* Pop the top element from stack, if
////                it is not a pair parenthesis of character
////                then there is a mismatch. This happens for
////                expressions like {(}) */
////                else if ( !isMatchingPair(st.pop(), exp[i]) )
////                {
////                    return i;
////                }
////            }
////        }
////
////       /* If there is something left in expression
////          then there is a starting parenthesis without
////          a closing parenthesis */
////
////        if (st.isEmpty())
////            return 1; /*balanced*/
////        else
////        {   /*not balanced*/
////            return 0;
////        }
////    }
////
////    private static int IsBalanced(String str) {
////        Stack<Character> stack = new Stack<>();
////
////        int i = 0;
////        int flag = 0;
////
////        char[] new_brackets = new char[str.length()];
////        char[] brackets = new char[str.length()];
////        for (int position=0; position<str.length(); position++) {
////            char next = str.charAt(position);
////            if (next == '[' || next == '{' || next == '(' || next == ']' || next == '}' || next == ')') {
////                brackets[i] = next;
////                i++;
////            }
////            new_brackets[position] = next;
////        }
////        String buffer = new String(brackets).trim().replaceAll(" ", "");
////        //System.out.println("buffer : " + buffer);
////
////        char[] buffer_brackets = new char[buffer.length()];
////        i = 0;
////        for (int position=0; position<buffer.length(); position++) {
////            char next = buffer.charAt(position);
////            if (next == '[' || next == '{' || next == '(' || next == ']' || next == '}' || next == ')') {
////                buffer_brackets[i] = next;
////                i++;
////            }
////        }
////        //System.out.println("brackets : " + Arrays.toString(brackets));
////
////        List<Character> original_brackets_position = new ArrayList<>();
////        for (char value : new_brackets) {
////            original_brackets_position.add(value);
////        }
////        //System.out.println("original_brackets_position : " + original_brackets_position);
////
////        for (char bracket : buffer_brackets) {
////            System.out.println("bracket : " + bracket);
////            if (bracket == '[' || bracket == '{' || bracket == '(') {
////                stack.push(bracket);
////                System.out.println("stack : " + Arrays.toString(stack.toArray()));
////            }
////            else {
////                if (stack.empty()) {
////                    continue;
////                }
////                char top = stack.pop();
////                if (top == '[' && bracket == ']')
////                    flag = -2;
////                if (top == '{' && bracket == '}')
////                    flag = -2;
////                if (top == '(' && bracket == ')')
////                    flag = -2;
////            }
////        }
////        if (!stack.empty()) {
////            flag = original_brackets_position.indexOf(stack.firstElement());
////        }
////        return flag + 1;
////    }
//
