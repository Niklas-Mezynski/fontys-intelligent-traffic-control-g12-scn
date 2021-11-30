package interfaces;

public interface BusinessLogicAPI {
    TrafficLightFactory getTrafficLightFactory();

    BasicObservableCrossing createBasicObservableCrossing();

    AdvancedObservableCrossing createAdvancedObservableCrossing();
}
