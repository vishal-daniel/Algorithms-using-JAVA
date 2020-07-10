import java.util.*;

class Knapsack{
	float[][] g;
	float[] x;

	public Lab6b(int n){
		g = new float[4][n];
		x = new float[n];
		for(int i = 0; i<n ; i++)
			x[i] = 0;
	}
	
	void sort(int n){
		float tmp1, tmp2, tmp3 , tmp4;
		for(int i = 0; i<n ; i++)
		{
			for(int j = 0; j<n-i-1 ; j++)
			{
				if(g[2][j]<g[2][j+1])
				{
					tmp1 = g[2][j]; //profit/weight
					tmp2 = g[1][j]; //weight
					tmp3 = g[0][j]; //profit
					tmp4 = g[3][j];
					g[2][j] = g[2][j+1];
					g[1][j] = g[1][j+1];
					g[0][j] = g[0][j+1];
					g[3][j] = g[3][j+1];
					g[2][j+1] = tmp1;
					g[1][j+1] = tmp2;
					g[0][j+1] = tmp3;
					g[3][j+1] = tmp4;
				}
			}
		}
	}

	void knapsack(int n, int m){
		float u = (float)m;
		int i;
		for(i = 0 ; i<n ; i++)
		{
			if(g[1][i] > u) break;
			else
			{
				x[i] = 1;
				u = u-g[1][i];
			}
		}
		if(i<n)
			x[i] = (u/g[1][i]);
	}

	void inp(int n)
	{
		Scanner s = new Scanner(System.in);
		for(int j = 0; j<n ; j++)
		{
			System.out.printf("\nEnter the %d Profit : ", j+1);
			g[0][j] = s.nextFloat();
			System.out.printf("\nEnter the %d Weight : ", j+1);
			g[1][j] = s.nextFloat();
			g[3][j] = j+1;
			g[2][j] = g[0][j]/g[1][j];
		}
	}

	void disp(int n)
	{
		System.out.printf("\nThe bag contains : \n");
		for(int i = 0; i<n ; i++)
		{
			System.out.println("Item " + (int)g[3][i] + " : " + x[i]);
		}
	}

	public static void main(String[] args){
		int n, m;
		Scanner s = new Scanner(System.in);
		System.out.printf("\nEnter the Number of items : ");
		n = s.nextInt();
		System.out.printf("\nEnter the Capacity : ");
		m = s.nextInt();
		Lab6b obj = new Lab6b(n);
		obj.inp(n);
		obj.sort(n);
		obj.knapsack(n, m);
		obj.disp(n);
	}
} 
