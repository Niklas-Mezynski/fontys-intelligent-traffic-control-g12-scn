package Germany;

import interfaces.State;
import interfaces.TrafficLight;

public enum StateEnum implements State {

    RED_LIGHT(0, false, "Red Light"){

        @Override
        public State changeState(TrafficLight light) {
            light.changeState(RED_AND_YELLOW);
            System.out.println("Changing from RED -> red and yellow");
            return RED_AND_YELLOW;
        }

    },
    RED_AND_YELLOW(0, false, "Red and yellow"){

        @Override
        public State changeState(TrafficLight light) {
            light.changeState(GREEN_LIGHT);
            System.out.println("Changing from RED_AND_YELLOW -> green");
            return GREEN_LIGHT;
        }

    },

    YELLOW(1, true, "Yellow"){

        @Override
        public State changeState(TrafficLight light) {
            light.changeState(RED_LIGHT);
            System.out.println("Changing from yellow -> red");
            return RED_LIGHT;
        }

    },

    GREEN_LIGHT(2, true, "Green Light"){

        @Override
        public State changeState(TrafficLight light) {
            light.changeState(YELLOW);
            System.out.println("green -> yellow");
            return YELLOW;
        }

    };

    private int length;
    private boolean canPass;
    private String name;

    StateEnum(int length, boolean canPass, String name) {
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
