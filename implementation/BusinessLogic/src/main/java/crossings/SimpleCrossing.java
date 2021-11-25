package crossings;

import interfaces.Crossing;
import interfaces.PedestrianTrafficLight;
import interfaces.StreetTrafficLight;
import platforms.PedestrianPlatformImpl;

import java.util.*;

public class SimpleCrossing implements Crossing {
    Timer timer;
    PedestrianTrafficLight horizontalPedestrianTrafficLight;
    PedestrianTrafficLight verticalPedestrianTrafficLight;
    StreetTrafficLight horizontalStreetTrafficLight;
    StreetTrafficLight verticalStreetTrafficLight;
    PedestrianPlatformImpl pp11;
    PedestrianPlatformImpl pp12;
    PedestrianPlatformImpl pp21;
    PedestrianPlatformImpl pp22;

    public SimpleCrossing() {
        createPedestrianPlatforms();
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

    private void createPedestrianPlatforms() {
        pp11 = new PedestrianPlatformImpl(1, 1);
        pp12 = new PedestrianPlatformImpl(1, 2);
        pp21 = new PedestrianPlatformImpl(2, 1);
        pp22 = new PedestrianPlatformImpl(2, 2);

        pp11.addHorizontalPartner(pp21);
        pp11.addVerticalPartner(pp12);

        pp12.addHorizontalPartner(pp22);
        pp12.addVerticalPartner(pp11);

        pp21.addHorizontalPartner(pp11);
        pp21.addVerticalPartner(pp22);

        pp22.addHorizontalPartner(pp12);
        pp22.addVerticalPartner(pp21);
    }
}
