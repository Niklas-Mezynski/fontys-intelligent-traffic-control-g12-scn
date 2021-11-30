package crossings;

import interfaces.Crossing;
import interfaces.PedestrianTrafficLight;
import interfaces.StreetTrafficLight;
import interfaces.TrafficLight;

import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

public abstract class CrossingBase implements Crossing {
    Timer timer;
    PedestrianTrafficLight horizontalPedestrianTrafficLight;
    PedestrianTrafficLight verticalPedestrianTrafficLight;

    StreetTrafficLight horizontalStreetTrafficLightStraight;
    StreetTrafficLight verticalStreetTrafficLightStraight;

    Optional<StreetTrafficLight> horizontalStreetTrafficLightLeft;
    Optional<StreetTrafficLight> verticalStreetTrafficLightLeft;

    Optional<StreetTrafficLight> horizontalStreetTrafficLightRight;
    Optional<StreetTrafficLight> verticalStreetTrafficLightRight;

    public CrossingBase(PedestrianTrafficLight horizontalPedestrianTrafficLight, PedestrianTrafficLight verticalPedestrianTrafficLight, StreetTrafficLight horizontalStraight, StreetTrafficLight verticalStraight) {
        resetTimer();
        this.verticalPedestrianTrafficLight = verticalPedestrianTrafficLight;
        this.horizontalPedestrianTrafficLight = horizontalPedestrianTrafficLight;
        this.horizontalStreetTrafficLightStraight = horizontalStraight;
        this.verticalStreetTrafficLightStraight = verticalStraight;
        this.horizontalStreetTrafficLightLeft = Optional.empty();
        this.verticalStreetTrafficLightLeft = Optional.empty();
        this.horizontalStreetTrafficLightRight = Optional.empty();
        this.verticalStreetTrafficLightRight = Optional.empty();
    }

    @Override
    public void addHorizontalLeft(StreetTrafficLight light){
        this.horizontalStreetTrafficLightLeft = Optional.of(light);
    }

    @Override
    public void addHorizontalRight(StreetTrafficLight light){
        this.horizontalStreetTrafficLightRight = Optional.of(light);
    }

    @Override
    public void addVerticalLeft(StreetTrafficLight light){
        this.verticalStreetTrafficLightLeft = Optional.of(light);
    }

    @Override
    public void addVerticalRight(StreetTrafficLight light){
        this.verticalStreetTrafficLightRight = Optional.of(light);
    }

    @Override
    public void stopAllVertical(){
        this.verticalStreetTrafficLightStraight.stopTraffic();
        this.verticalStreetTrafficLightLeft.ifPresent(TrafficLight::stopTraffic);
        this.verticalStreetTrafficLightRight.ifPresent(TrafficLight::stopTraffic);
        this.verticalPedestrianTrafficLight.stopTraffic();
    }

    @Override
    public void stopAllHorizontal(){
        this.horizontalStreetTrafficLightStraight.stopTraffic();
        this.horizontalStreetTrafficLightLeft.ifPresent(TrafficLight::stopTraffic);
        this.horizontalStreetTrafficLightRight.ifPresent(TrafficLight::stopTraffic);
        this.horizontalPedestrianTrafficLight.stopTraffic();
    }

    @Override
    public void startHorizontalStraight(){
        this.verticalPedestrianTrafficLight.stopTraffic();
        this.horizontalPedestrianTrafficLight.startTraffic();
        this.horizontalStreetTrafficLightStraight.startTraffic();
    }

    @Override
    public void startVerticalStraight(){
        this.horizontalPedestrianTrafficLight.stopTraffic();
        this.verticalPedestrianTrafficLight.startTraffic();
        this.verticalStreetTrafficLightStraight.startTraffic();
    }

    @Override
    public void startHorizontalRight(){
        if(this.horizontalStreetTrafficLightRight.isPresent()){
            this.horizontalPedestrianTrafficLight.stopTraffic();
            this.verticalPedestrianTrafficLight.stopTraffic();
            this.horizontalStreetTrafficLightRight.get().startTraffic();
        }
    }

    @Override
    public void startHorizontalLeft(){
        if(this.horizontalStreetTrafficLightLeft.isPresent()){
            this.horizontalPedestrianTrafficLight.stopTraffic();
            this.verticalPedestrianTrafficLight.stopTraffic();
            this.horizontalStreetTrafficLightLeft.get().startTraffic();
        }
    }

    @Override
    public void startVerticalRight(){
        if(this.verticalStreetTrafficLightRight.isPresent()){
            this.horizontalPedestrianTrafficLight.stopTraffic();
            this.verticalPedestrianTrafficLight.stopTraffic();
            this.verticalStreetTrafficLightRight.get().startTraffic();
        }
    }

    @Override
    public void startVerticalLeft(){
        if(this.verticalStreetTrafficLightLeft.isPresent()){
            this.horizontalPedestrianTrafficLight.stopTraffic();
            this.verticalPedestrianTrafficLight.stopTraffic();
            this.verticalStreetTrafficLightLeft.get().startTraffic();
        }
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
    public abstract void startHorizontalTrafficLights();

    @Override
    public abstract void startVerticalTrafficLights();
}
