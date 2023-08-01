package org.example;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by IBS on 28.07.2023
 * @author S.A.Layko
 * @see #getDouble()
 * @see #getOperation()
 * @see #calc(double, double, char)
 * @see #getMaxWord() 
 * @see #getLongestString(String[]) 
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        getTask();
        scanner.close();
    }

    /**
     *
     * @return task value depends on the task number
     */
    public static int getTask(){
        System.out.print("Выберите номер задачи: (1 - калькулятор, 2 - максимальное слово в массиве): ");
        int task = scanner.nextInt();
        if (task == 1) {
            System.out.println("Вы выбрали калькулятор.");
            double num1 = getDouble();
            double num2 = getDouble();
            char operation = getOperation();
            double result = calc(num1, num2, operation);
            //Выводим на экран результат с округлением до 4 знаков после запятой.
            System.out.printf("Результат операции: " + "%.4f", result);
        }
        else if (task == 2) {
            String longestWord = Arrays.toString(getMaxWord());
            System.out.println("Самое длинное слово: " + longestWord);
        } else {
            System.out.println("Вы ввели не верный номер операции. Попробуйте снова.");
            scanner.next();
            task = getTask();
        }
        return task;
    }

    /**
     * @return input two double values
     */
    public static double getDouble() {
//        Запрашиваем ввод двух чисел через консоль.
//        В случае ошибки, вводим повторно.
        System.out.print("Введите дробное число:");
        double num;
        if (scanner.hasNextDouble()) {
            num = scanner.nextDouble();
        } else {
            System.out.println("Вы неверно ввели число. Попробуйте снова.");
            num = getDouble();
        }
        return num; //Возвращаем введенные числа
    }

    /**
     * @return the operation selection
     */
    public static char getOperation() {
        System.out.print("Выберите операцию:");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы неверно ввели операцию. Попробуйте снова.");
            scanner.next();
            operation = getOperation();
        }
        return operation; //Возвращаем введенную операцию
    }

    /**
     * @param num1      input value
     * @param num2      input value
     * @param operation input value
     * @return some double result
     */
    public static double calc(double num1, double num2, char operation) {
        double result;
        /*Используем оператор выбора для полученного значения operation
        Если операция отличается от доступных, выводим ошибку с возможностью повторно ввести операцию.*/
        switch (operation) {
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> result = num1 / num2;
            default -> {
                System.out.println("Операция не верна. Попробуйте снова.");
                result = calc(num1, num2, getOperation());
            }
        }
        return result; //Возвращаем результат проведенной операции
    }

    /**
     *
     * @return longestWord variable with the longest possible word
     */
    public static String[] getMaxWord() {
        System.out.println("Вы выбрали поиск максимального слова в массиве.");
        System.out.print("Введите длину массива: ");
        int n = scanner.nextInt();
        String[] word = new String[n];
        System.out.println("Введите элементы массива.");
        for (int i = 1; i <= n; i++) {
            System.out.print("Строка " + i + ": ");
            word[i-1] = scanner.next();
        }
        String longestWord = getLongestString(word);
        //System.out.println(word); //Для проверки полученного слова
        return new String[]{longestWord};
    }

    /**
     *
     * @param word array with string values
     * @return word[index] the word that goes by the index
     */
    public static String getLongestString(String[] word) {
        int index = 0;
        int elementLength = word[0].length();
        for(int i = 1; i < word.length; i++) {
            if(word[i].length() > elementLength) {
                index = i; elementLength = word[i].length();
            }
        }
        return word[index];
    }
}

