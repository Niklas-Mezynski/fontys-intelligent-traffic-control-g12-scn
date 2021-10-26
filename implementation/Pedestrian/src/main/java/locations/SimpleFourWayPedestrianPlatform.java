package locations;

import interfaces.FourWayPlatform;
import interfaces.Pedestrian;
import interfaces.Platform;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/** Implementation of FourWayPlatform
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class SimpleFourWayPedestrianPlatform implements FourWayPlatform {
    private final String name;
    private HashMap<String, LinkedList<Pedestrian>> pedestrians;
    private Platform east, west, north, south;
    private final int xCoordinate;
    private final int yCoordinate;

    public SimpleFourWayPedestrianPlatform(String name, int x, int y){
        this.name = name;
        pedestrians = new HashMap<>();
        xCoordinate = x;
        yCoordinate = y;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addPedestrian(Pedestrian p){
        if(p != null){
            if(!this.equals(p.getDestination())){
                if(p.getDestination().getXCoordinate() < xCoordinate){
                    pedestrians.get(west.getName()).add(p);
                }
                else if(p.getDestination().getXCoordinate() > xCoordinate){
                    pedestrians.get(east.getName()).add(p);
                }
                else if(p.getDestination().getYCoordinate() < yCoordinate){
                    pedestrians.get(north.getName()).add(p);
                }
                else if(p.getDestination().getYCoordinate() > yCoordinate){
                    pedestrians.get(south.getName()).add(p);
                }
            }
            else {
                System.out.println(p.getName() + " has arrived at final destination " + name);
            }
        }
    }

    @Override
    public void addPedestrians(List<Pedestrian> p) {
            p.forEach(this::addPedestrian);
    }

    @Override
    public int getXCoordinate() {
        return xCoordinate;
    }

    @Override
    public int getYCoordinate() {
        return yCoordinate;
    }

    /**
     * Used to move a number of pedestrians to the next platform
     *
     * @param number of pedestrians to be moved
     * @param nextName of the next platform
     */
    public void movePedestrians(int number, String nextName){
        Platform nextPlatform = getPlatformByName(nextName);
        var currentPedestrians = pedestrians.get(nextName);

        if(currentPedestrians.isEmpty()){
            System.out.println("No pedestrians waiting at platform " + name + " to go to platform " + nextName);
        }
        else{
            for(int i=0; i<number; i++ ){
                var firstPedestrian = currentPedestrians.pollFirst();
                if(firstPedestrian != null){
                    System.out.println(firstPedestrian.getName() + " is " + firstPedestrian.getAction() + " from " + name + " to " + nextName);
                    if (nextPlatform != null) {
                        nextPlatform.addPedestrian(firstPedestrian);
                    }
                    else System.out.println("Next platform is null for platform " + name);
                }
            }
        }
    }

    /**
     * Gets the next platform by its name
     *
     * @param name of next platform
     * @return next platform
     */
    private Platform getPlatformByName(String name) {
        if(east.getName().equals(name)) return east;
        if(west.getName().equals(name)) return west;
        if(south.getName().equals(name)) return south;
        if(north.getName().equals(name)) return north;
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleFourWayPedestrianPlatform that = (SimpleFourWayPedestrianPlatform) o;
        return name.equals(that.name) && xCoordinate == that.getXCoordinate() && yCoordinate == that.getYCoordinate();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, xCoordinate, yCoordinate);
    }

    @Override
    public void update(boolean isPassAllowed, int length, String nextName) {
        if(isPassAllowed){
            movePedestrians(length, nextName);
        }
    }

    @Override
    public Platform getEastPlatform() {
        return east;
    }

    @Override
    public void setEastPlatform(Platform other) {
        this.east = other;
        pedestrians.put(east.getName(), new LinkedList<>());
    }

    @Override
    public Platform getWestPlatform() {
        return west;
    }

    @Override
    public void setWestPlatform(Platform other) {
        this.west = other;
        pedestrians.put(west.getName(), new LinkedList<>());
    }

    @Override
    public Platform getSouthPlatform() {
        return south;
    }

    @Override
    public void setSouthPlatform(Platform other) {
        this.south = other;
        pedestrians.put(south.getName(), new LinkedList<>());
    }

    @Override
    public Platform getNorthPlatform() {
        return north;
    }

    @Override
    public void setNorthPlatform(Platform other) {
        this.north = other;
        pedestrians.put(north.getName(), new LinkedList<>());
    }
}
