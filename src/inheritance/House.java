public class House extends Building {
    private int numRooms;

    public House(int numRooms, String name) {
        super(name);
        this.numRooms = numRooms;
        super.fuckBigAss();
    }

    public int getNumRooms() {
        return this.numRooms;
    }

    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }

    @Override
    public String toString() {
        return "{" +
                " numRooms='" + getNumRooms() + "'" +
                "}";
    }

}
