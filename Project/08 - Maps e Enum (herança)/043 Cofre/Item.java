import java.text.DecimalFormat;

public class Item implements Valuable {

    private String label;
    private double value;
    private int volume;

    public Item(String label, double value, int volume) {
        this.label = label;
        this.value = value;
        this.volume = volume;
    }

    public String getLabel() {
        return this.label;
    }

    public double getValue() {
        return this.value;
    }

    public int getVolume() {
        return this.volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return this.label + ":" + df.format(this.value) + ":" + this.volume;
    }
}