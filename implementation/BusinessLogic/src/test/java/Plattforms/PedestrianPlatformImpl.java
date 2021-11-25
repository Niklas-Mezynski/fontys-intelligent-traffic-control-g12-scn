package Plattforms;

import interfaces.Pedestrian;
import interfaces.PedestrianPlatform;

public class PedestrianPlatformImpl implements PedestrianPlatform {

    public PedestrianPlatformImpl(int x, int y) {
        
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
