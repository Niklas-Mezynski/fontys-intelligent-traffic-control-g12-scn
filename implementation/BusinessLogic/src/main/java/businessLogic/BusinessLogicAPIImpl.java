package businessLogic;

import factories.SimpleCrossingModeFactory;
import factories.SimpleTrafficLightFactory;
import interfaces.*;

/**
 * Hub with access to the business logic layer.
 */
public class BusinessLogicAPIImpl implements BusinessLogicAPI {
    private final TrafficLightFactory trafficLightFactory = new SimpleTrafficLightFactory();
    private final CrossingModeFactory crossingModeFactory = new SimpleCrossingModeFactory();

    public TrafficLightFactory getTrafficLightFactory(){
        return trafficLightFactory;
    }

    public BasicObservableCrossing createBasicObservableCrossing(){

        PedestrianTrafficLight horPed = trafficLightFactory.createGermanPedestrianTrafficLight("german pedestrian light : horizontal");
        PedestrianTrafficLight verPed = trafficLightFactory.createGermanPedestrianTrafficLight("german pedestrian light : vertical");

        StreetTrafficLight horStr = trafficLightFactory.createGermanStreetTrafficLight("german street light : horizontal");
        StreetTrafficLight verStr = trafficLightFactory.createGermanStreetTrafficLight("german street light : vertical");

        CrossingMode simpleCrossingMode = crossingModeFactory.createSimpleCrossingMode();

        return new crossings.BasicObservableCrossing(simpleCrossingMode, horPed, verPed, horStr, verStr);
    }

    public AdvancedObservableCrossing createAdvancedObservableCrossing() {
        PedestrianTrafficLight horPed = trafficLightFactory.createGermanPedestrianTrafficLight("german pedestrian light : horizontal");
        PedestrianTrafficLight verPed = trafficLightFactory.createGermanPedestrianTrafficLight("german pedestrian light : vertical");

        StreetTrafficLight horStr = trafficLightFactory.createGermanStreetTrafficLight("german street light : horizontal straight");
        StreetTrafficLight verStr = trafficLightFactory.createGermanStreetTrafficLight("german street light : vertical straight");
        StreetTrafficLight horL = trafficLightFactory.createGermanStreetTrafficLight("german street light : horizontal left");
        StreetTrafficLight verL = trafficLightFactory.createGermanStreetTrafficLight("german street light : vertical left");
        StreetTrafficLight horR = trafficLightFactory.createGermanStreetTrafficLight("german street light : horizontal right");
        StreetTrafficLight verR = trafficLightFactory.createGermanStreetTrafficLight("german street light : vertical right");

        CrossingMode germanCrossingMode = crossingModeFactory.createGermanCrossingMode();

        AdvancedObservableCrossing newCrossing = new crossings.AdvancedObservableCrossing(germanCrossingMode, horPed, verPed, horStr, verStr);

        newCrossing.addHorizontalLeft(horL);
        newCrossing.addVerticalLeft(verL);
        newCrossing.addHorizontalRight(horR);
        newCrossing.addVerticalRight(verR);

        return newCrossing;
    }

    @Override
    public CrossingModeFactory getCrossingModeFactory() {
        return crossingModeFactory;
    }
}
