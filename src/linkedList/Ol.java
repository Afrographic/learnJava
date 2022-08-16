package linkedList;

public class Ol{
    private String name;

    public Ol(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Ol copy(Ol obj) {
        return new Ol(obj.getName());
    }
}
