package frontend.helpers;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class FXShapeLightObserver implements interfaces.LightObserver {
    private final Shape shape;

    public FXShapeLightObserver(Shape rec){
        this.shape = rec;
    }
    @Override
    public void update(String colorHexCode) {
        shape.setFill(Paint.valueOf(colorHexCode));
    }
}
