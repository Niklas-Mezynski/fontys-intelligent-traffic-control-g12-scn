package crossings;

import interfaces.Crossing;
import interfaces.PedestrianTrafficLight;

import java.util.Timer;
import java.util.TimerTask;

public class SimpleCrossing implements Crossing {
    PedestrianTrafficLight vertical;
    PedestrianTrafficLight horizontal;
    Timer timer;

    public SimpleCrossing() {
        timer = new Timer();
    }

    @Override
    public void addPedestrianTrafficLightPair(PedestrianTrafficLight horizontal, PedestrianTrafficLight vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    @Override
    public void removePedestrianTrafficLightPair() {
       this.vertical = null;
       this.horizontal = null;
    }

    @Override
    public void activate(int length) {
        timer.schedule(new TimerTask() {

                        @Override
                        public void run() {
                            startPedestrianHorizontalTraffic();
                        }
                }, 0, length);

        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                startPedestrianVerticalTraffic();
            }
        }, length/2, length);

    }

    @Override
    public void deactivate() {
        timer.cancel();
    }

    @Override
    public void startPedestrianHorizontalTraffic() {
        System.out.println("vertical stopping ");
        vertical.stopTraffic();
        System.out.println("horizontal starting ");
        horizontal.startTraffic();
        System.out.println();
    }

    @Override
    public void startPedestrianVerticalTraffic() {
        System.out.println("horizontal stopping");
        horizontal.stopTraffic();
        System.out.println("vertical starting");
        vertical.startTraffic();
        System.out.println();
    }
}
