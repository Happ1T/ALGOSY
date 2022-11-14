package missions;

import array.Array;
import list.MyLinkedList;
import stack.MyStack;

import java.util.Objects;
import java.util.Scanner;

public class FirstLaba {
    int[] numbers = {0,1,2,3,4,5,6,7,8,9};
/*
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        Array array = new Array();
        MyStack stack = new MyStack();

        String str = null;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку (каждое слово вводить через пробел)");
        str = scanner.nextLine();
        String[] lines = str.split(" ");

        for (String word : lines){
            switch (word) {
                case "*", "/", "^" -> {
                    switch (stack.peek()) {
                        case "*", "/", "^" -> {
                            System.out.print(stack.peek() + " ");
                            stack.pop();
                            stack.push(word);
                        }
                        default -> stack.push(word);
                    }
                }
                case "+", "-" -> {
                    switch (stack.peek()) {
                        case "*", "/", "^" -> System.out.print(word + " ");

                        default -> stack.push(word);
                    }
                }
                case ")" -> {
                    if (Objects.equals(stack.getFirst(), "sin") || Objects.equals(stack.getFirst(), "cos"))
                    {
                        System.out.print(stack.getFirst());
                        stack.delFirst();
                    }
                    while (!Objects.equals(stack.peek(), "(")){
                        System.out.print(stack.peek() + " ");
                        stack.pop();
                        if(stack.isEmpty()){
                            System.out.println("\nYou missed \"(\"");
                            break;
                        }
                    }
                    stack.pop();
                }
                case "(", "sin", "cos" -> stack.push(word);
                default -> {
                    System.out.print(word + " ");
                }

            }

        }
        stack.print();
        System.out.println();




    }
    */
}
