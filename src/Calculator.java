
import java.util.Scanner;

public class Calculator {
    private static double[] results = new double[100];
    private static int resultsCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите операцию (+, -, *, /) или 'ф' для вычисления факториала:");
            String operation = scanner.nextLine();

            if (operation.equals("ф")) {
                System.out.println("Введите число для вычисления факториала:");
                int number = scanner.nextInt();
                scanner.nextLine(); // Считываем символ новой строки после числа

                int factorial = calculateFactorial(number);
                System.out.println("Факториал числа: " + number + factorial);
            } else {
                System.out.println("Введите первое число:");
                double num1 = scanner.nextDouble();
                System.out.println("Введите второе число:");
                double num2 = scanner.nextDouble();
                scanner.nextLine(); // Считываем символ новой строки после чисел

                double result = calculate(operation, num1, num2);
                System.out.println("Результат: " + result);

                results[resultsCount] = result;
                resultsCount++;
            }

            System.out.println("Хотите продолжить? (да/нет)");
            String choice = scanner.nextLine();

            if (!choice.equals("да")) {
                break;
            }
        }

        System.out.println("Все результаты совершенных операций:");
        for (int i = 0; i < resultsCount; i++) {
            System.out.println(results[i]);
        }
    }

    private static double calculate(String operation, double num1, double num2) {
        double result = 0;

        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                System.out.println("Неправильная операция");
        }

        return result;
    }

    private static int calculateFactorial(int number) {
        if (number == 0) {
            return 1;
        } else {
            return number * calculateFactorial(number - 1);
        }
    }

    // Перегруженные методы для калькулятора
    private static double calculate(String operation, int num1, int num2) {
        return calculate(operation, (double) num1, (double) num2);
    }

    private static double calculate(String operation, double num1, int num2) {
        return calculate(operation, num1, (double) num2);
    }

    private static double calculate(String operation, int num1, double num2) {
        return calculate(operation, (double) num1, num2);
    }
}
