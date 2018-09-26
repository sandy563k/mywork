package com.week.trees;

import java.util.*;
import java.util.Map.Entry;

/*      22: A -->B -->D
        0 : A
        15: A -->C
        23: A -->B -->D -->F
        10: A -->B
        24: A -->B -->D -->E

        */

/*      10: A -->B
        23: A -->B -->D -->F
        0:  A
        22: A -->B -->D
        24: A -->B -->D -->E
        15: A -->C*/

public class DijikstraAlgo {

    /*using minheap(priority queue) to get shortest distance node*/
    static void calculateShortestPathFromSource(DkGraph graph, DKNode source) {
        source.setDistance(0);
        /* to represent nodes already visited and calculated*/
        Set<DKNode> settledNodes = new HashSet<>();
        /*to represent nodes not yet visited */
        MinIntHeap unsettledNodes = new MinIntHeap();

        unsettledNodes.add(source);

        /*loop until all nodes are visited*/
        while (!unsettledNodes.isEmpty()) {
            DKNode currentNode = unsettledNodes.poll();
            for (Entry<DKNode, Integer> adjacencyPair :
                    currentNode.getAdjacentNodes().entrySet()) {
                DKNode adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    CalculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);

        }


        for (DKNode node : settledNodes) {
            System.out.print(node.getDistance() + ": ");
            node.printShortestPath();
        }

    }

/*
    static void calculateShortestPathFromSource(DkGraph graph, DKNode source) {
        source.setDistance(0);
        *//* to represent nodes already visited and calculated*//*
        Set<DKNode> settledNodes = new HashSet<>();
        *//*to represent nodes not yet visited *//*
        Set<DKNode> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        *//*loop until all nodes are visited*//*
        while (unsettledNodes.size() != 0) {
            //picking up a node with min distance from source
            DKNode currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Entry<DKNode, Integer> adjacencyPair :
                    currentNode.getAdjacentNodes().entrySet()) {
                DKNode adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    CalculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);

        }


        for (DKNode node : settledNodes) {
            System.out.print(node.getDistance() + ": ");
            node.printShortestPath();
        }

    }*/

    /*picks out a node with shortest distance from source from a set of nodes*/
    static DKNode getLowestDistanceNode(Set<DKNode> unsettledNodes) {
        DKNode lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (DKNode node : unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }


    /*calculates/updates shortest distance and shortest path for the evaluation node with the help of prevNode*/
    static void CalculateMinimumDistance(DKNode evaluationNode,
                                         Integer edgeWeigh, DKNode prevNode) {
        Integer sourceDistance = prevNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<DKNode> shortestPath = new LinkedList<>(prevNode.getShortestPath());
            shortestPath.add(prevNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }


    public static void main(String[] args) {
        /*creating all the nodes*/
        DKNode nodeA = new DKNode("A");
        DKNode nodeB = new DKNode("B");
        DKNode nodeC = new DKNode("C");
        DKNode nodeD = new DKNode("D");
        DKNode nodeE = new DKNode("E");
        DKNode nodeF = new DKNode("F");

        /*defining adjacent nodes and their distances*/
        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        DkGraph graph = new DkGraph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        calculateShortestPathFromSource(graph, nodeA);
    }

}

class DkGraph {

    private Set<DKNode> nodes = new HashSet<>();

    public void addNode(DKNode nodeA) {
        nodes.add(nodeA);
    }

}

class DKNode {

    private String name;
    /*shortestPath contains list of all nodes in the path from source to this node in order*/
    private List<DKNode> shortestPath = new LinkedList<>();

    /*shortest distance from source to this node*/
    private Integer distance = Integer.MAX_VALUE;

    /*adjacent nodes to this node and their distance in hashmap*/
    private Map<DKNode, Integer> adjacentNodes = new HashMap<>();

    public void addDestination(DKNode destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    public DKNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DKNode> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<DKNode> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Map<DKNode, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<DKNode, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    /*prints shortest path from source node to this node*/
    public void printShortestPath() {
        for (DKNode node : this.shortestPath) {
            System.out.print(node.getName() + " -->");
        }
        System.out.println(this.getName());
    }
}

