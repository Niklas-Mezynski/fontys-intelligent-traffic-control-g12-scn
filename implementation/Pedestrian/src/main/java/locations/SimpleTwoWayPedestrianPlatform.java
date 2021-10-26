package locations;

import interfaces.Pedestrian;
import interfaces.Platform;
import interfaces.TwoWayPlatform;

import java.util.*;

/** Implementation of FourWayPlatform
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class SimpleTwoWayPedestrianPlatform implements TwoWayPlatform {
    private final String name;
    private HashMap<String, LinkedList<Pedestrian>> pedestrians;
    private Platform horizontal, vertical;
    private final int xCoordinate;
    private final int yCoordinate;

    public SimpleTwoWayPedestrianPlatform(String name, int x, int y){
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
                if(p.getDestination().getXCoordinate() != xCoordinate && horizontal != null){
                    pedestrians.get(horizontal.getName()).add(p);
                }
                else if(p.getDestination().getYCoordinate() != yCoordinate && vertical != null){
                    pedestrians.get(vertical.getName()).add(p);
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
        var optionalPlatform = getPlatformByName(nextName);
        if(optionalPlatform.isPresent()){
            Platform nextPlatform = optionalPlatform.get();
            var currentPedestrians = pedestrians.get(nextName);

            if(currentPedestrians.isEmpty()){
                System.out.println("No pedestrians waiting at platform " + name + " to go to platform " + nextName);
            }
            else{
                for(int i=0; i<number; i++ ){
                    var firstPedestrian = currentPedestrians.pollFirst();
                    if(firstPedestrian != null){
                        System.out.println(firstPedestrian.getName() + " is " + firstPedestrian.getAction() + " from " + name + " to " + nextName);
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
    private Optional<Platform> getPlatformByName(String name) {
        if(name.equals(horizontal.getName())) return Optional.of(horizontal);
        if(name.equals(vertical.getName())) return Optional.of(vertical);
        return Optional.empty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleTwoWayPedestrianPlatform that = (SimpleTwoWayPedestrianPlatform) o;
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
    public Platform getHorizontalPlatform() {
        return horizontal;
    }

    @Override
    public void setHorizontalPlatform(Platform other) {
        this.horizontal = other;
        pedestrians.put(horizontal.getName(), new LinkedList<>());
    }

    @Override
    public Platform getVerticalPlatform() {
        return vertical;
    }

    @Override
    public void setVerticalPlatform(Platform other) {
        this.vertical = other;
        pedestrians.put(vertical.getName(), new LinkedList<>());
    }
}
