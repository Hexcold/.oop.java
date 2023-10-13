public class Item {

    private String label;
    private int volume;

    public Item(String label, int volume) {
        this.label = label;
        this.volume = volume;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getVolume() {
        return this.volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return label + ":" + volume;
    }

}
