import java.text.DecimalFormat;

public class Circle extends Shape {
    public Point2D center;
    public double radius;

    public Circle(Point2D center, double radius) {
        super("Circ");
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return super.toString() + "C=(" + this.center + "), R=" + df.format(this.radius);
    }
}
