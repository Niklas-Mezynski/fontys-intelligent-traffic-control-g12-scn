package crossings;

import interfaces.Crossing;
import interfaces.PedestrianTrafficLight;
import interfaces.StreetTrafficLight;
import interfaces.TrafficLight;

import java.util.*;

public class SimpleCrossing implements Crossing {
    Timer timer;
    List<TrafficLight> verticalTrafficlightList = new ArrayList<>();
    List<TrafficLight> horizontalTrafficlightList = new ArrayList<>();

    public SimpleCrossing() {
        timer = new Timer();
    }

    @Override
    public void addPedestrianTrafficLightPair(PedestrianTrafficLight horizontal, PedestrianTrafficLight vertical) {
        this.verticalTrafficlightList.add(vertical);
        this.horizontalTrafficlightList.add(horizontal);
    }

    @Override
    public void addStreetTrafficLightPair(StreetTrafficLight horizontal, StreetTrafficLight vertical) {
        this.verticalTrafficlightList.add(vertical);
        this.horizontalTrafficlightList.add(horizontal);
    }

    @Override
    public void removePedestrianTrafficLightPair(PedestrianTrafficLight horizontal, PedestrianTrafficLight vertical) {
        try {
            this.verticalTrafficlightList.remove(vertical);
            this.horizontalTrafficlightList.remove(horizontal);
        }catch (Exception e){
            throw new NoSuchElementException("Could not find light: " + e.getMessage());
        }
    }

    @Override
    public void removeStreetTrafficLightPair(StreetTrafficLight horizontal, StreetTrafficLight vertical) {
        try {
            this.verticalTrafficlightList.remove(vertical);
            this.horizontalTrafficlightList.remove(horizontal);
        }catch (Exception e){
            throw new NoSuchElementException("Could not find light: " + e.getMessage());
        }
    }

    @Override
    public void activate(int length) {
        timer.schedule(new TimerTask() {

                        @Override
                        public void run() {
                            startHorizontalTrafficLights();
                        }
                }, 0, length);

        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                startVerticalTrafficLights();
            }
        }, length/2, length);

    }

    @Override
    public void deactivate() {
        timer.cancel();
    }

    @Override
    public void startHorizontalTrafficLights() {
        System.out.println("start horizontal: ");
        this.verticalTrafficlightList.forEach(TrafficLight::stopTraffic);
        System.out.println("--");
        this.horizontalTrafficlightList.forEach(TrafficLight::startTraffic);
    }

    @Override
    public void startVerticalTrafficLights() {
        System.out.println("start Vertical: ");
        this.horizontalTrafficlightList.forEach(TrafficLight::stopTraffic);
        System.out.println("!!");
        this.verticalTrafficlightList.forEach(TrafficLight::startTraffic);
    }


}
