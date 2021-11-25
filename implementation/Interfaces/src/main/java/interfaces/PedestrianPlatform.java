package interfaces;

public interface PedestrianPlatform {

    public void addHorizontalPartner(PedestrianPlatform platform);

    public void addVerticalPartner(PedestrianPlatform platform);

    public PedestrianPlatform getHorizontalPartner();

    public PedestrianPlatform getVerticalPartner();

    public int getX();

    public int getY();

    public void attachPedestrian(Pedestrian pedestrian);

    public void removePedestrian(Pedestrian pedestrian);

}
