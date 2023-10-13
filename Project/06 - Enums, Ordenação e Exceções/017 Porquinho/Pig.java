import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pig {

    private boolean broken;
    private List<Coin> coins;
    private List<Item> items;
    private int volumeMax;

    public Pig(int volumeMax) {
        this.broken = false;
        this.coins = new ArrayList<>();
        this.items = new ArrayList<>();
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

    public boolean addCoin(Coin coin) throws Exception {
        if (isBroken()) {
            Solver.println("fail: the pig is broken");
            items.clear();
            return false;
        }

        if (getVolume() + coin.getVolume() > volumeMax) {
            Solver.println("fail: the pig is full");
            return false;
        }

        coins.add(coin);
        return true;
    }

    public boolean addItem(Item item) throws Exception {
        if (isBroken()) {
            Solver.println("fail: the pig is broken");
            items.clear();
            return false;
        }

        if (getVolume() + item.getVolume() > volumeMax) {
            Solver.println("fail: the pig is full");
            return false;
        }
        items.add(item);
        return true;
    }

    public boolean breakPig() {
        if (!isBroken()) {
            this.broken = true;
            return true;
        }
        return false;
    }

    public List<String> extractCoins() {
        if (!isBroken()) {
            Solver.println("fail: you must break the pig first");
            return new ArrayList<>();
        }

        ArrayList<String> coins = new ArrayList<>();

        for (Coin i : this.coins) {
            coins.add(i.toString());
        }

        this.coins = new ArrayList<>();

        return coins;
    }

    public List<String> extractItems() {
        if (isBroken()) {
            List<String> extractedItems = items.stream()
                    .map(item -> item.getLabel() + ":" + item.getVolume())
                    .collect(Collectors.toList());
            items.clear();
            return new ArrayList<>(extractedItems);
        }
        Solver.println("fail: you must break the pig first");
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        double value = getValue();
        int totalVolume = getVolume();
        return "state=" + (broken ? "broken" : "intact") + " : coins=[" + getCoinString() + "] : items=["
                + getItemString() + "] : value=" + df.format(value) + " : volume=" + totalVolume + "/" + volumeMax;
    }

    public int getVolume() {
        if (isBroken()) {
            return 0;
        }

        int totalVolume = 0;
        for (Coin coin : coins) {
            totalVolume += coin.getVolume();
        }

        for (Item item : items) {
            totalVolume += item.getVolume();
        }
        return totalVolume;
    }

    public double getValue() {
        double totalValue = 0.0;
        for (Coin coin : coins) {
            totalValue += coin.getValue();
        }
        return totalValue;
    }

    private String getCoinString() {
        List<String> coinStrings = new ArrayList<>();
        for (Coin coin : coins) {
            coinStrings.add(coin.toString());
        }
        return String.join(", ", coinStrings);
    }

    private String getItemString() {
        List<String> itemStrings = new ArrayList<>();
        for (Item item : items) {
            itemStrings.add(item.toString());
        }
        return String.join(", ", itemStrings);
    }

    public int getVolumeMax() {
        return this.volumeMax;
    }

    public int getVolumeRestante() {
        return this.volumeMax - getVolume();
    }

    public boolean isBroken() {
        return this.broken;
    }
}
