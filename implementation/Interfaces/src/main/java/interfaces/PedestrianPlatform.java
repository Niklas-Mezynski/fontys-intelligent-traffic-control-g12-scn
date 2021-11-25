package interfaces;

public interface PedestrianPlatform {

    public PedestrianPlatform getHorizontalPartner();

    public PedestrianPlatform getVerticalPartner();

    public int getX();

    public int getY();

    public void attachPedestrian(Pedestrian pedestrian);

    public void removePedestrian(Pedestrian pedestrian);

}
