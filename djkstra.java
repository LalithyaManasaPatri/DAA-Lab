import java.util.*;
class Djkstra {
    static int nodes;
    int minDistance(int path_array[], Boolean sptSet[]) {
// Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < nodes; v++)
            if (sptSet[v] == false && path_array[v] <= min) {
                min = path_array[v];
                min_index = v;
            }
        return min_index;
    }
    // print the array of distances (path_array)
    void Min_Path(int path_array[]) {
        System.out.println("Vertex \t Minimum Distance from Source");
        for (int i = 0; i < nodes; i++)
            System.out.println(i + " \t\t\t " + path_array[i]);
    }
    // Implementation of Dijkstra's algorithm for graph (adjacency matrix)
    void dijkstra_algo(int graph[][], int source) {
        int path_array[] = new int[nodes];
        Boolean sptSet[] = new Boolean[nodes];
        for (int i = 0; i < nodes; i++) {
            path_array[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        path_array[source] = 0;
        for (int count = 0; count < nodes - 1; count++) {
            int u = minDistance(path_array, sptSet);
            sptSet[u] = true;
            for (int v = 0; v < nodes; v++)
                if (!sptSet[v] && graph[u][v] != 0 && path_array[u] !=
                        Integer.MAX_VALUE && path_array[u]
                        + graph[u][v] < path_array[v])
                    path_array[v] = path_array[u] + graph[u][v];
        }
// print the path array
        Min_Path(path_array);
    }
}
public class Main{
    public static void main(String[] args)
    {
        Djkstra d = new Djkstra();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter no.of nodes :");
        d.nodes = scan.nextInt();
        System.out.println("Enter the adjacency matrix :");
        int graph[][] = new int[d.nodes][d.nodes];
        for(int i=0;i<d.nodes;i++){
            for(int j=0;j<d.nodes;j++){
                graph[i][j]=scan.nextInt();
            }
        }
        System.out.println("Enter the source vertex :");
        int source = scan.nextInt();
        d.dijkstra_algo(graph, source);
    }
}
