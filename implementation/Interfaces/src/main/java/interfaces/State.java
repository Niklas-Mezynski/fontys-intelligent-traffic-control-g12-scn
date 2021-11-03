package interfaces;

public interface State {

    State changeState(TrafficLight light);

    boolean canPass();

    int length();

    String getName();
}
