package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Motorcycle;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.ValidationHelpers;

import static java.lang.String.format;

public class MotorcycleImpl extends VehicleBase implements Motorcycle {

    private static final int CATEGORY_LEN_MIN = 3;
    private static final int CATEGORY_LEN_MAX = 10;
    private static final String CATEGORY_LEN_ERR = format(
            "Category must be between %d and %d characters long!",
            CATEGORY_LEN_MIN,
            CATEGORY_LEN_MAX);
    private static final String CATEGORY_MESSAGE = "Category: %s";
    private static final int MOTORCYCLE_WHEELS = 2;
    private static final VehicleType MOTORCYCLE_VEHICLE_TYPE = VehicleType.MOTORCYCLE;
    private String category;

    public MotorcycleImpl(String make, String model, double price, String category) {
        super(make, model, price);
        setCategory(category);
    }

    @Override
    public int getWheels() {
        return MOTORCYCLE_WHEELS;
    }

    @Override
    public VehicleType getType() {
        return MOTORCYCLE_VEHICLE_TYPE;
    }

    @Override
    public String getCategory() {
        return category;
    }

    public String toString() {
        return String.format(super.toString(), String.format(CATEGORY_MESSAGE, getCategory()));

    }

    private void setCategory(String category) {
        ValidationHelpers.validateStringLength(category, CATEGORY_LEN_MIN, CATEGORY_LEN_MAX, CATEGORY_LEN_ERR);
        this.category = category;
    }

}
