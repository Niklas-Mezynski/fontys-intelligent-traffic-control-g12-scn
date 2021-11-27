package crossings;

import interfaces.LightObserver;
import interfaces.SimpleObservableCrossing;
import interfaces.PedestrianTrafficLight;
import interfaces.StreetTrafficLight;

public class AdvancedObservableCrossing extends GermanCrossing implements interfaces.AdvancedObservableCrossing {
    public AdvancedObservableCrossing(PedestrianTrafficLight horizontalPedestrianTrafficLight, PedestrianTrafficLight verticalPedestrianTrafficLight, StreetTrafficLight horizontalStraight, StreetTrafficLight verticalStraight) {
        super(horizontalPedestrianTrafficLight, verticalPedestrianTrafficLight, horizontalStraight, verticalStraight);
    }

    @Override
    public void addHorizontalPedestrianLightObserver(LightObserver observer) {
        super.horizontalPedestrianTrafficLight.addLightObserver(observer);
    }

    @Override
    public void addVerticalPedestrianLightObserver(LightObserver observer) {
        super.verticalPedestrianTrafficLight.addLightObserver(observer);
    }

    @Override
    public void addHorizontalLeftStreetLightObserver(LightObserver observer) {
        super.horizontalStreetTrafficLightLeft.ifPresent(streetTrafficLight -> streetTrafficLight.addLightObserver(observer));
    }

    @Override
    public void addVerticalLeftStreetLightObserver(LightObserver observer) {
        super.verticalStreetTrafficLightLeft.ifPresent(streetTrafficLight -> streetTrafficLight.addLightObserver(observer));
    }

    @Override
    public void addHorizontalRightStreetLightObserver(LightObserver observer) {
        super.horizontalStreetTrafficLightRight.ifPresent(streetTrafficLight -> streetTrafficLight.addLightObserver(observer));
    }

    @Override
    public void addVerticalRightStreetLightObserver(LightObserver observer) {
        super.verticalStreetTrafficLightRight.ifPresent(streetTrafficLight -> streetTrafficLight.addLightObserver(observer));
    }

    @Override
    public void addHorizontalStraightStreetLightObserver(LightObserver observer) {
        super.horizontalStreetTrafficLightStraight.addLightObserver(observer);
    }

    @Override
    public void addVerticalStraightStreetLightObserver(LightObserver observer) {
        super.verticalStreetTrafficLightStraight.addLightObserver(observer);
    }
}
