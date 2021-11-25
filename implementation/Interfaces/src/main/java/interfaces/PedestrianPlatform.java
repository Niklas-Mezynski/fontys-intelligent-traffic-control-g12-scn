package interfaces;

public interface PedestrianPlatform extends Platform{

    public void addHorizontalPartner(PedestrianPlatform platform);

    public void addVerticalPartner(PedestrianPlatform platform);

    public PedestrianPlatform getHorizontalPartner();

    public PedestrianPlatform getVerticalPartner();

    public void attachPedestrian(Pedestrian pedestrian);

}
