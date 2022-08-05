package implement;

public class BoxedItem implements Sellable {

    private class Boobs {
        String size;

        public Boobs(String size) {
            this.size = size;
        }

        public void pressIt() {
            System.out.println("Pressing some random boobs");
        }
    }

    public BoxedItem() {
        Boobs b = new Boobs("Damn soft");
        b.pressIt();
        System.out.println("Fuck bumby ass and press bumby soft rebounding boobs!");
    }

    @Override
    public void sell() {
        System.out.println("I might consider selling this!");

    }

    @Override
    public void refund() {
        System.out.println("You need to refund this!");

    }

    @Override
    public void fuckBigAss() {
        System.out.println("That shit is soft and pillowly! let's fuck it hard!");

    }

    @Override
    public void protectMySelf() {
        System.out.println("Yeah a nice Condom will be very useful here!");

    }

}
