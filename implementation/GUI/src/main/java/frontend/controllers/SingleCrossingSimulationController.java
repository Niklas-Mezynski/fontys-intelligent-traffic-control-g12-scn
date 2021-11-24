package frontend.controllers;

import frontend.SceneManager;
import frontend.helpers.FXShapeLightObserver;
import interfaces.ObservableCrossing;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

/**
 * Controller for Single Crossing Simulation JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the raw input
 * from the app user.
 */
public class SingleCrossingSimulationController extends ControllerBase implements Initializable{
    ObservableCrossing crossing;
    boolean isActive;

    @FXML
    Circle horizontalCircle1, horizontalCircle2, horizontalCircle3, horizontalCircle4,
            verticalCircle1, verticalCircle2, verticalCircle3, verticalCircle4;

    @FXML
    Rectangle horizontalRectangle1, horizontalRectangle2, verticalRectangle1, verticalRectangle2;

    public SingleCrossingSimulationController(Supplier<SceneManager> sceneManager, ObservableCrossing crossing) {
        super(sceneManager);
        this.crossing = crossing;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        isActive = false;
        resetLights();
        crossing.addHorizontalPedestrianLightObserver(new FXShapeLightObserver(horizontalCircle1));
        crossing.addHorizontalPedestrianLightObserver(new FXShapeLightObserver(horizontalCircle2));
        crossing.addHorizontalPedestrianLightObserver(new FXShapeLightObserver(horizontalCircle3));
        crossing.addHorizontalPedestrianLightObserver(new FXShapeLightObserver(horizontalCircle4));

        crossing.addVerticalPedestrianLightObserver(new FXShapeLightObserver(verticalCircle1));
        crossing.addVerticalPedestrianLightObserver(new FXShapeLightObserver(verticalCircle2));
        crossing.addVerticalPedestrianLightObserver(new FXShapeLightObserver(verticalCircle3));
        crossing.addVerticalPedestrianLightObserver(new FXShapeLightObserver(verticalCircle4));

        crossing.addHorizontalStreetLightObserver(new FXShapeLightObserver(horizontalRectangle1));
        crossing.addHorizontalStreetLightObserver(new FXShapeLightObserver(horizontalRectangle2));

        crossing.addVerticalStreetLightObserver(new FXShapeLightObserver(verticalRectangle1));
        crossing.addVerticalStreetLightObserver(new FXShapeLightObserver(verticalRectangle2));
    }

    private void resetLights(){
        horizontalRectangle1.setStroke(Paint.valueOf("white"));
        horizontalRectangle2.setStroke(Paint.valueOf("white"));
        verticalRectangle1.setStroke(Paint.valueOf("white"));
        verticalRectangle2.setStroke(Paint.valueOf("white"));

        changeColorOfAllLights("black");
    }
    
    private void changeColorOfAllLights(String colorCode){
        horizontalCircle1.setFill(Paint.valueOf(colorCode));
        horizontalCircle2.setFill(Paint.valueOf(colorCode));
        horizontalCircle3.setFill(Paint.valueOf(colorCode));
        horizontalCircle4.setFill(Paint.valueOf(colorCode));

        verticalCircle1.setFill(Paint.valueOf(colorCode));
        verticalCircle2.setFill(Paint.valueOf(colorCode));
        verticalCircle3.setFill(Paint.valueOf(colorCode));
        verticalCircle4.setFill(Paint.valueOf(colorCode));

        horizontalRectangle1.setFill(Paint.valueOf(colorCode));
        horizontalRectangle2.setFill(Paint.valueOf(colorCode));

        verticalRectangle1.setFill(Paint.valueOf(colorCode));
        verticalRectangle2.setFill(Paint.valueOf(colorCode));
    }

    /**
     * Closes simulation.
     */
    @FXML
    public void exit() {
        endSimulation();
        sceneManager.get().changeScene("simulationDashboard");
    }

    /**
     * Starts simulation.
     */
    @FXML
    public void startSimulation() {
        changeColorOfAllLights("red");
        if(!isActive) {
            crossing.activate(10000);
            isActive = true;
        }
    }

    /**
     * Ends simulation.
     */
    @FXML
    public void endSimulation() {
        if(isActive){
            crossing.deactivate();
            resetLights();
            isActive = false;
        }
    }
}
