package crossings;


import interfaces.Crossing;
import interfaces.PedestrianTrafficLight;
import interfaces.StreetTrafficLight;
import shapes.ArrowForwardShape;

import java.util.HashMap;
import java.util.List;

/**
 * Extends SimpleCrossing, change handling of the start- and stopmethods.
 */
public class CrossingBase implements Crossing {

    // "Left" <>
    // "Straight" <>
    // "Right <>"
    private HashMap<String, StreetTrafficLight> horizontalLights;
    private HashMap<String, StreetTrafficLight> verticalLights;

    public CrossingBase(List<StreetTrafficLight> lights) {
        
    }

    @Override
    public void addPedestrianTrafficLightPair(PedestrianTrafficLight a, PedestrianTrafficLight b) {

    }

    @Override
    public void addStreetTrafficLightPair(StreetTrafficLight a, StreetTrafficLight b) {

    }

    @Override
    public void removePedestrianTrafficLightPair() {

    }

    @Override
    public void removeStreetTrafficLightPair() {

    }

    @Override
    public void activate(int length) {

    }

    @Override
    public void deactivate() {

    }

    @Override
    public void startHorizontalTrafficLights() {

    }

    @Override
    public void startVerticalTrafficLights() {

    }

    @Override
    public PedestrianTrafficLight getHorizontalPedestrianLight() {
        return null;
    }

    @Override
    public PedestrianTrafficLight getVerticalPedestrianLight() {
        return null;
    }
}
