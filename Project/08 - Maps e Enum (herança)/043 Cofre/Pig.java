import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

class Pig {

    private boolean broken;
    private int volumeMax;
    private List<Valuable> valuables;

    public Pig(int volumeMax) {
        this.broken = false;
        this.valuables = new ArrayList<Valuable>();
        this.volumeMax = volumeMax;
    }

    public Coin createCoin(String valor) {
        switch (valor) {
            case "10":
                return Coin.C10;
            case "25":
                return Coin.C25;
            case "50":
                return Coin.C50;
            case "100":
                return Coin.C100;
            default:
                return null;
        }
    }

    public boolean addValuable(Valuable valuable) throws Exception {
        if (this.broken) {
            throw new Exception("fail: the pig is broken");
        }

        if (valuable.getVolume() > this.getVolumeRestante()) {
            throw new Exception("fail: the pig is full");
        }

        this.valuables.add(valuable);
        return true;
    }

    public boolean breakPig() throws Exception {
        if (this.broken) {
            throw new Exception("fail: the pig is broken");
        }

        this.broken = true;
        return true;
    }

    public ArrayList<String> extractCoins() throws Exception {
        if (!this.broken) {
            throw new Exception("fail: you must break the pig first");
        }

        ArrayList<String> labels = new ArrayList<String>();

        for (Valuable v : this.valuables) {
            if (v instanceof Coin) {
                labels.add(v.toString());
            }
        }

        for (int i = 0; i < this.valuables.size(); i++) {
            Valuable v = this.valuables.get(i);
            if (v instanceof Coin) {
                this.valuables.remove(i);
                i--;
            }
        }

        return labels;
    }

    public ArrayList<String> extractItems() throws Exception {
        if (!this.broken) {
            throw new Exception("fail: you must break the pig first");
        }

        ArrayList<String> labels = new ArrayList<String>();

        for (Valuable v : this.valuables) {
            if (v instanceof Item) {
                labels.add(v.toString());
            }
        }

        for (int i = 0; i < this.valuables.size(); i++) {
            Valuable v = this.valuables.get(i);
            if (v instanceof Item) {
                this.valuables.remove(i);
                i--;
            }
        }

        return labels;
    }

    @Override
    public String toString() {
        DecimalFormat d = new DecimalFormat("0.00");
        String st = "";
        st += this.valuables + " : ";
        st += d.format(this.getValue()) + "$ : ";
        st += this.getVolume() + "/" + this.getVolumeMax() + " : ";
        st += ((this.broken) ? "broken" : "intact");
        return st;
    }

    public int getVolume() {
        if (this.isBroken()) {
            return 0;
        }

        int volume = 0;

        for (Valuable v : this.valuables) {
            volume += v.getVolume();
        }
        return volume;
    }

    public double getValue() {
        double value = 0;
        for (Valuable v : this.valuables) {
            value += v.getValue();
        }
        return value;
    }

    public int getVolumeMax() {
        return this.volumeMax;
    }

    public int getVolumeRestante() {
        return this.getVolumeMax() - this.getVolume();
    }

    public boolean isBroken() {
        return this.broken;
    }
}