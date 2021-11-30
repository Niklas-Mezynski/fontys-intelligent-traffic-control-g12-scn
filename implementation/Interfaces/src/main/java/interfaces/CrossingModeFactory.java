package interfaces;

public interface CrossingModeFactory {
    /**
     * Creates a crossing with simple crossing logic (Controls only the two main street traffic lights).
     *
     */
    CrossingMode createSimpleCrossingMode();

    /**
     * Creates a crossing with german crossing logic (Controls all street traffic lights).
     * This mode is the normal working mode for all german crossings.
     *
     */
    CrossingMode createGermanCrossingMode();
}
