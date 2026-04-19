package sample;
import java.util.Scanner;

abstract class Shape {

 int a, b;

 abstract void printArea(); 

}

class Rectangle extends Shape {

 Rectangle(int length, int width) {

     this.a = length;

     this.b = width;

 }

 void printArea() {

     int area = a * b;

     System.out.println("Rectangle area: " + area);

 }

}

class Triangle extends Shape {

 Triangle(int base, int height) {

     this.a = base;

     this.b = height;

 }

 void printArea() {

     double area = 0.5 * a * b;

     System.out.println("Triangle area: " + area);

 }

}

class Circle extends Shape {

 Circle(int radius) {

     this.a = radius; // use 'a' as radius

 }



 void printArea() {

     double area = 3.1416 * a * a;

     System.out.println("Circle area: " + area);

 }

}

public class ShapeDemo {

 public static void main(String[] args) {

     Scanner sc = new Scanner(System.in);

     System.out.print("Enter length of rectangle: ");

     int rectLength = sc.nextInt();

     System.out.print("Enter width of rectangle: ");

     int rectWidth = sc.nextInt();

     Rectangle rect = new Rectangle(rectLength, rectWidth);

     rect.printArea();

     System.out.print("Enter base of triangle: ");

     int triBase = sc.nextInt();

     System.out.print("Enter height of triangle: ");

     int triHeight = sc.nextInt();

     Triangle tri = new Triangle(triBase, triHeight);

     tri.printArea();

     System.out.print("Enter radius of circle: ");

     int radius = sc.nextInt();

     Circle circle = new Circle(radius);

     circle.printArea();

     sc.close();

 }

}
