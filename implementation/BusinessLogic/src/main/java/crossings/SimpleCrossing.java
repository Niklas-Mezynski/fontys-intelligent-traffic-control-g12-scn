package crossings;

import interfaces.*;

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
        System.out.println();
        System.out.println("Starting horizontal traffic: ");
        System.out.println("1. Stop vertical traffic");
        this.verticalPedestrianTrafficLight.stopTraffic();
        this.verticalStreetTrafficLight.stopTraffic();
        System.out.println("--");
        System.out.println("2. Start horizontal traffic");
        this.horizontalPedestrianTrafficLight.startTraffic();
        this.horizontalStreetTrafficLight.startTraffic();
        System.out.println("--");
        System.out.println("Horizontal traffic started!");
        System.out.println();
    }

    @Override
    public void startVerticalTrafficLights() {
        System.out.println();
        System.out.println("Starting vertical traffic: ");
        System.out.println("1. Stop horizontal traffic");
        this.horizontalPedestrianTrafficLight.stopTraffic();
        this.horizontalStreetTrafficLight.stopTraffic();
        System.out.println("--");
        System.out.println("2. Start vertical traffic");
        this.verticalPedestrianTrafficLight.startTraffic();
        this.verticalStreetTrafficLight.startTraffic();
        System.out.println("--");
        System.out.println("Vertical traffic started!");
        System.out.println();
    }

    @Override
    public PedestrianTrafficLight getHorizontalPedestrianLight() {
        return horizontalPedestrianTrafficLight;
    }

    @Override
    public PedestrianTrafficLight getVerticalPedestrianLight() {
        return verticalPedestrianTrafficLight;
    }
}
