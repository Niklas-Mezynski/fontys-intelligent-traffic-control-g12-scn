package pedestrianLightBehaviours;

import interfaces.PedestrianLightState;

public enum AustralianPedestrianLightBehaviour  implements PedestrianLightState {

    RED_LIGHT(0, false, "Red Light"){

        @Override
        public PedestrianLightState getNext() {
            return GREEN_LIGHT;
        }

    },

    GREEN_LIGHT(2, true, "Green Light"){

        @Override
        public PedestrianLightState getNext() {
            return RED_BLINKING_LIGHT;
        }

    },

    RED_BLINKING_LIGHT(2, true, "Red Blinking Light"){

        @Override
        public PedestrianLightState getNext() {
            return RED_LIGHT;
        }

    };

    private final int length;
    private final boolean canPass;
    private final String name;

    AustralianPedestrianLightBehaviour (int length, boolean canPass, String name) {
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
