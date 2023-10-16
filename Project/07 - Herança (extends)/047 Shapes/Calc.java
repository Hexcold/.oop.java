public class Calc {
    public static double distance(Point2D a, Point2D b) {
        double cH = a.x - b.x;
        double cV = a.y - b.y;
        return Math.sqrt(cH * cH + cV * cV);
    }
}
