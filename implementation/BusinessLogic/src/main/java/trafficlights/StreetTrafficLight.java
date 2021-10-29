package trafficlights;

/**
 * Implementation of StreetTrafficLight
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class StreetTrafficLight extends BaseTrafficLight {

    @Override
    public void printActiveMessage(){
        System.out.println("street light activated");
    }
}
