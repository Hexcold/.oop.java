import java.text.DecimalFormat;

public enum Coin {

    C10("C10", 0.10, 1),
    C25("C25", 0.25, 2),
    C50("C50", 0.50, 3),
    C100("C100", 1.00, 4);

    private double value;
    private int volume;
    private String label;

    private Coin(String label, double value, int volume) {
        this.value = value;
        this.volume = volume;
        this.label = label;
    }

    public double getValue() {
        return value;
    }

    public int getVolume() {
        return volume;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(value) + ":" + volume;
    }
}
