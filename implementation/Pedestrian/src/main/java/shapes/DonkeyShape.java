package shapes;

import interfaces.Shape;

public class DonkeyShape implements Shape {
    protected String name;

    public DonkeyShape(){
        this.name = "Donkey Shape";
    }

    @Override
    public String toString() {
        return this.name;
    }
}
