/*
Write a program to find the shortest path between vertices using
bellman-ford algorithm.
*/
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
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j< N; j++)
            {
                graph[i][j] = in.nextInt();
            }
        }
        System.out.println("Enter the source vertex:");
        int source = in.nextInt();
        bellmanford(source - 1);
        in.close();
    }

    public static void bellmanford(int source) {
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        for(int i = 0; i < N; i++)
        {
            for(int u = 0; u < N; u++)
            {
                for(int v = 0; v < N; v++)
                {
                    if(graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE && graph[u][v] + distance[u] < distance[v])
                    {
                        distance[v] = graph[u][v] + distance[u];
                    }
                }
            }
        }

        for(int i = 0; i < N; i++)
        {
            for(int u = 0; u < N; u++)
            {
                for(int v = 0; v < N; v++)
                {
                    if(graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE && graph[u][v] + distance[u] < distance[v])
                    {
                        System.out.println("Negative weight cycle detected");
                        return;
                    }
                }
            }
        }
        printSolution(distance);
    }
    public static void printSolution(int[] distance) {
        System.out.println("VERTEX\tDISTANCE FROM SOURCE");
        for(int i = 0; i < N; i++)
        {
            System.out.println((i+1)+"\t\t"+distance[i]);
        }
    }
}

//OUTPUT:
/*
Enter the number of vertices:
3
Enter the adjacency matrix:
0 10 0
0 0 20
0 -30 0
Enter the source vertex:
1
Negative weight cycle detected



Enter the number of vertices:
5
Enter the adjacency matrix:
0 6 0 7 0
0 0 5 8 -4
0 0 0 0 0
0 0 -3 0 9
2 0 0 0 0
Enter the source vertex:
1
VERTEX  DISTANCE FROM SOURCE
1               0
2               6
3               4
4               7
5               2
*/
