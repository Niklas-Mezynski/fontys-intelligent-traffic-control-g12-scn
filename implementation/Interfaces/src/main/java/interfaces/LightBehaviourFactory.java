package interfaces;

public interface LightBehaviourFactory {
    PedestrianLightState getInitialDutchPedestrianState();

    PedestrianLightState getInitialGermanPedestrianState();

    PedestrianLightState getInitialAustralianPedestrianState();

    StreetLightState getInitialDutchStreetState();

    StreetLightState getInitialGermanStreetState();

    StreetLightState getInitialBulgarianStreetState();
}
