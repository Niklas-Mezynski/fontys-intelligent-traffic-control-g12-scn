module businesslogic_module {
    requires interfaces_module;
    opens trafficLights;
    exports trafficLights;
    exports lightBehaviour;
}