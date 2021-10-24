package shapes;

import interfaces.Shape;

public class DonkeyShape implements Shape {
    protected String name;

    /**
     * Constructor for donkey shape object
     */
    public DonkeyShape(){
        this.name = "Donkey Shape";
    }

    /**
     * Returns text representation of the shape
     *
     * @return String representation of the shape
     */
    @Override
    public String toString() {
        return this.name;
    }
}
