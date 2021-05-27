package ru.evant.quadratic_equation;

import java.util.Scanner;

/**
 * Программа решает квадратные уравнения, типа
 * Ax² + Bx + C = 0
 * <p>
 * Ход выполнения задачи:
 * 1. Получить данные от пользователя, значения переменных - A, B и С
 * 2. Вычислить Дискриминант -> D = b² − 4ac
 * 3. Решить уравнение
 * 3.1. если D < 0 -> Уравнение не имеет решений
 * 3.2. если D = 0 -> Уравнение имеет один корень ->  x = -b / 2a
 * 3.3. если D > 0 -> Уравнение имеет  два кореня -> x1 = (-b - √D) / (2a)
 * -> x2 = (-b - √D) / (2a)
 * 4. Вывести результат
 */

/**
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

/**
 Автор: Евсеев Антон
 Создано:27 мая 2021 года
 */

// Ошибки
//  Реализовать проверку ввода пользователя (если пользователь ввел не число)

public class Main {

    /*
          Объявить переменные для хранения вещественных чисел, тип переменных - double.
          Необходимые для вычислений
         */
    static double a = 1, b = 1, c = 0, D, x, x1, x2;

    /*
          Объявить и инициализировать ссылочные перменные строкового типа, тип - String.
          Которые ссылаются на строки указанные в "".
          Необходимые для ввода и вывода данных
         */
    static String formula = "Решение квадратных уравнений, типа:\n    Ax² + Bx + C = 0";
    static String enterValueA = "Введите число, значение переменной А:\n>: ";
    static String enterValueB = "Введите число, значение переменной B:\n>: ";
    static String enterValueC = "Введите число, значение переменной C:\n>: ";
    static String equation; // уравнение
    static String sectionA, sectionB, section3; // математический оператор (+ или -)
    static String dD; // дискриминант
    static String dNegative = "Уравнение не имеет корней!";
    static String dZeroX = "Уравнение имеет один корень.\nx = ";
    static String dPositiveX1 = "Уравнение имеет два кореня.\nx1 = ";
    static String dPositiveX2 = "x2 = ";

    /*
      Создать объект -> Scanner и объявить на него ссылку -> userInput
      Необходимо для получения данных от пользователя.
     */
    // static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        solveQuadraticEquation(); // Решить квадратное уравнение
    } // end method main()

    private static void solveQuadraticEquation() {
        System.out.println(formula);      // вывод в консоль. формула

        /* 1. Получить данные от пользователя */
        /* A */
        System.out.print(enterValueA);  // вывод в консоль. запрос данных
        a = getUserInput(); //userInput.nextDouble();     // получить данные введенные пользователем и присвоить их переменной a
        // Проверить поле ввода, если не пустое выполняем код далее, иначе присваиваем переменной значение 1
        if (Check.isNotEmpty(a)) {
            /* проверка на знак оператора + или -, или равенство нулю */
            if (Check.isPositive(a)) sectionA = "" + a + "x²";
            if (Check.isPositive(a) && Check.compareTwoNumbers(a, 1)) sectionA = "x²";
            if (Check.isZero(a)) sectionA = "";
            if (Check.isNegative(a)) sectionA = "" + a + "x²";
        } else {
            a = 1;
            sectionA = "x² ";
        }
        /* B */
        System.out.print(enterValueB);  // вывод в консоль. запрос данных
        b = getUserInput(); // userInput.nextDouble();     // получить данные введенные пользователем и присвоить их переменной b
        if (Check.isNotEmpty(b)) {
            if (Check.isPositive(b)) sectionB = "+" + b + "x";
            if (Check.isPositive(b) && Check.compareTwoNumbers(b, 1)) sectionB = "+x";
            if (Check.isZero(b)) sectionB = "";
            if (Check.isNegative(b)) sectionB = "" + b + "x";
        } else {
            b = 1;
            sectionB = "+x";
        }
        /* C */
        System.out.print(enterValueC);  // вывод в консоль. запрос данных
        c = getUserInput(); // userInput.nextDouble();     // получить данные введенные пользователем и присвоить их переменной c
        if (Check.isNotEmpty(c)) {
            if (Check.isPositive(c)) section3 = "+" + c + "=0";
            if (Check.isZero(c)) section3 = "=0";
            if (Check.isNegative(c)) section3 = "" + c + "=0";
        } else {
            c = 0;
            section3 = "=0";
        }

        if (Check.isZero(a, b, c)) equation = "0 = 0";
        else equation = sectionA + sectionB + section3;

        /* 2. Вычислить Дискриминант */
        if (Check.isZero(a, b, c)) System.out.println(equation);

        if (Check.isZero(a)) {
            /* решить простое уравнение */
            x = -c / b;
            System.out.println(equation);
            System.out.println("x=" + x);
        } else {
            D = Math.pow(b, 2) - 4 * a * c; // Math.pow(b,2) -> использовать метод pow(x, n) класса Math -> pow - возвести число в степень, x - число, n - степень
            dD = "D = " + D;

            /* 3. Решить уравнение и 4. Вывести результат*/

            if (Check.isNegative(D)) { /* 3.1. если (if) D < 0 */
                printEquationAndD();
                System.out.println(dNegative);
            } else if (Check.isZero(D)) { /* 3.2. иначе (else) если (if) D = 0 */
                x = ((-1) * b) / (2 * a);
                printEquationAndD();
                System.out.println(dZeroX + x);
            } else { /* 3.3. иначе (else) */
                x1 = ((-1) * b - Math.sqrt(D)) / (2 * a); // sqrt(n) -> Корень квадратный из n
                x2 = ((-1) * b + Math.sqrt(D)) / (2 * a);
                printEquationAndD();
                System.out.println(dPositiveX1 + x1);
                System.out.println(dPositiveX2 + x2);
            }
        }
    } // end method solveQuadraticEquation()

    /* Вывести уравнение и дискриминант */
    public static void printEquationAndD() {
        System.out.println(equation);
        System.out.println(dD);
    } // end method printEquationAndD()


    /* Получить данные от пользователя */
    public static double getUserInput() {
        Scanner userInput = new Scanner(System.in);
        double num = 0;
        if (userInput.hasNextDouble()) {
            num = userInput.nextDouble();
        } else {
            getUserInput();
        }
        return num;
    }
} // end class Main