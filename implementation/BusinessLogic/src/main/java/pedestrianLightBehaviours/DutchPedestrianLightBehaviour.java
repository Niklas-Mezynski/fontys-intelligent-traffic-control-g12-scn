package pedestrianLightBehaviours;

import interfaces.PedestrianLightState;

/**
 * Light behaviour for dutch pedestrian traffic lights
 *
 */
public enum DutchPedestrianLightBehaviour implements PedestrianLightState {

    RED_LIGHT(0, false, "Red Light"){

        @Override
        public PedestrianLightState getNext() {
            return GREEN_LIGHT;
        }

    },

    GREEN_LIGHT(2, true, "Green Light"){

        @Override
        public PedestrianLightState getNext() {
            return GREEN_BLINKING_LIGHT;
        }

    },

    GREEN_BLINKING_LIGHT(2, true, "Green Blinking Light"){

        @Override
        public PedestrianLightState getNext() {
            return RED_LIGHT;
        }

    };

    private final int length;
    private final boolean canPass;
    private final String name;

    DutchPedestrianLightBehaviour(int length, boolean canPass, String name) {
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
