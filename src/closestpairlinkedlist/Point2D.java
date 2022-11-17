/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package closestpairlinkedlist;

import closestpairlinkedlist.linkedlist.LinkedList;
import java.util.Objects;
import java.util.Random;

/**
 * A point in a 2D space
*/
public class Point2D implements Comparable<Point2D> {
    // Random number generator for generating random points
    private static Random rng;

    private final int x;
    private final int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /*
     * Finds the euclidean distance between this point and other point.
    */
    public long distanceTo(Point2D point) {
        long dx = (long) point.x - this.x;
        long dy = (long) point.y - this.y;

        return dx*dx + dy*dy;
    }

    /*
     * Commpares 2 points
    */
    @Override
    public int compareTo(Point2D other) {
        if (this.equals(other))
            return 0;
        
        return this.getX() < other.getX() || (this.getX() == other.getX() && this.getY() < other.getY()) ? -1 : 1;
    }
    
    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    /*
     * Now two points are equal if their x value and y values are equal
    */
    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;

        if (other == null || this.getClass() != other.getClass())
            return false;

        Point2D oth = (Point2D) other;

        return this.x == oth.x && this.y == oth.y;
    }

    /*
     * Hashes point based on x and y
    */
    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

    /*
     * Generates a random point with coordinates smaller than the given values
    */
    public static Point2D randomPoint(int x, int y) {
        rng = new Random();
        return new Point2D(rng.nextInt(2 * x) - x, rng.nextInt(2 * y) - y);
    }
}
