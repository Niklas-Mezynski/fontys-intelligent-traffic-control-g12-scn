package shapes;

import interfaces.Shape;

public class ManShape implements Shape {
    protected String name;

    /**
     * Constructor for man shape object
     */
    public ManShape(){
        this.name = "Man Shape";
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
