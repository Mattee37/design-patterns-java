package com.mattee37.patterns.creational.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class VehicleFactoryTest {

    @Test
    void createsCar() {
        Vehicle car = VehicleFactory.createVehicle(VehicleFactory.Type.CAR);
        assertInstanceOf(Car.class, car);
        assertEquals("Car", car.type());
        assertEquals(4, car.wheels());
    }

    @Test
    void createsMotorcycle() {
        Vehicle motorcycle = VehicleFactory.createVehicle(VehicleFactory.Type.MOTORCYCLE);
        assertInstanceOf(Motorcycle.class, motorcycle);
        assertEquals("Motorcycle", motorcycle.type());
        assertEquals(2, motorcycle.wheels());
    }

    @Test
    void createsTruck() {
        Vehicle truck = VehicleFactory.createVehicle(VehicleFactory.Type.TRUCK);
        assertInstanceOf(Truck.class, truck);
        assertEquals("Truck", truck.type());
        assertEquals(6, truck.wheels());
    }

    @Test
    void createsNewInstancesEachCall() {
        Vehicle a = VehicleFactory.createVehicle(VehicleFactory.Type.CAR);
        Vehicle b = VehicleFactory.createVehicle(VehicleFactory.Type.CAR);
        assertNotSame(a, b);
    }
}
