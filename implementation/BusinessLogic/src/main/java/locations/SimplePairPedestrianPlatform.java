package locations;

import interfaces.PairPedestrianPlatform;
import interfaces.Pedestrian;
import interfaces.PedestrianPlatform;

import java.util.LinkedList;

/** Implementation of PairPedestrianPlatform
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class SimplePairPedestrianPlatform extends SimplePedestrianPlatform implements PairPedestrianPlatform {
    private final LinkedList<Pedestrian> pedestrians;
    private PedestrianPlatform pairPedestrianPlatform;

    public SimplePairPedestrianPlatform(String name, int x, int y){
        super(name, x, y);
        pedestrians = new LinkedList<>();
    }

    @Override
    public PedestrianPlatform getPairPlatform() {
        return pairPedestrianPlatform;
    }

    @Override
    public void setPairPlatform(PedestrianPlatform other) {
        this.pairPedestrianPlatform = other;
    }

    @Override
    public void addPedestrian(Pedestrian p){
        if(p != null){
            if(!this.equals(p.getDestination())){
                pedestrians.add(p);
            }
            else {
                System.out.println(p.getName() + " has arrived at final destination " + super.getName());
            }
        }
    }

    @Override
    public Pedestrian getFirstInQueue(){
        return pedestrians.pollFirst();
    }

    /**
     * Used to move a number of pedestrians to the next platform
     *
     * @param number of pedestrians to be moved
     */
    public void movePedestrians(int number){
        if(pedestrians.isEmpty()) {
            System.out.println("No pedestrians waiting at platform " + super.getName() + " to go to platform " + pairPedestrianPlatform.getName());
        }
        else{
            for(int i=0; i<number; i++ ){
                var firstPedestrian = getFirstInQueue();
                if(firstPedestrian != null){
                    System.out.println(firstPedestrian.getName() + " is " + firstPedestrian.getAction() + " from " + super.getName() + " to " + pairPedestrianPlatform.getName());
                    pairPedestrianPlatform.addPedestrian(firstPedestrian);
                }
            }
        }
    }

    @Override
    public void update(boolean isPassAllowed, int length, String name) {
        if(isPassAllowed){
            movePedestrians(length);
        }
    }
}
