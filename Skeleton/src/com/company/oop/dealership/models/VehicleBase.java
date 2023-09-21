package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.models.contracts.Vehicle;
import com.company.oop.dealership.utils.FormattingHelpers;
import com.company.oop.dealership.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public abstract class VehicleBase implements Vehicle {

    private static final int MAKE_NAME_LEN_MIN = 2;
    private static final int MAKE_NAME_LEN_MAX = 15;
    private static final String MAKE_NAME_LEN_ERR = format(
            "Make must be between %s and %s characters long!",
            MAKE_NAME_LEN_MIN,
            MAKE_NAME_LEN_MAX);
    private static final int MODEL_NAME_LEN_MIN = 1;
    private static final int MODEL_NAME_LEN_MAX = 15;
    private static final String MODEL_NAME_LEN_ERR = format(
            "Model must be between %s and %s characters long!",
            MODEL_NAME_LEN_MIN,
            MODEL_NAME_LEN_MAX);
    private static final double PRICE_VAL_MIN = 0;
    private static final double PRICE_VAL_MAX = 1000000;
    private static final String PRICE_VAL_ERR = format(
            "Price must be between %.1f and %.1f!",
            PRICE_VAL_MIN,
            PRICE_VAL_MAX);
    private static final String NO_COMMENTS_HEADER = "--NO COMMENTS--";
    private static final String COMMENTS_HEADER = "--COMMENTS--";
    private static final String COMMENTS_FOOTER = "--COMMENTS--";
    private static final String VEHICLE_MESSAGE = "%s:";
    private static final String MAKE_MESSAGE = "Make: %s";
    private static final String MODEL_MESSAGE = "Model: %s";
    private static final String WHEELS_MESSAGE = "Wheels: %d";
    private static final String PRICE_MESSAGE = "Price: $%s";
    private static final String ADDITIONAL_ATTRIBUTE_MESSAGE = "%%s";
    private static final String COMMENTS_LIST_MESSAGE = "%s";
    private String make;
    private String model;
    private double price;
    private final List<Comment> comments;

    protected VehicleBase(String make, String model, double price) {
        setMake(make);
        setModel(model);
        setPrice(price);
        comments = new ArrayList<>();
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public void removeComment(Comment comment) {
        if (comments.contains(comment)) {
            comments.remove(comment);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String toString() {
        String typeOfVehicle = getClass().getInterfaces()[0].getSimpleName();

        return String.format(VEHICLE_MESSAGE + System.lineSeparator() +
                        MAKE_MESSAGE + System.lineSeparator() +
                        MODEL_MESSAGE + System.lineSeparator() +
                        WHEELS_MESSAGE + System.lineSeparator() +
                        PRICE_MESSAGE + System.lineSeparator() +
                        ADDITIONAL_ATTRIBUTE_MESSAGE + System.lineSeparator() +
                        COMMENTS_LIST_MESSAGE,
                typeOfVehicle, getMake(), getModel(), getWheels(),
                FormattingHelpers.removeTrailingZerosFromDouble(getPrice()), listComments());
    }

    private String listComments() {
        StringBuilder vehicleComments = new StringBuilder();
        if (comments.size() == 0) {
            vehicleComments.append(NO_COMMENTS_HEADER);
        } else {
            vehicleComments.append(COMMENTS_HEADER).append(System.lineSeparator());
            for (Comment comment : comments) {
                vehicleComments.append(comment.toString());
            }
            vehicleComments.append(COMMENTS_FOOTER);
        }
        return vehicleComments.toString();
    }

    private void setMake(String make) {
        ValidationHelpers.validateStringLength(make, MAKE_NAME_LEN_MIN, MAKE_NAME_LEN_MAX, MAKE_NAME_LEN_ERR);
        this.make = make;
    }

    private void setModel(String model) {
        ValidationHelpers.validateStringLength(model, MODEL_NAME_LEN_MIN, MODEL_NAME_LEN_MAX, MODEL_NAME_LEN_ERR);
        this.model = model;
    }

    private void setPrice(double price) {
        ValidationHelpers.validateDecimalRange(price, PRICE_VAL_MIN, PRICE_VAL_MAX, PRICE_VAL_ERR);
        this.price = price;
    }

}
