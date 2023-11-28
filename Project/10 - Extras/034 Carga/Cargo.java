import java.util.*;

public class Cargo {
    private float capacity;
    private ArrayList<Item> items;

    Cargo(float capacity) {
        items = new ArrayList<>();

        this.capacity = capacity;
    }

    @Override
    public String toString() {
        String str = " ";

        for (Item i : items) {
            str += i + " ";
        }

        return str + "_" + getLeftCapacity() + " ";
    }

    public void addItem(String name, float weight) {
        Item item = new Item(weight, name);

        float x = getLeftCapacity() - item.getWeight();

        if (x <= 0) {
            throw new RuntimeException("fail: trem lotado");
        }

        items.add(new Item(weight, name));
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void removeItem(int index) {
        items.remove(index);
    }

    private float getLeftCapacity() {
        float weight = 0;

        for (Item i : items) {
            weight += i.getWeight();
        }

        return capacity - weight;
    }
}