package frontend.helpers;

import interfaces.LightObserver;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class CircleLightObserver implements LightObserver {
    private final Circle circle;

    public CircleLightObserver(Circle circle){
        this.circle = circle;
    }
    @Override
    public void update(String colorHexCode) {
        circle.setFill(Paint.valueOf(colorHexCode));
    }
}
