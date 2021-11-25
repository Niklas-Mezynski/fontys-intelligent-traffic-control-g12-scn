package platforms;

import interfaces.*;

import java.util.PriorityQueue;
import java.util.Queue;

public class PedestrianPlatformImpl implements PedestrianPlatform, CrossingObserver {

    private final int x;
    private final int y;
    private PedestrianPlatform hPartner;
    private PedestrianPlatform vPartner;
    private final PriorityQueue<Pedestrian> pedestriansVertical = new PriorityQueue<>();
    private final PriorityQueue<Pedestrian> pedestriansHorizontal = new PriorityQueue<>();

    @Override
    public void addHorizontalPartner(PedestrianPlatform platform) {
        hPartner = platform;
    }

    @Override
    public void addVerticalPartner(PedestrianPlatform platform) {
        vPartner = platform;
    }

    public PedestrianPlatformImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public PedestrianPlatform getHorizontalPartner() {
        return hPartner;
    }

    @Override
    public PedestrianPlatform getVerticalPartner() {
        return vPartner;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void attachPedestrian(Pedestrian pedestrian) {
        if (pedestrian.getDestination().equals(getHorizontalPartner())) {
            pedestriansHorizontal.add(pedestrian);
        } else if (pedestrian.getDestination().equals(getVerticalPartner())) {
            pedestriansVertical.add(pedestrian);
        }
        //TODO add an alternative for the case that the destination isn't a neighboring platform
    }

    @Override
    public void update(Crossing subject) {
        if (subject.getHorizontalPedestrianLight().getCurrentState().stateMeaning().equals(LightState.LightStateMeaning.PASS)) {
            if (!pedestriansHorizontal.isEmpty()) {
                Pedestrian pedestrian = pedestriansHorizontal.poll();
                pedestrian.crossStreet();
            }
        } else if (subject.getVerticalPedestrianLight().getCurrentState().stateMeaning().equals(LightState.LightStateMeaning.PASS)) {
            if (!pedestriansVertical.isEmpty()) {
                Pedestrian pedestrian = pedestriansVertical.poll();
                pedestrian.crossStreet();
            }
        }
    }
}
