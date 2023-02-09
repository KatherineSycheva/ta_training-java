package com.epam.training.ekaterina_sycheva.java_basics.figures_extra_challenge;

/**
 * Abstract class may be extended by different figures types
 * Ensure figures are not degenerative.
 * All of them must have non-zero area.
 * Quadrilateral is also must be convex.
 * If a figure is not good, throw an IllegalArgumentException.
 * Note: A non-degenerative convex quadrilateral is divided into four non-degenerative triangles by its diagonals.
 * Note: double calculations are not completely accurate, use error delta, where applies.
 */
abstract class Figure{


    /**
     * Returns the centroid of the figure.
     * Centroid refers to center of mass of the plain figure, not the baricenter.
     * @return a point of centroid
     */
    public abstract Point centroid();

    /**
     * Returns whether two figures are considered to be the same.
     * The figures are the same if they have the same type
     * and if they coincide (e.g. have same vertices).
     * @param figure triangle, circle or quadriliteral object
     * @return true if the figures are the same and otherwise false
     */
    public abstract boolean isTheSame(Figure figure);
}
