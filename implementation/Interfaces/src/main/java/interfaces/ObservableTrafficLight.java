package interfaces;

public interface ObservableTrafficLight {
    void addLightObserver(LightObserver o);

    void removeLightObserver(LightObserver o);

    void informForLightChange();

    void addShapeObserver(ShapeObserver o);

    void informForShapeChange(Shape shape);
}


