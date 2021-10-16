package shapes;

import interfaces.Shape;

public class CustomShape implements Shape {
    protected String name;

    public CustomShape(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
