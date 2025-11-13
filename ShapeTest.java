// Abstract class Shape
abstract class Shape {
    int dim1, dim2;

    Shape(int a, int b) {
        dim1 = a;
        dim2 = b;
    }

    abstract void printArea();
}

// Rectangle class
class Rectangle extends Shape {
    Rectangle(int length, int breadth) {
        super(length, breadth);
    }

    void printArea() {
        int area = dim1 * dim2;
        System.out.println("Area of Rectangle: " + area);
    }
}

// Triangle class
class Triangle extends Shape {
    Triangle(int base, int height) {
        super(base, height);
    }

    void printArea() {
        double area = 0.5 * dim1 * dim2;
        System.out.println("Area of Triangle: " + area);
    }
}

// Circle class (corrected)
class Circle extends Shape {
    Circle(int radius) {
        super(radius, 0);  // dim2 is unused
    }

    void printArea() {
        double area = 3.14f * dim1 * dim1;
        System.out.println("Area of Circle: " + area);
    }
}

// Main class to test the shapes
public class ShapeTest {
    public static void main(String[] args) {
        Shape rect = new Rectangle(10, 5);
        Shape tri = new Triangle(8, 6);
        Shape circ = new Circle(7);

        rect.printArea();
        tri.printArea();
        circ.printArea();
    }
}