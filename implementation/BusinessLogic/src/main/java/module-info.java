module businesslogic_module {
    requires interfaces_module;
    opens lightBehaviours;
    opens trafficLights;
    exports trafficLights;
    exports lightBehaviours;
}