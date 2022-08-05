package exercices.exo2;

public class C extends B {
    private String x;

    public String getX() {
        return this.x;
    }

    public void setX(String x) {
        this.x = x;
    }


    public static void main(String[] args) {

    }
    
    public void lol() {
        A a = new A();
        System.out.println(a.getX());
    }
}
