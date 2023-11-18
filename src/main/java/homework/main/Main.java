package homework.main;

import homework.classes.Calc;
import homework.classes.Decorator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        /**
         * Точка входа в программу. С неё всегда всё начинается.
         *
         * @param args стандартные аргументы командной строки
         */
        int result = Calc.add(6, 2);
        System.out.println(Decorator.decorate(result));

        result = Calc.sub(6, 2);
        System.out.println(Decorator.decorate(result));

        result = Calc.mul(6, 2);
        System.out.println(Decorator.decorate(result));

        result = Calc.div(6, 2);
        System.out.println(Decorator.decorate(result));
    }
}