package interfaces;

public interface TrafficLight {

    void changeState(State state);

    void stopTraffic();

    void startTraffic();

    State getCurrentState();

}
