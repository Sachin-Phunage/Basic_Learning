package com.learning;

public class StringOperations {
    public static void main(String[] args) {

        String inputString = "apple";
        System.out.println("Reverse string of " + inputString);
        System.out.println(" 1. Using Char Array  : " + reverseUsingCharArray(inputString));
        System.out.println(" 2. Using String Builder  : " + reverseUsingStringBuilder(inputString));
        System.out.println(" 3. Using Reverse Looping  : " + reverseUsingLoopDecrement(inputString));
    }

    public static String reverseUsingCharArray(String inputString) {
        char[] chars = inputString.toCharArray();// Create char array from given Sting
        int leftPointer = 0, rightPointer = chars.length - 1;
        while (leftPointer < rightPointer) {
            char currentElement = chars[leftPointer];
            chars[leftPointer] = chars[rightPointer];
            chars[rightPointer] = currentElement;
            leftPointer++;
            rightPointer--;
        }
        return new String(chars);
    }

    public static String reverseUsingStringBuilder(String inputString) {
        return new StringBuilder(inputString).reverse().toString();
    }

    public static String reverseUsingLoopDecrement(String inputString) {
        String reversed = "";
        for (int i = inputString.length() - 1; i >= 0; i--) {
            reversed += inputString.charAt(i);
        }
        return reversed;
    }
}
