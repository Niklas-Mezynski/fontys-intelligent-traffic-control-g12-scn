package factories;

import crossingModes.EmergyencyCrossingMode;
import crossingModes.GermanCrossingMode;
import crossingModes.SimpleGermanCrossingMode;
import interfaces.CrossingMode;
import interfaces.CrossingModeFactory;

public class SimpleCrossingModeFactory implements CrossingModeFactory {
    @Override
    public CrossingMode createSimpleCrossingMode() {
        return new SimpleGermanCrossingMode();
    }

    @Override
    public CrossingMode createGermanCrossingMode() {
        return new GermanCrossingMode();
    }

    @Override
    public CrossingMode createEmergencyCrossingMode() {
        return new EmergyencyCrossingMode();
    }
}
