package shapes;

import interfaces.Shape;

public class DotShape implements Shape {
    protected String name;

    public DotShape(){
        this.name = "Dot Shape";
    }

    @Override
    public String toString() {
        return this.name;
    }
}
