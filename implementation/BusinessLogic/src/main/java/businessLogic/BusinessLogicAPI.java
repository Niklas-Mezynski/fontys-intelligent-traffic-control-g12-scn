package businessLogic;

import crossings.SimpleObservableCrossing;
import factories.SimpleTrafficLightFactory;
import interfaces.ObservableCrossing;
import interfaces.TrafficLightFactory;

public class BusinessLogicAPI {
    private final TrafficLightFactory trafficLightFactory = new SimpleTrafficLightFactory();

    public TrafficLightFactory getTrafficLightFactory(){
        return trafficLightFactory;
    }

    public ObservableCrossing createSimpleObservableCrossing(){

        var horPed = trafficLightFactory.createGermanPedestrianTrafficLight("german pedestrian light : horizontal");
        var verPed = trafficLightFactory.createGermanPedestrianTrafficLight("german pedestrian light : vertical");

        var horStr = trafficLightFactory.createGermanStreetTrafficLight("german street light : horizontal");
        var verStr = trafficLightFactory.createGermanStreetTrafficLight("german street light : vertical");
        ObservableCrossing newCrossing = new SimpleObservableCrossing(horPed, verPed, horStr, verStr);

        return newCrossing;
    }
}
