package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Car;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.ValidationHelpers;

import java.util.List;

import static java.lang.String.format;

public class CarImpl extends VehicleBase implements Car{

    private static final int CAR_SEATS_MIN = 1;
    private static final int CAR_SEATS_MAX = 10;
    private static final String CAR_SEATS_ERR = format(
            "Seats must be between %d and %d!",
            CAR_SEATS_MIN,
            CAR_SEATS_MAX);
    private static final int CAR_WHEELS = 4;
    private static final String SEATS_MESSAGE = "Seats: %d";
    private static final VehicleType CAR_VEHICLE_TYPE = VehicleType.CAR;
    private int seats;

    public CarImpl(String make, String model, double price, int seats) {
        super(make, model, price);
        setSeats(seats);
    }

    @Override
    public VehicleType getType() {
        return CAR_VEHICLE_TYPE;
    }

    @Override
    public int getWheels() {
        return CAR_WHEELS;
    }

    @Override
    public int getSeats() {
        return seats;
    }

    public String toString() {
        return String.format(super.toString(), String.format(SEATS_MESSAGE, getSeats()));

    }

    private void setSeats(int seats) {
        ValidationHelpers.validateIntRange(seats, CAR_SEATS_MIN, CAR_SEATS_MAX, CAR_SEATS_ERR);
        this.seats = seats;
    }

}
