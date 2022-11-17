/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package closestpairlinkedlist.result;

import closestpairlinkedlist.SpacePartition2D;
import closestpairlinkedlist.linkedlist.LinkedList;

/**
 * Resulting data from partitioning points
*/
public class SpacePartitionResult extends ExecutionResult {
    public LinkedList<SpacePartition2D> partitions;

    public SpacePartitionResult(LinkedList<SpacePartition2D> partitions, long iterations, long time) {
        super(iterations, time);
        this.partitions = partitions;
    }

    public LinkedList<SpacePartition2D> getPartitions() {
        return this.partitions;
    }
}