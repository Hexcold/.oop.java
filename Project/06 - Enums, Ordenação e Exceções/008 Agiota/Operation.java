import java.util.*;

public class Operation {
    private static int nextOpId = 0;
    private int id;
    private String name;
    private Label label;
    private int value;

    public Operation(String name, Label label, int value) {
        this.name = name;
        this.label = label;
        this.value = value;
        this.id = Operation.nextOpId++;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Label getLabel() {
        return this.label;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "id:" + this.id + " " + this.label + ":" + this.name + " " + this.value;
    }
}