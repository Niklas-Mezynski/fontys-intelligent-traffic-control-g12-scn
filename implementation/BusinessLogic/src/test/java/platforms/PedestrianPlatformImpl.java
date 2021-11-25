package platforms;

import interfaces.Pedestrian;
import interfaces.PedestrianPlatform;

public class PedestrianPlatformImpl implements PedestrianPlatform {

    private final int x;
    private final int y;
    private PedestrianPlatform hPartner;
    private PedestrianPlatform vPartner;

    @Override
    public void addHorizontalPartner(PedestrianPlatform platform) {
        
    }

    @Override
    public void addVerticalPartner(PedestrianPlatform platform) {

    }

    public PedestrianPlatformImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public PedestrianPlatform getHorizontalPartner() {
        return null;
    }

    @Override
    public PedestrianPlatform getVerticalPartner() {
        return null;
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void attachPedestrian(Pedestrian pedestrian) {

    }

    @Override
    public void removePedestrian(Pedestrian pedestrian) {

    }
}
