package crossings;

import interfaces.Crossing;
import interfaces.PedestrianTrafficLight;
import interfaces.StreetTrafficLight;

import java.util.*;

public class SimpleCrossing implements Crossing {
    Timer timer;
    PedestrianTrafficLight horizontalPedestrianTrafficLight;
    PedestrianTrafficLight verticalPedestrianTrafficLight;
    StreetTrafficLight horizontalStreetTrafficLight;
    StreetTrafficLight verticalStreetTrafficLight;

    public SimpleCrossing() {
        resetTimer();
    }

    @Override
    public void addPedestrianTrafficLightPair(PedestrianTrafficLight horizontal, PedestrianTrafficLight vertical) {
        this.horizontalPedestrianTrafficLight = horizontal;
        this.verticalPedestrianTrafficLight = vertical;
    }

    @Override
    public void addStreetTrafficLightPair(StreetTrafficLight horizontal, StreetTrafficLight vertical) {
        this.horizontalStreetTrafficLight = horizontal;
        this.verticalStreetTrafficLight = vertical;
    }

    @Override
    public void removePedestrianTrafficLightPair() {
        this.horizontalPedestrianTrafficLight = null;
        this.verticalPedestrianTrafficLight = null;
    }

    @Override
    public void removeStreetTrafficLightPair() {
        this.horizontalStreetTrafficLight = null;
        this.verticalStreetTrafficLight = null;
    }

    @Override
    public void activate(int length) {
        resetTimer();
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

    private void resetTimer(){
        timer = new Timer();
    }

    @Override
    public void startHorizontalTrafficLights() {
        System.out.println("start horizontal: ");
        this.verticalPedestrianTrafficLight.stopTraffic();
        this.verticalStreetTrafficLight.stopTraffic();
        System.out.println("--");
        this.horizontalPedestrianTrafficLight.startTraffic();
        this.horizontalStreetTrafficLight.startTraffic();
    }

    @Override
    public void startVerticalTrafficLights() {
        System.out.println("start Vertical: ");
        this.horizontalPedestrianTrafficLight.stopTraffic();
        this.horizontalStreetTrafficLight.stopTraffic();
        System.out.println("!!");
        this.verticalPedestrianTrafficLight.startTraffic();
        this.verticalStreetTrafficLight.startTraffic();
    }
}
