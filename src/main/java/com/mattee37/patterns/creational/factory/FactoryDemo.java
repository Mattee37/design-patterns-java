package com.mattee37.patterns.creational.factory;

public class FactoryDemo {
    public static void main(String[] args) {
        System.out.println("=== Factory Pattern ===\n");

        Vehicle car = VehicleFactory.createVehicle(VehicleFactory.Type.CAR);
        Vehicle motorcycle = VehicleFactory.createVehicle(VehicleFactory.Type.MOTORCYCLE);
        Vehicle truck = VehicleFactory.createVehicle(VehicleFactory.Type.TRUCK);

        car.drive();
        motorcycle.drive();
        truck.drive();

        System.out.println("\nCar has " + car.wheels() + " wheels");
        System.out.println("Motorcycle has " + motorcycle.wheels() + " wheels");
        System.out.println("Truck has " + truck.wheels() + " wheels");
    }
}
