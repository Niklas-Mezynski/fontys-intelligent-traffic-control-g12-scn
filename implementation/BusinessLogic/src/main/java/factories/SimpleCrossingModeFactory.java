package factories;

import crossingModes.DutchCrossingMode;
import crossingModes.EmergencyCrossingMode;
import crossingModes.GermanCrossingMode;
import crossingModes.SimpleGermanCrossingMode;
import interfaces.CrossingMode;
import interfaces.CrossingModeFactory;

import java.util.ArrayList;
import java.util.List;

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
        return new EmergencyCrossingMode();
    }

    @Override
    public CrossingMode createDutchCrossingMode() {
        return new DutchCrossingMode();
    }

    @Override
    public List<CrossingMode> getAllCrossingModes() {

        ArrayList<CrossingMode> list = new ArrayList<>();
        list.add(new SimpleGermanCrossingMode());
        list.add(new GermanCrossingMode());
        list.add(new EmergencyCrossingMode());
        list.add(new DutchCrossingMode());

        return list;
    }


}
