module businesslogic_module {
    requires interfaces_module;
    opens trafficLights;
    opens lightBehaviour;
    exports trafficLights;
    exports lightBehaviour;
}