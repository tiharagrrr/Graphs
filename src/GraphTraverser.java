
import java.util.ArrayList;

public class GraphTraverser {

    public static void depthFirstTraversal(Vertex start, ArrayList<Vertex> visitedVertices){
        System.out.println(start.getData());

        for (Edge e : start.getEdges()){
            Vertex neighbor = e.getEnd();

            if (!visitedVertices.contains(neighbor)){
                visitedVertices.add(neighbor);
                GraphTraverser.depthFirstTraversal(neighbor, visitedVertices);
            }
        }

    }

    public static void breadthFirstTraversal(Vertex start, ArrayList<Vertex> visitedVertices){
        Queue visitQueue = new Queue();
        visitQueue.enqueue(start);
        while (!visitQueue.isEmpty()) {
            Vertex current = visitQueue.dequeue();
            System.out.println(current.getData());
            for (Edge e : current.getEdges()) {
                Vertex neighbour = e.getEnd();
                if (!visitedVertices.contains(neighbour)) {
                    visitedVertices.add(neighbour);
                    visitQueue.enqueue(neighbour);
                }
            }
        }
    }

    public static void main(String[] args) {

        TestGraph test = new TestGraph();
        Vertex startingVertex = test.getStartingVertex();
        ArrayList<Vertex> visitedVertices1 = new ArrayList<Vertex>();
        ArrayList<Vertex> visitedVertices2 = new ArrayList<Vertex>();
        visitedVertices1.add(startingVertex);
        visitedVertices2.add(startingVertex);

        System.out.println( "DFS");
        GraphTraverser.depthFirstTraversal(startingVertex, visitedVertices1);
        System.out.println("BFS");
        GraphTraverser.breadthFirstTraversal(startingVertex, visitedVertices2);


    }
}
