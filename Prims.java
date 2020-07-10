import java.util.*;

class Prims {
	void prims(int adj[][], int n) {
		int amt_min = 0, min, i, j, u = 0, v = 0, cnt = 0;
		int visited[] = new int[n];
		for(i = 0; i<n ; i++)
		{
			visited[i] = 0;
		}
		visited[0] = 1;
		min = 999;
		cnt = 1;
		while(cnt<n)
		{
			for(i = 0 ; i<n ; i++)
			{
				for( j = 0; j<n ; j++)
				{
					if((visited[i]==1) && (visited[j]==0) && (adj[i][j]<min))
					{
						u = i;
						v = j;
						min = adj[i][j];
					}
				}
			}
			visited[v] = 1;
			adj[u][v] = adj[v][u] = 999;
			amt_min += min;
			System.out.printf("\nThe %d is connected to %d and weight is : %d", u, v, min);
			min = 999;
			cnt = cnt + 1;
		}
		System.out.printf("\nThe cost is : %d\n", amt_min);
	}	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n, i, j;
		Lab9 obj = new Lab9();
		System.out.printf("\nEnter the Number of Vertices : ");
		n = sc.nextInt();
		int adj[][] = new int[n][n];
		for( i=0 ; i<n ; i++)
		{
			for( j=0 ; j<=i ; j++)
			{
				System.out.printf("\nAre %d and %d connected ? Enter weight if connected or 999 : ", i, j);
				adj[i][j] = adj[j][i] = sc.nextInt();
			}
		}
		obj.prims(adj, n);
	}
}
