package shapes;

import interfaces.Shape;

public class CustomShape implements Shape {
    protected String name;

    /**
     * Constructor for custom shape object
     */
    public CustomShape(String name){
        this.name = name;
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
