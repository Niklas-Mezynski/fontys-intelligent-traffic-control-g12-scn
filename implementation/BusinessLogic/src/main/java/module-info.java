module businesslogic_module {
    requires interfaces_module;
    opens lightBehaviour;
    opens trafficLights;
    exports trafficLights;
    exports lightBehaviour;
}