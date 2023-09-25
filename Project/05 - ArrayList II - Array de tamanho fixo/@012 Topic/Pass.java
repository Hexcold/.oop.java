public class Pass {
    private String name;
    private int age;

    public Pass(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public boolean isPriority() {
        return age >= 65;
    }

    public String getName() {
        return this.name;
    }
    
    public int getAge() {
        return age;
    }
    
    @Override
    public String toString(){
        return this.name + ":" + this.age;
    }

}