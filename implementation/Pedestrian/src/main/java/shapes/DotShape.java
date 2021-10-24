package shapes;

import interfaces.Shape;

public class DotShape implements Shape {
    protected String name;

    /**
     * Constructor for dot shape object
     */
    public DotShape(){
        this.name = "Dot Shape";
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
