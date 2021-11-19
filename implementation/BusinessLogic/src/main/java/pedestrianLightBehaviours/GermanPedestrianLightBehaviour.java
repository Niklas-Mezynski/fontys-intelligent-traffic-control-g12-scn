package pedestrianLightBehaviours;

import interfaces.PedestrianLightState;

/**
 * Light behaviour for german pedestrian traffic lights
 *
 */
public enum GermanPedestrianLightBehaviour implements PedestrianLightState {

    RED_LIGHT(LightStateMeaning.STOP, "Red Light"){

        @Override
        public PedestrianLightState getNext() {
            return GREEN_LIGHT;
        }

    },

    GREEN_LIGHT(LightStateMeaning.PASS, "Green Light"){

        @Override
        public PedestrianLightState getNext() {
            return RED_LIGHT;
        }

    };


    private final LightStateMeaning stateMeaning;
    private final String name;

    GermanPedestrianLightBehaviour (LightStateMeaning stateMeaning, String name) {
        this.stateMeaning = stateMeaning;
        this.name = name;
    }

    @Override
    public LightStateMeaning stateMeaning() {
        return stateMeaning;
    }

    @Override
    public String getName() {
        return name;
    }
}
