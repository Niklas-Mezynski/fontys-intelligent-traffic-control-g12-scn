package crossings;


import interfaces.StreetTrafficLight;

/**
 * Extends SimpleCrossing, change handling of the start- and stopmethods.
 */
public class AdvancedCrossing extends SimpleCrossing {

    StreetTrafficLight horizontalTrafficLightStraight;
    StreetTrafficLight horizontalTrafficLightLeft;
    StreetTrafficLight horizontalTrafficLightRight;

    StreetTrafficLight verticalTrafficLightStraight;
    StreetTrafficLight verticalTrafficLightLeft;
    StreetTrafficLight verticalTrafficLightRight;


    /** Default straight pair **/
    @Override
    public void addStreetTrafficLightPair(StreetTrafficLight horizontal, StreetTrafficLight vertical) {
        super.addStreetTrafficLightPair(horizontalTrafficLightStraight, verticalTrafficLightStraight);
    }

    /** Left turn pair **/
    public void addStreetTrafficLightLeftPair(StreetTrafficLight horizontal, StreetTrafficLight vertical){
        this.horizontalTrafficLightLeft = horizontal;
        this.verticalTrafficLightLeft = vertical;
    }
    /** Right turn pair **/
    public void addStreetTrafficLightRightPair(StreetTrafficLight horizontal, StreetTrafficLight vertical){
        this.horizontalTrafficLightRight = horizontal;
        this.verticalTrafficLightRight = vertical;
    }

    @Override
    public void startHorizontalTrafficLights() {

        // Stop all vertical
        this.verticalTrafficLightLeft.stopTraffic();
        this.verticalTrafficLightRight.stopTraffic();
        this.verticalTrafficLightStraight.stopTraffic();

        // Start horizontal Pedestrian
        this.horizontalPedestrianTrafficLight.startTraffic();

        // Start horizontal straight
        this.horizontalTrafficLightStraight.startTraffic();

        // Stop pedestrian horizontal
        this.horizontalPedestrianTrafficLight.stopTraffic();

        // Start horizontal right turn light
        this.horizontalTrafficLightRight.startTraffic();

        // Stop everything else for left turn
        this.horizontalTrafficLightRight.stopTraffic();
        this.horizontalTrafficLightStraight.stopTraffic();

        // Start horizontal left turn
        this.horizontalTrafficLightLeft.startTraffic();

//        System.out.println();
//        System.out.println("Starting horizontal traffic: ");
//        System.out.println("1. Stop vertical traffic");
//        this.verticalPedestrianTrafficLight.stopTraffic();
//        this.verticalStreetTrafficLight.stopTraffic();
//        System.out.println("--");
//        System.out.println("2. Start horizontal traffic");
//        this.horizontalPedestrianTrafficLight.startTraffic();
//        this.horizontalStreetTrafficLight.startTraffic();
//        System.out.println("--");
//        System.out.println("Horizontal traffic started!");
//        System.out.println();
    }

    @Override
    public void startVerticalTrafficLights() {

        // Stop all horizontal
        this.horizontalPedestrianTrafficLight.stopTraffic();
        this.horizontalTrafficLightLeft.stopTraffic();
        this.horizontalTrafficLightRight.stopTraffic();

        // Start Vertical pedestrian
        this.verticalPedestrianTrafficLight.startTraffic();

        // Start vertical straight
        this.verticalTrafficLightStraight.startTraffic();

        // Stop vertical Pedestrian
        this.verticalPedestrianTrafficLight.stopTraffic();

        // Start right
        this.verticalTrafficLightRight.startTraffic();

        // Stop everything for left turn
        this.verticalTrafficLightStraight.stopTraffic();
        this.verticalTrafficLightRight.stopTraffic();

        // Start left turn
        this.verticalTrafficLightLeft.startTraffic();



//        System.out.println();
//        System.out.println("Starting vertical traffic: ");
//        System.out.println("1. Stop horizontal traffic");
//        this.horizontalPedestrianTrafficLight.stopTraffic();
//        this.horizontalStreetTrafficLight.stopTraffic();
//        System.out.println("--");
//        System.out.println("2. Start vertical traffic");
//        this.verticalPedestrianTrafficLight.startTraffic();
//        this.verticalStreetTrafficLight.startTraffic();
//        System.out.println("--");
//        System.out.println("Vertical traffic started!");
//        System.out.println();
    }

}
