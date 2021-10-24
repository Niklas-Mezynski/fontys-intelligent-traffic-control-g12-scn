package locations;

import interfaces.Pedestrian;
import interfaces.PairPlatform;
import interfaces.Platform;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/** Implementation of PairPlatform
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class SimplePairPedestrianPlatform implements PairPlatform {
    private final String name;
    private LinkedList<Pedestrian> pedestrians;
    private Platform pairPedestrianPlatform;
    private final int xCoordinate;
    private final int yCoordinate;

    public SimplePairPedestrianPlatform(String name, int x, int y){
        this.name = name;
        pedestrians = new LinkedList<>();
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Platform getPairPlatform() {
        return pairPedestrianPlatform;
    }

    @Override
    public void setPairPlatform(Platform other) {
        this.pairPedestrianPlatform = other;
    }

    @Override
    public void addPedestrian(Pedestrian p){
        if(p != null){
            if(!this.equals(p.getDestination())){
                pedestrians.add(p);
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
    public Pedestrian getFirstInQueue(){
        return pedestrians.pollFirst();
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
     */
    public void movePedestrians(int number){
        if(pedestrians.isEmpty()) {
            System.out.println("No pedestrians waiting at platform " + name + " to go to platform " + pairPedestrianPlatform.getName());
        }
        else{
            for(int i=0; i<number; i++ ){
                var firstPedestrian = getFirstInQueue();
                if(firstPedestrian != null){
                    System.out.println(firstPedestrian.getName() + " is " + firstPedestrian.getAction() + " from " + name + " to " + pairPedestrianPlatform.getName());
                    pairPedestrianPlatform.addPedestrian(firstPedestrian);
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimplePairPedestrianPlatform that = (SimplePairPedestrianPlatform) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pedestrians, pairPedestrianPlatform);
    }

    @Override
    public void update(boolean isPassAllowed, int length, String name) {
        if(isPassAllowed){
            movePedestrians(length);
        }
    }
}
