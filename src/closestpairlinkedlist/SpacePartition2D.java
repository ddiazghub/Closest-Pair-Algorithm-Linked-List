/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package closestpairlinkedlist;

import closestpairlinkedlist.linkedlist.LinkedList;
import closestpairlinkedlist.linkedlist.LinkedListNode;
import closestpairlinkedlist.result.ClosestPairResult;
import closestpairlinkedlist.result.SpacePartitionResult;

/**
 * A partition of points in a 2D space, having up to 3 points
*/
public class SpacePartition2D implements Comparable<Object> {
    private final LinkedList<Point2D> points;

    // Partition bounds in the x axis
    public final int minX;
    public final int maxX;

    public SpacePartition2D(LinkedList<Point2D> points) {
        this.points = points;
        this.minX = points.first().getX();
        this.maxX = points.last().getX();
    }

    /**
     * Finds the closest pair of points in the partition using brute force
    */
    public ClosestPairResult closestPair() {
        Point2D point1 = null;
        Point2D point2 = null;

        // Starts counting iterations, and elapsed time
        long iterations = 0;
        long startTime = System.nanoTime();
        long minimunDistance = Long.MAX_VALUE;
        int end = this.points.size();

        // Compares each point to all other points and finds the distance
        LinkedListNode<Point2D> first = this.points.getHead();
        
        while (first.hasNext()) {
            LinkedListNode<Point2D> second = first.getNext();
            
            while (second != null) {
                iterations++;
                long distance = first.getData().distanceTo(second.getData());

                // If the distance is smaller than the minimun distance it becomes the new closest pair
                if (distance < minimunDistance) {
                    point1 = first.getData();
                    point2 = second.getData();
                    minimunDistance = distance;
                }
                
                second = second.getNext();
            }
            
            first = first.getNext();
        }

        return new ClosestPairResult(point1, point2, minimunDistance, iterations, System.nanoTime() - startTime);
    }

    public LinkedList<Point2D> getPoints() {
        return points;
    }

    @Override
    public int compareTo(Object o) {
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Space Partition[");

        for (Point2D point : this.points) {
            string.append(point).append(", ");
        }
        
        string.setLength(string.length() - 2);
        string.append("]");

        return string.toString();
    }

    /**
     * Partitions a list of points into a list of space partitions
    */
    public static SpacePartitionResult partition(LinkedList<Point2D> points) {
        long start = System.nanoTime();
        SpacePartitionResult result = subPartition(points);

        return new SpacePartitionResult(result.getPartitions(), result.getIterations(), System.nanoTime() - start);
    }

    /**
     * Partitions a sublist of points into a list of space partitions
    */
    private static SpacePartitionResult subPartition(LinkedList<Point2D> points) {
        // If the number of points in the sublist is 3 or smaller, creates a new partition
        if (points.size() < 4) {
            LinkedList<SpacePartition2D> list = new LinkedList<>();
            list.add(new SpacePartition2D(points));

            return new SpacePartitionResult(list, 1, 0);
        }

        // Splits the sublist in half and partitions both halves
        LinkedList<Point2D> half = points.split();
        SpacePartitionResult result1 = subPartition(points);
        SpacePartitionResult result2 = subPartition(half);
        result1.getPartitions().append(result2.getPartitions());

        return new SpacePartitionResult(result1.getPartitions(), 1 + result1.getIterations() + result2.getIterations(), 0);
    }
}