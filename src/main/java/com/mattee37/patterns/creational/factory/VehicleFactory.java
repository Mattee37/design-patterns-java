package com.mattee37.patterns.creational.factory;

public final class VehicleFactory {
    public enum Type { CAR, MOTORCYCLE, TRUCK }

    private VehicleFactory() {
    }

    public static Vehicle createVehicle(Type type) {
        return switch (type) {
            case CAR -> new Car();
            case MOTORCYCLE -> new Motorcycle();
            case TRUCK -> new Truck();
        };
    }
}
