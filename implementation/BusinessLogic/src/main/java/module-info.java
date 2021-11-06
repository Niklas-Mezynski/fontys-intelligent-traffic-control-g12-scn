module businesslogic_module {
    requires interfaces_module;
    opens lightBehaviours;
    opens trafficLights;
    opens shapes;
    exports trafficLights;
    exports lightBehaviours;
    exports shapes;
}