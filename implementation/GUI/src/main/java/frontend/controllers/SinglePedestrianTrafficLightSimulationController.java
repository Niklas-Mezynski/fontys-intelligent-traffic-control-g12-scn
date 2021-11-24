package frontend.controllers;

import frontend.SceneManager;
import frontend.helpers.CircleShapeObserver;
import frontend.helpers.FXShapeLightObserver;
import interfaces.*;
import static frontend.helpers.ObservableListHelper.entitiesToObservableListDistinct;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import shapes.DonkeyShape;
import shapes.DotShape;
import shapes.ManShape;

import java.net.URL;
import java.util.*;
import java.util.function.Supplier;

public class SinglePedestrianTrafficLightSimulationController extends ControllerBase implements Initializable {
    Timer timer;
    TrafficLightFactory trafficLightFactory;
    LightBehaviourFactory lightBehaviourFactory;
    PedestrianTrafficLight currentTrafficLight;
    Map<String, Shape> stringToShapeMap;
    Map<String, String> shapeToURLMap;
    Map<String, PedestrianLightState> behaviourMap;
    boolean isSimulationStarted;

    public SinglePedestrianTrafficLightSimulationController(Supplier<SceneManager> sceneManager, TrafficLightFactory factory) {
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

        stringToShapeMap.put("Dot Shape", new DotShape());
        stringToShapeMap.put("Man Shape", new ManShape());
        stringToShapeMap.put("Donkey Shape", new DonkeyShape());

        behaviourMap.put("German Pedestrian Behaviour", lightBehaviourFactory.getInitialGermanPedestrianState());
        behaviourMap.put("Dutch Pedestrian Behaviour", lightBehaviourFactory.getInitialDutchPedestrianState());
        behaviourMap.put("Australian Pedestrian Behaviour", lightBehaviourFactory.getInitialAustralianPedestrianState());

        shapeToURLMap.put("Dot Shape", "/frontend/shapes/dotShape.png");
        shapeToURLMap.put("Donkey Shape", "/frontend/shapes/donkeyShape.png");
        shapeToURLMap.put("Man Shape", "/frontend/shapes/manShape.png");

        List<String> shapes = new ArrayList<>(stringToShapeMap.keySet());
        shapeBox.setItems(entitiesToObservableListDistinct(shapes));

        List<String> behaviours = new ArrayList<>(behaviourMap.keySet());
        behaviourBox.setItems(entitiesToObservableListDistinct(behaviours));

        List<Integer> lengths = List.of(1, 2, 3, 4, 5);
        lengthBox.setItems(entitiesToObservableListDistinct(lengths));

        currentTrafficLight = trafficLightFactory.createGermanPedestrianTrafficLight("currentTrafficLight");

        shapeBox.setValue("Dot Shape");
        behaviourBox.setValue("German Pedestrian Behaviour");
        lengthBox.setValue(5);

        currentTrafficLight.addLightObserver(new FXShapeLightObserver(lightCircle));
        currentTrafficLight.addShapeObserver(new CircleShapeObserver(innerCircle, shapeToURLMap));

        currentTrafficLight.setShape(new DotShape());
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
        //setCurrentShape(shapeBox.getValue());
    }

//    private void setCurrentShape(String shape){
//        currentShape = new Image(getClass().getResource(shapeToURLMap.get(shape)).toExternalForm());
//        innerCircle.setFill(new ImagePattern(currentShape));
//    }

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
