package factories;

import crossingModes.GermanCrossingMode;
import crossingModes.SimpleCrossingMode;
import interfaces.CrossingMode;
import interfaces.CrossingModeFactory;

public class SimpleCrossingModeFactory implements CrossingModeFactory {
    @Override
    public CrossingMode createSimpleCrossingMode() {
        return new SimpleCrossingMode();
    }

    @Override
    public CrossingMode createGermanCrossingMode() {
        return new GermanCrossingMode();
    }
}
