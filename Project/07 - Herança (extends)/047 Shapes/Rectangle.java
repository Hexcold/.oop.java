public class Rectangle extends Shape {
    public Point2D p1, p2;

    public Rectangle(Point2D p1, Point2D p2) {
        super("Rect");
        this.p1 = p1;
        this.p2 = p2;
    }

    public double getArea() {
        double base   = Math.abs(this.p1.x - this.p2.x);
        double altura = Math.abs(this.p1.y - this.p2.y);
        return base * altura;
    }

    public double getPerimeter() {
        double base   = Math.abs(this.p1.x - this.p2.x);
        double altura = Math.abs(this.p1.y - this.p2.y);
        return 2 * (base + altura);
    }

    @Override
    public String toString() {
        return super.toString() + "P1=(" + this.p1 + ") P2=(" + this.p2 + ")";  
    }
}