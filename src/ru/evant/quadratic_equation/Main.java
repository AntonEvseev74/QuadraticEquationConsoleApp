package ru.evant.quadratic_equation;

import java.util.Scanner;

/**
 * Программа решает квадратные уравнения, типа
 * Ax² + Bx + C = 0
 */

/*
    Ход выполнения задачи:
        1. Получить данные от пользователя, значения переменных - A, B и С
        2. Вычислить Дискриминант -> D = b² − 4ac
        3. Решить уравнение
            3.1. если D < 0 -> Уравнение не имеет решений
            3.2. если D = 0 -> Уравнение имеет один корень ->  x = -b / 2a
            3.3. если D > 0 -> Уравнение имеет  два кореня -> x1 = (-b - √D) / (2a)
                                                           -> x2 = (-b - √D) / (2a)
        4. Вывести результат
*/

/*
    Автор: Евсеев Антон
    Создано:27 мая 2021 года
*/

  // Ошибки
  //  Реализовать проверку ввода пользователя (если пользователь ничего ни ввел либо ввел не число)
  //  Исправить вывод уравнения, посредством проверок полярности числа вывести соответствующие знаки (+ или -)

public class Main {

    public static void main(String[] args) {

        solveQuadraticEquation(); // Решить квадратное уравнение

    }

    private static void solveQuadraticEquation() {

        /*
          Объявить переменные для хранения вещественных чисел, тип переменных - double.
          Необходимые для вычислений
         */
        double a, b, c, D, x, x1, x2;

        /*
          Объявить и инициализировать ссылочные перменные строкового типа, тип - String.
          Которые ссылаются на строки указанные в "".
          Необходимые для ввода и вывода данных
         */
        String formula = "Решение квадратных уравнений, типа:\n    Ax² + Bx + C = 0";
        String enterValueA = "Введите значение переменной А:\n>: ";
        String enterValueB = "Введите значение переменной B:\n>: ";
        String enterValueC = "Введите значение переменной C:\n>: ";
        String equation; // уравнение
        String dD; // дискриминант
        String dNegative = "Уравнение не имеет корней!";
        String dZeroX = "Уравнение имеет один корень.\nx = ";
        String dPositiveX1 = "Уравнение имеет два кореня.\nx1 = ";
        String dPositiveX2 = "\nx2 = ";

        /*
          Создать объект -> Scanner и объявить на него ссылку -> userInput
          Необходимо для получения данных от пользователя.
         */
        Scanner userInput = new Scanner(System.in);

        System.out.println(formula);      // вывод в консоль. формула

        /* 1. Получить данные от пользователя */
        System.out.print(enterValueA);  // вывод в консоль. запрос данных
        a = userInput.nextDouble();     // получить данные введенные пользователем и присвоить их переменной a
        System.out.print(enterValueB);  // вывод в консоль. запрос данных
        b = userInput.nextDouble();     // получить данные введенные пользователем и присвоить их переменной b
        System.out.print(enterValueC);  // вывод в консоль. запрос данных
        c = userInput.nextDouble();     // получить данные введенные пользователем и присвоить их переменной c

        equation = a + "x²" + b + "x" + c;

        /* 2. Вычислить Дискриминант */
        D = Math.pow(b,2) - 4 * a * c; // Math.pow(b,2) -> использовать метод pow(x, n) класса Math -> pow - возвести число в степень, x - число, n - степень
        dD = "D = " + D;

        /* 3. Решить уравнение и 4. Вывести результат*/

        if (D < 0){ /* 3.1. если (if) D < 0 */
            System.out.println(equation);
            System.out.println(dD);
            System.out.println(dNegative);
        } else if (D == 0) { /* 3.2. иначе (else) если (if) D = 0 */
            x =((-1)*b) / (2 * a);
            System.out.println(equation);
            System.out.println(dD);
            System.out.println(dZeroX + x);
        } else { /* 3.3. иначе (else) */
            x1 = ((-1) * b - Math.sqrt(D)) / (2 * a); // sqrt(n) -> Корень квадратный из n
            x2 = ((-1) * b + Math.sqrt(D)) / (2 * a);
            System.out.println(equation);
            System.out.println(dD);
            System.out.println(dPositiveX1 + x1);
            System.out.println(dPositiveX2 + x2);
        }
    }
}
