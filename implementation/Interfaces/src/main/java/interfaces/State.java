package interfaces;

public interface State {

    State getNext();

    default void changeState(TrafficLight light) {
        System.out.println("Changing from " + light.getCurrentState() + " -> " + getNext());
        light.changeState(getNext());
    };

    boolean canPass();

    int length();

    String getName();
}
