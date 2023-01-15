package com.epam.training.ekaterina_sycheva.java_basics.compass;


public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private int degrees;

    public static Direction ofDegrees(int degrees) {
        if (degrees < 0) {
            degrees = 360 + degrees % 360;
        } else if (degrees % 360 == 0) {
            degrees = 0;
        } else {
            degrees = degrees % 360;
        }
        for (Direction val : Direction.values()) {
            if (val.degrees == degrees) return val;
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        if (degrees < 0) {
            degrees = 360 + degrees % 360;
        } else {
            degrees = degrees % 360;
        }
        int difference;
        int min_difference = Math.abs(Direction.values()[0].degrees - degrees);
        Direction direction_result = null;
        for (Direction direction_value : Direction.values()) {
            difference = Math.abs(direction_value.degrees - degrees);
            if (min_difference >= difference) {
                min_difference = difference;
                direction_result = direction_value;
            }
        }
        return direction_result;
    }

    public Direction opposite() {
        for (Direction val : Direction.values()) {
            if (Math.abs(val.degrees - this.degrees) == 180) return val;
        }
        return null;
    }

    public int differenceDegreesTo(Direction direction) {
        if (this.degrees >= direction.degrees)
            return this.degrees - direction.degrees;
        else
            return Math.min(direction.degrees - this.degrees, this.degrees - direction.degrees + 360);
    }
}
