package streetLightBehaviours;

import interfaces.StreetLightState;

/**
 * Light behaviour for simple street traffic lights
 *
 */
public enum SimpleStreetLightBehaviour implements StreetLightState {

    RED_LIGHT(0, false, "Red Light"){

        @Override
        public StreetLightState getNext() {
            return GREEN_LIGHT;
        }

    },

    GREEN_LIGHT(2, true, "Green Light"){

        @Override
        public StreetLightState getNext() {
            return YELLOW_LIGHT;
        }

    },

    YELLOW_LIGHT(0, true, "Yellow Light"){

        @Override
        public StreetLightState getNext() {
            return RED_LIGHT;
        }

    };

    private final int length;
    private final boolean canPass;
    private final String name;

    SimpleStreetLightBehaviour(int length, boolean canPass, String name) {
        this.length = length;
        this.canPass = canPass;
        this.name = name;
    }

    @Override
    public boolean canPass() {
        return canPass;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public String getName() {
        return name;
    }
}
