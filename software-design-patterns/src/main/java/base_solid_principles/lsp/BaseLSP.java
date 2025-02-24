package base_solid_principles.lsp;

import base_solid_principles.lsp.demo1.MyRectangle;
import base_solid_principles.lsp.demo1.MySquare;

// LSP 替换原则: 母类能够被子类替换，而不造成问题
// Liskov Substitution Principle
// The parent class can be substituted by a child class
// 1. If S is subtype of T, then object of type T may be replaced with objects of S
//    without modifying the functionality of the program
// 2. Any object of a type must be substitutable by objects of a derived typed
//    without altering the correctness of the program
public class BaseLSP {

    // LSP 主要解决类型之间不正确的关系
    // 1. "Eliminate incorrect relations between objects"
    // 2. "Use \Tell, do not ask\ principle to eliminate type checking and casting"

    // Apply LSP
    // 1. 使用继承必须符号IS-A的逻辑关系，确定衍生类可以被原始类替换
    // 2. Keep base classes small and focused
    // 3. Keep interfaces lean 接口不能太大
    // 4. Make sure that the new derived classes just extend without replacing the functionality of old classes
    //    Make sure that new derived classes are extending the base classes without changing their behavior.
    public void testLSP() {
        MyRectangle rectangle = new MySquare();
        rectangle.setWidth(5);
        rectangle.setHeight(10);
        // user knows that r it's a rectangle.
        // It assumes that he's able to set the width and height as for the base class

        System.out.println(rectangle.getArea());
        // now he's surprised to see that the area is 100 instead of 50
    }

    // TODO: 将母类强制转换成子类会造成Runtime Exception运行时问题
    //  使用"由上往下"的强转，不符号逻辑
    public static void main(String[] args) {
        Shape shape = new Shape();
        Square square = new Square();
        Rectangle rect = new Rectangle();
        rect = (Rectangle) shape;
        System.out.println(square.area());
    }

    private static class Shape {
        public int area() {
            return 1;
        }
    }

    private static class Square extends Shape {
        public int area() {
            return 2;
        }
    }

    private static class Rectangle extends Shape {
        public int area() {
            return 3;
        }
    }
}
