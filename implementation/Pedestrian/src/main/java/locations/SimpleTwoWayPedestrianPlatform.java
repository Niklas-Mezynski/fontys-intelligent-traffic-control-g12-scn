package locations;

import interfaces.Pedestrian;
import interfaces.PedestrianPlatform;
import interfaces.TwoWayPedestrianPlatform;

import java.util.*;

/** Implementation of FourWayPlatform
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class SimpleTwoWayPedestrianPlatform extends SimplePedestrianPlatform implements TwoWayPedestrianPlatform {
    private HashMap<String, LinkedList<Pedestrian>> pedestrians;
    private PedestrianPlatform horizontal, vertical;

    public SimpleTwoWayPedestrianPlatform(String name, int x, int y){
        super(name, x, y);
        pedestrians = new HashMap<>();
    }

    @Override
    public void addPedestrian(Pedestrian p){
        if(p != null){
            if(!this.equals(p.getDestination())){
                if(p.getDestination().getXCoordinate() != super.getXCoordinate() && horizontal != null){
                    pedestrians.get(horizontal.getName()).add(p);
                }
                else if(p.getDestination().getYCoordinate() != super.getYCoordinate() && vertical != null){
                    pedestrians.get(vertical.getName()).add(p);
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
        if(name.equals(horizontal.getName())) return Optional.of(horizontal);
        if(name.equals(vertical.getName())) return Optional.of(vertical);
        return Optional.empty();
    }

    @Override
    public void update(boolean isPassAllowed, int length, String nextName) {
        if(isPassAllowed){
            movePedestrians(length, nextName);
        }
    }

    @Override
    public PedestrianPlatform getHorizontalPlatform() {
        return horizontal;
    }

    @Override
    public void setHorizontalPlatform(PedestrianPlatform other) {
        this.horizontal = other;
        pedestrians.put(horizontal.getName(), new LinkedList<>());
    }

    @Override
    public PedestrianPlatform getVerticalPlatform() {
        return vertical;
    }

    @Override
    public void setVerticalPlatform(PedestrianPlatform other) {
        this.vertical = other;
        pedestrians.put(vertical.getName(), new LinkedList<>());
    }
}
