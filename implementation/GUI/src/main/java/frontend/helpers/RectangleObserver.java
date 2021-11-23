package frontend.helpers;

import interfaces.LightObserver;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class RectangleObserver implements LightObserver {
    private final Rectangle rectangle;

    public RectangleObserver(Rectangle rec){
        this.rectangle = rec;
    }
    @Override
    public void update(String colorHexCode) {
        rectangle.setFill(Paint.valueOf(colorHexCode));
    }
}
