package shapes;

import interfaces.Shape;

public class ManShape implements Shape {
    protected String name;

    public ManShape(){
        this.name = "Man Shape";
    }

    @Override
    public String toString() {
        return this.name;
    }
}
