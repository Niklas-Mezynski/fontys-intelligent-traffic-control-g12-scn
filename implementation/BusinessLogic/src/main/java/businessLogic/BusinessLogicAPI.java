package businessLogic;

import factories.SimpleTrafficLightFactory;
import interfaces.AdvancedObservableCrossing;
import interfaces.SimpleObservableCrossing;
import interfaces.TrafficLightFactory;

public class BusinessLogicAPI {
    private final TrafficLightFactory trafficLightFactory = new SimpleTrafficLightFactory();

    public TrafficLightFactory getTrafficLightFactory(){
        return trafficLightFactory;
    }

    public SimpleObservableCrossing createSimpleObservableCrossing(){

        var horPed = trafficLightFactory.createGermanPedestrianTrafficLight("german pedestrian light : horizontal");
        var verPed = trafficLightFactory.createGermanPedestrianTrafficLight("german pedestrian light : vertical");

        var horStr = trafficLightFactory.createGermanStreetTrafficLight("german street light : horizontal");
        var verStr = trafficLightFactory.createGermanStreetTrafficLight("german street light : vertical");
        SimpleObservableCrossing newCrossing = new crossings.SimpleObservableCrossing(horPed, verPed, horStr, verStr);

        return newCrossing;
    }

    public AdvancedObservableCrossing createAdvancedObservableCrossing() {
        var horPed = trafficLightFactory.createGermanPedestrianTrafficLight("german pedestrian light : horizontal");
        var verPed = trafficLightFactory.createGermanPedestrianTrafficLight("german pedestrian light : vertical");

        var horStr = trafficLightFactory.createGermanStreetTrafficLight("german street light : horizontal straight");
        var verStr = trafficLightFactory.createGermanStreetTrafficLight("german street light : vertical straight");
        var horL = trafficLightFactory.createGermanStreetTrafficLight("german street light : horizontal left");
        var verL = trafficLightFactory.createGermanStreetTrafficLight("german street light : vertical left");
        var horR = trafficLightFactory.createGermanStreetTrafficLight("german street light : horizontal right");
        var verR = trafficLightFactory.createGermanStreetTrafficLight("german street light : vertical right");

        AdvancedObservableCrossing newCrossing = new crossings.AdvancedObservableCrossing(horPed, verPed, horStr, verStr);

        newCrossing.addHorizontalLeft(horL);
        newCrossing.addVerticalLeft(verL);
        newCrossing.addHorizontalRight(horR);
        newCrossing.addVerticalRight(verR);

        return newCrossing;
    }
}
