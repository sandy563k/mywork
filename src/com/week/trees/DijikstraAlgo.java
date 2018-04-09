package com.week.trees;

import java.util.*;
import java.util.Map.Entry;

public class DijikstraAlgo {


    static void calculateShortestPathFromSource(DkGraph graph, DKNode source) {
        source.setDistance(0);

        Set<DKNode> settledNodes = new HashSet<>();
        Set<DKNode> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            DKNode currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Entry < DKNode, Integer> adjacencyPair:
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


        for (DKNode node:settledNodes) {
            System.out.print(node.getDistance()+": ");
            node.printShortestPath();
        }

    }

    static DKNode getLowestDistanceNode(Set < DKNode > unsettledNodes) {
        DKNode lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (DKNode node: unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    static void CalculateMinimumDistance(DKNode evaluationNode,
                                         Integer edgeWeigh, DKNode sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<DKNode> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }



    public static void main(String[] args) {
        DKNode nodeA = new DKNode("A");
        DKNode nodeB = new DKNode("B");
        DKNode nodeC = new DKNode("C");
        DKNode nodeD = new DKNode("D");
        DKNode nodeE = new DKNode("E");
        DKNode nodeF = new DKNode("F");

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

    private List<DKNode> shortestPath = new LinkedList<>();

    private Integer distance = Integer.MAX_VALUE;

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

    public void printShortestPath(){
        for(DKNode node: this.shortestPath){
            System.out.print(node.getName()+" -->");
        }
        System.out.println(this.getName());
    }


}

