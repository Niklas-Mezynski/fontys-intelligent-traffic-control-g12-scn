package platforms;

import interfaces.LightState;
import interfaces.Pedestrian;
import interfaces.PedestrianPlatform;

import java.util.PriorityQueue;
import java.util.Queue;

public class PedestrianPlatformImpl implements PedestrianPlatform {

    private final int x;
    private final int y;
    private PedestrianPlatform hPartner;
    private PedestrianPlatform vPartner;
    private PriorityQueue<Pedestrian> pedestrians = new PriorityQueue<>();

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
        pedestrians.add(pedestrian);
    }
}
