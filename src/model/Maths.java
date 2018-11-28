package model;

/**
 *  Math helpers
 */
public class Maths {
    /**
     *  Clamps a value between a minimum and maximum value
     * @param value The value to be clamped
     * @param min The minimum value
     * @param max The maximum value
     * @return Returns the clamped value.
     */
    public static double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(value, max));
    }
}
