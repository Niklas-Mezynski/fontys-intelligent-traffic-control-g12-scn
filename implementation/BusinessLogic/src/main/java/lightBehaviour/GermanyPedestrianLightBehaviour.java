package lightBehaviour;

import interfaces.State;

public enum GermanyPedestrianLightBehaviour implements State {

    RED_LIGHT(0, false, "Red Light"){

        @Override
        public State getNext() {
            return GREEN_LIGHT;
        }

    },
   /* RED_AND_YELLOW(0, false, "Red and yellow"){

        @Override
        public State getNext() {
            return GREEN_LIGHT;
        }

    },

    YELLOW(1, true, "Yellow"){

        @Override
        public State getNext() {
            return RED_LIGHT;
        }

    },*/

    GREEN_LIGHT(2, true, "Green Light"){

        @Override
        public State getNext() {
            return RED_LIGHT;
        }

    };

    private int length;
    private boolean canPass;
    private String name;

    GermanyPedestrianLightBehaviour(int length, boolean canPass, String name) {
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
