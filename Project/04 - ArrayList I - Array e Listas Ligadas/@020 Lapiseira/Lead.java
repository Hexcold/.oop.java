import java.text.DecimalFormat;

public class Lead {
    private float thickness;
    private String hardness;
    private int size;

    // Construtor do Lead
    public Lead(float thickness, String hardness, int size) {
        this.thickness = thickness;
        this.hardness = hardness;
        this.size = size;
    }

    public String toString() {
        DecimalFormat form = new DecimalFormat("0.0");
        return form.format(thickness) + ":" + hardness + ":" + size;
    }

    public int usagePerSheet() {

        switch (hardness) {
            case "HB":
                return 1;
            case "2B":
                return 2;
            case "4B":
                return 4;
            default:
                return 6;
        }
    }

    public float getThickness() {
        return thickness;
    }

    public String getHardness() {
        return hardness;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}