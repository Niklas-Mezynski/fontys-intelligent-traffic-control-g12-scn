package streetLightBehaviours;

import interfaces.StreetLightState;

public enum GermanStreetLightBehaviour implements StreetLightState {

    RED_LIGHT(0, false, "Red Light"){

        @Override
        public StreetLightState getNext() {
            return RED_YELLOW;
        }

    },

    GREEN_LIGHT(2, true, "Green Light"){

        @Override
        public StreetLightState getNext() {
            return YELLOW;
        }

    },

    RED_YELLOW(0, false, "Red Yellow Light"){

        @Override
        public StreetLightState getNext() {
            return GREEN_LIGHT;
        }

    },
    YELLOW(0, false, "Yellow Light"){

        @Override
        public StreetLightState getNext() {
            return RED_LIGHT;
        }

    };


    @Override
    public StreetLightState getNext() {
        return null;
    }

    private final int length;
    private final boolean canPass;
    private final String name;

    GermanStreetLightBehaviour(int length, boolean canPass, String name) {
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

