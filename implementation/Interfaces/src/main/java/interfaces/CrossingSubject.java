package interfaces;

public interface CrossingSubject extends Crossing {
    void addCrossingObservers(CrossingObserver... observer);
    void removeCrossingObserver(CrossingObserver observer);
    void updateObservers();
}
