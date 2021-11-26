package streetLightBehaviours;

import interfaces.StreetLightState;

public enum EmergencyStreetLightBehaviour implements StreetLightState {
    YELLOW_BLINKING_LIGHT(LightStateMeaning.EMERGENCY, "Emergency Light"){
        @Override
        public String getColorHex() {
            return "#FFFE00";
        }

        @Override
        public StreetLightState getNext() {
            return this ;
        }

    };

    private final LightStateMeaning stateMeaning;
    private final String name;

    EmergencyStreetLightBehaviour (LightStateMeaning stateMeaning, String name) {
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

