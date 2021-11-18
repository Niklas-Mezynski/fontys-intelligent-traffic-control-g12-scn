module businesslogic_module {
    requires interfaces_module;
    opens streetLightBehaviours;
    opens pedestrianLightBehaviours;
    opens trafficLights;
    opens shapes;
    opens crossings;
    exports trafficLights;
    exports streetLightBehaviours;
    exports pedestrianLightBehaviours;
    exports shapes;
    exports crossings;
    exports factories;
}