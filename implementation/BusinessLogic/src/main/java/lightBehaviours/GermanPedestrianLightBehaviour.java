package lightBehaviours;

import interfaces.State;

/**
 * Light behaviour for german pedestrian traffic lights
 *
 */
public enum GermanPedestrianLightBehaviour implements State {

    RED_LIGHT(0, false, "Red Light"){

        @Override
        public State getNext() {
            return GREEN_LIGHT;
        }

    },

    GREEN_LIGHT(2, true, "Green Light"){

        @Override
        public State getNext() {
            return RED_LIGHT;
        }

    };

    private final int length;
    private final boolean canPass;
    private final String name;

    GermanPedestrianLightBehaviour(int length, boolean canPass, String name) {
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
