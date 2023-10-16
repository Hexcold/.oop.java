import java.text.DecimalFormat;

public abstract class Shape {
    public String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean inside(Point2D point) {
        return false;
    }

    public abstract double getArea();

    public double getPerimeter() {
        return 0.0;
    }

    public String getInfo() {
        DecimalFormat df = new DecimalFormat("0.00");
        return this.name + ": A=" + df.format(this.getArea()) + " P=" + df.format(this.getPerimeter());
    }

    @Override
    public String toString() {
        return this.name + ": ";
    }
}
