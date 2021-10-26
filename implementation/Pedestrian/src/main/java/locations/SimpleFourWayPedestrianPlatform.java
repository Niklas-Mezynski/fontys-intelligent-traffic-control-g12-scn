package locations;

import interfaces.FourWayPedestrianPlatform;
import interfaces.Pedestrian;
import interfaces.PedestrianPlatform;

import java.util.*;

/** Implementation of FourWayPlatform
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class SimpleFourWayPedestrianPlatform extends SimplePedestrianPlatform implements FourWayPedestrianPlatform {
    private HashMap<String, LinkedList<Pedestrian>> pedestrians;
    private PedestrianPlatform east, west, north, south;

    public SimpleFourWayPedestrianPlatform(String name, int x, int y){
        super(name, x, y);
        pedestrians = new HashMap<>();
    }

    @Override
    public void addPedestrian(Pedestrian p){
        if(p != null){
            if(!this.equals(p.getDestination())){
                if(p.getDestination().getXCoordinate() < super.getXCoordinate() && west != null){
                    pedestrians.get(west.getName()).add(p);
                }
                else if(p.getDestination().getXCoordinate() > super.getXCoordinate() && east != null){
                    pedestrians.get(east.getName()).add(p);
                }
                else if(p.getDestination().getYCoordinate() < super.getYCoordinate() && north != null){
                    pedestrians.get(north.getName()).add(p);
                }
                else if(p.getDestination().getYCoordinate() > super.getYCoordinate() && south != null){
                    pedestrians.get(south.getName()).add(p);
                }
            }
            else {
                System.out.println(p.getName() + " has arrived at final destination " + super.getName());
            }
        }
    }

    /**
     * Used to move a number of pedestrians to the next platform
     *
     * @param number of pedestrians to be moved
     * @param nextName of the next platform
     */
    public void movePedestrians(int number, String nextName){
        var optionalPlatform = getPlatformByName(nextName);
        if(optionalPlatform.isPresent()){
            PedestrianPlatform nextPlatform = optionalPlatform.get();
            var currentPedestrians = pedestrians.get(nextName);

            if(currentPedestrians.isEmpty()){
                System.out.println("No pedestrians waiting at platform " + super.getName() + " to go to platform " + nextName);
            }
            else{
                for(int i=0; i<number; i++ ){
                    var firstPedestrian = currentPedestrians.pollFirst();
                    if(firstPedestrian != null){
                        System.out.println(firstPedestrian.getName() + " is " + firstPedestrian.getAction() + " from " + super.getName() + " to " + nextName);
                        nextPlatform.addPedestrian(firstPedestrian);
                    }
                }
            }
        }
        else {
            System.out.println("Destination platform is null or not found");
        }

    }

    /**
     * Gets the next platform by its name
     *
     * @param name of next platform
     * @return next platform
     */
    private Optional<PedestrianPlatform> getPlatformByName(String name) {
        if(name.equals(east.getName())) return Optional.of(east);
        if(name.equals(west.getName())) return Optional.of(west);
        if(name.equals(south.getName())) return Optional.of(south);
        if(name.equals(north.getName())) return Optional.of(north);
        return Optional.empty();
    }

    @Override
    public void update(boolean isPassAllowed, int length, String nextName) {
        if(isPassAllowed){
            movePedestrians(length, nextName);
        }
    }

    @Override
    public PedestrianPlatform getEastPlatform() {
        return east;
    }

    @Override
    public void setEastPlatform(PedestrianPlatform other) {
        this.east = other;
        pedestrians.put(east.getName(), new LinkedList<>());
    }

    @Override
    public PedestrianPlatform getWestPlatform() {
        return west;
    }

    @Override
    public void setWestPlatform(PedestrianPlatform other) {
        this.west = other;
        pedestrians.put(west.getName(), new LinkedList<>());
    }

    @Override
    public PedestrianPlatform getSouthPlatform() {
        return south;
    }

    @Override
    public void setSouthPlatform(PedestrianPlatform other) {
        this.south = other;
        pedestrians.put(south.getName(), new LinkedList<>());
    }

    @Override
    public PedestrianPlatform getNorthPlatform() {
        return north;
    }

    @Override
    public void setNorthPlatform(PedestrianPlatform other) {
        this.north = other;
        pedestrians.put(north.getName(), new LinkedList<>());
    }
}
