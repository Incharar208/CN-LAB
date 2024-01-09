import java.util.*;

public class BellManFord {
    private static int N;
    private static int[][] graph;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        N = in.nextInt();
        System.out.println("Enter the adjacency matrix:");
        graph = new int[N][N];
        for(int i =0; i < N; i++ ){
            for(int j = 0; j < N; j++){
                graph[i][j] = in.nextInt();
            }
        }
        System.out.println("Enter the source vertex:");
        int source = in.nextInt();
        bellmanford(source - 1);  // zero based indexing
        in.close();
    }
    public static void bellmanford(int source){
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        for(int i = 0; i < N; i++){
            for(int u = 0; u < N; u++){
                for(int v = 0; v < N; v++){
                    if(graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE && distance[u] + graph[u][v] < distance[v]){
                        distance[v] = distance[u] + graph[u][v];
                    }
                }
            }
        }
        for(int u = 0; u < N; u++){
            for(int v = 0; v < N; v++){
                if(graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE && distance[u] + graph[u][v] < distance[v]){
                    System.out.println("Negative cycle detected.");
                    return;
                }
            }
        }
        printSolution(distance);

    }
    public static void printSolution(int[] distance){
        System.out.println("Vertex\t\tDistance From Source");
        for(int i = 0; i < N; i++){
            System.out.println((i+1)+"\t\t"+distance[i]);
        }
    }
}
