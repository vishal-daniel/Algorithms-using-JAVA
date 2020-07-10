import java.util.*;

class Dijkstra {
	void path(int i, int[] parent) {
		if(parent[i] == -1)
			return;
		else
		{
			path(parent[i], parent);
			System.out.printf(" --> %d", i);
		}
	}
	void dijkstra(int g[][], int n, int source) {
		int i, j, k, w=0, min;
		int[] visited, parent, distance;
		visited = new int[n];
		parent = new int[n];
		distance = new int[n];
		for(i = 0; i<n; i++)
		{
			visited[i] = 0;
			parent[i] = -1;
			distance[i] = 999;
		}
		visited[source] = 1;
		parent[source] = -1;
		distance[source] = 0;
		for(i = 0; i<n; i++)
		{
			if((g[source][i]!=999) && (g[source][i]!=0))
			{
				distance[i] = g[source][i];
				parent[i] = source;
			}
		}
		for(i = 1; i<n; i++)
		{
			min = 999;
			for(j = 0; j<n; j++)
			{
				if((visited[j]==0) && (distance[j]<min))
				{
					min = distance[j];
					w = j;
				}
			}
			visited[w] = 1;
			for(k = 0; k<n; k++)
			{
				if((visited[k]==0) && (g[w][k]!=999) && (g[w][k]!=0))
				{
					if(distance[k] > (distance[w] + g[w][k]))
					{
						distance[k] = distance[w] + g[w][k];
						parent[k] = w;
					}
				}
			}
		}
		for(i = 0; i<n ;i++)
		{
			System.out.printf("\nDistance of %d from %d is : %d",i,source,distance[i]);
			System.out.printf("\nPath taken is : %d", source);
			path(i, parent);
		}
	}
	public static void main(String[] args) {
		Lab7 obj = new Lab7();
		Scanner sc = new Scanner(System.in);
		System.out.printf("\nEnter the number of Vertices : ");
		int n = sc.nextInt();
		int[][] g = new int[n][n];
		System.out.printf("\nEnter the Source : ");
		int source = sc.nextInt();
		for(int i = 0; i<n; i++)
		{
			for(int j = 0; j<n; j++)
			{
				if(i==j)
					g[i][j] = 0;
				else
				{
					System.out.printf("\nIf %d is connected to %d, enter the weight else enter 999 : ", i, j);
					g[i][j] = sc.nextInt();
				}
			}
		}
		obj.dijkstra(g,n,source);	
	}
}
