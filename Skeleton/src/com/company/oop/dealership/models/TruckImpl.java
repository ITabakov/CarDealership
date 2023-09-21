package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Truck;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.ValidationHelpers;

import static java.lang.String.format;

public class TruckImpl extends VehicleBase implements Truck {

    private static final int WEIGHT_CAP_MIN = 1;
    private static final int WEIGHT_CAP_MAX = 100;
    private static final String WEIGHT_CAP_ERR = format(
            "Weight capacity must be between %d and %d!",
            WEIGHT_CAP_MIN,
            WEIGHT_CAP_MAX);
    private static final int TRUCK_WHEELS = 8;
    private static final String WEIGHT_CAPACITY_MESSAGE = "Weight Capacity: %dt";
    private static final VehicleType TRUCK_VEHICLE_TYPE = VehicleType.TRUCK;
    private int weightCapacity;


    public TruckImpl(String make, String model, double price, int weightCapacity) {
        super(make, model, price);
        setWeightCapacity(weightCapacity);
    }

    @Override
    public int getWheels() {
        return TRUCK_WHEELS;
    }

    @Override
    public VehicleType getType() {
        return TRUCK_VEHICLE_TYPE;
    }

    @Override
    public int getWeightCapacity() {
        return weightCapacity;
    }

    public String toString() {
        return String.format(super.toString(), String.format(WEIGHT_CAPACITY_MESSAGE, getWeightCapacity()));

    }

    private void setWeightCapacity(int weightCapacity) {
        ValidationHelpers.validateIntRange(weightCapacity, WEIGHT_CAP_MIN, WEIGHT_CAP_MAX, WEIGHT_CAP_ERR);
        this.weightCapacity = weightCapacity;
    }

}
