package frontend.controllers;

import frontend.SceneManager;
import frontend.helpers.CircleShapeObserver;
import frontend.helpers.FXShapeLightObserver;
import interfaces.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import shapes.*;

import java.net.URL;
import java.util.*;
import java.util.function.Supplier;

import static frontend.helpers.ObservableListHelper.entitiesToObservableListDistinct;

public class SingleStreetTrafficLightSimulationController extends ControllerBase implements Initializable {
    Timer timer;
    TrafficLightFactory trafficLightFactory;
    LightBehaviourFactory lightBehaviourFactory;
    StreetTrafficLight currentTrafficLight;
    Map<String, StreetShape> stringToShapeMap;
    Map<String, String> shapeToURLMap;
    Map<String, StreetLightState> behaviourMap;
    boolean isSimulationStarted;

    public SingleStreetTrafficLightSimulationController(Supplier<SceneManager> sceneManager, TrafficLightFactory factory) {
        super(sceneManager);
        this.trafficLightFactory = factory;
        this.lightBehaviourFactory = factory.getLightBehaviourFactory();
        stringToShapeMap = new HashMap<>();
        behaviourMap = new HashMap<>();
        shapeToURLMap = new HashMap<>();
        isSimulationStarted = false;
        resetTimer();
        }

    @FXML
    Circle lightCircle, innerCircle;

    @FXML
    ComboBox<String> behaviourBox, shapeBox;

    @FXML
    ComboBox<Integer> lengthBox;

    @FXML
    TextField stateField;

    Image currentShape;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        resetLight();

        stringToShapeMap.put("Arrow Forward Shape", new ArrowForwardShape());
        stringToShapeMap.put("Arrow Left Shape", new ArrowLeftShape());
        stringToShapeMap.put("Arrow Right Shape", new ArrowRightShape());

        behaviourMap.put("German Street Behaviour", lightBehaviourFactory.getInitialGermanStreetState());
        behaviourMap.put("Dutch Street Behaviour", lightBehaviourFactory.getInitialDutchStreetState());
        behaviourMap.put("Bulgarian Street Behaviour", lightBehaviourFactory.getInitialBulgarianStreetState());

        shapeToURLMap.put("Arrow Forward Shape", "/frontend/shapes/arrowForward.png");
        shapeToURLMap.put("Arrow Left Shape", "/frontend/shapes/arrowLeft.png");
        shapeToURLMap.put("Arrow Right Shape", "/frontend/shapes/arrowRight.png");

        List<String> shapes = new ArrayList<>(stringToShapeMap.keySet());
        shapes.addAll(stringToShapeMap.keySet());
        shapeBox.setItems(entitiesToObservableListDistinct(shapes));

        List<String> behaviours = new ArrayList<>(behaviourMap.keySet());
        behaviourBox.setItems(entitiesToObservableListDistinct(behaviours));

        List<Integer> lengths = List.of(1, 2, 3, 4, 5);
        lengthBox.setItems(entitiesToObservableListDistinct(lengths));

        currentTrafficLight = trafficLightFactory.createGermanStreetTrafficLight("currentTrafficLight");

        shapeBox.setValue("Arrow Forward Shape");
        behaviourBox.setValue("German Street Behaviour");
        lengthBox.setValue(5);

        currentTrafficLight.addLightObserver(new FXShapeLightObserver(lightCircle));
        currentTrafficLight.addShapeObserver(new CircleShapeObserver(innerCircle, shapeToURLMap));

        currentTrafficLight.setShape(new ArrowForwardShape());
    }

    private void resetLight(){
        lightCircle.setFill(Paint.valueOf("black"));
        lightCircle.setStroke(Paint.valueOf("white"));
        stateField.clear();
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
        resetTimer();
        if(!isSimulationStarted){
            isSimulationStarted = true;
            timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        currentTrafficLight.changeToNextState();
                        stateField.setText(currentTrafficLight.getCurrentState().getName());
                    }
                }, 0, lengthBox.getValue() * 1000);
        }
    }

    /**
     * Resets timer.
     */
    private void resetTimer() {
        timer = new Timer();
    }

    /**
     * Ends simulation.
     */
    @FXML
    public void endSimulation() {
        isSimulationStarted = false;
        timer.cancel();
        resetLight();
    }

    /**
     * Changes shape of the current traffic light.
     */
    @FXML
    public void changeShape() {
        currentTrafficLight.setShape(stringToShapeMap.get(shapeBox.getValue()));
    }

    /**
     * Changes light behaviour of the current traffic light.
     */
    @FXML
    public void changeBehaviour() {
        if(isSimulationStarted) {
            endSimulation();
            currentTrafficLight.changeState(behaviourMap.get(behaviourBox.getValue()));
            startSimulation();
        }
        else {
            currentTrafficLight.changeState(behaviourMap.get(behaviourBox.getValue()));
        }
    }

    /**
     * Changes length of the light signal.
     */
    @FXML
    public void changeLength() {
        if(isSimulationStarted) {
            endSimulation();
            startSimulation();
        }
    }
}
