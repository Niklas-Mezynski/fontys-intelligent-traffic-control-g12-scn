package interfaces;

import java.util.Optional;

public interface Crossing {

    void activate(int length);

    void deactivate();

    void startHorizontalTrafficLights();

    void startVerticalTrafficLights();

    PedestrianTrafficLight getHorizontalPedestrianLight();

    PedestrianTrafficLight getVerticalPedestrianLight();

    void addHorizontalLeft(StreetTrafficLight light);

    void addHorizontalRight(StreetTrafficLight light);

    void addVerticalLeft(StreetTrafficLight light);

    void addVerticalRight(StreetTrafficLight light);

    void stopAllVertical();

    void stopAllHorizontal();

    void startHorizontalStraight();

    void startVerticalStraight();

    void startHorizontalRight();

    void startHorizontalLeft();

    void startVerticalRight();

    void startVerticalLeft();
}
