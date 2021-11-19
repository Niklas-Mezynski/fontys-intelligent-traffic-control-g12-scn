package streetLightBehaviours;

import interfaces.StreetLightState;

public enum DutchStreetLightBehaviour implements StreetLightState {

    RED_LIGHT(LightStateMeaning.STOP, "Red Light"){

        @Override
        public StreetLightState getNext() {
            return GREEN_LIGHT;
        }

    },

    GREEN_LIGHT(LightStateMeaning.PASS, "Green Light"){

        @Override
        public StreetLightState getNext() {
            return YELLOW_LIGHT;
        }

    },

    YELLOW_LIGHT(LightStateMeaning.TRANSITION, "Yellow Light"){

        @Override
        public StreetLightState getNext() {
            return RED_LIGHT;
        }

    };


    private final LightStateMeaning stateMeaning;
    private final String name;

    DutchStreetLightBehaviour (LightStateMeaning stateMeaning, String name) {
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
