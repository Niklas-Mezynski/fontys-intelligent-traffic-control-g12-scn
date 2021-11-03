package lightBehaviour;

import interfaces.State;

/**
 * Light behaviour for dutch pedestrian traffic lights
 *
 */
public enum DutchPedestrianLightBehaviour implements State {

    RED_LIGHT(0, false, "Red Light"){

        @Override
        public State getNext() {
            return GREEN_LIGHT;
        }

    },

    GREEN_LIGHT(2, true, "Green Light"){

        @Override
        public State getNext() {
            return GREEN_BLINKING_LIGHT;
        }

    },

    GREEN_BLINKING_LIGHT(2, true, "Green Light"){

        @Override
        public State getNext() {
            return RED_LIGHT;
        }

    };

    private int length;
    private boolean canPass;
    private String name;

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
