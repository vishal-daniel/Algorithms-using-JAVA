import java.util.Scanner;
import java.util.Random;
import java.io.*;
import java.util.*;

class MergeSort{
	public void simpleMerge(int[] a,int[] b,int[]c,int p,int q)
	{
		int i=0,j=0,k=0;
		while(i<p && j<q)
		{
			if(b[i]<c[j])
			{
				a[k]=b[i];
				i=i+1;
			}
			else
			{
				a[k]=c[j];
				j=j+1;
			}
			k=k+1;
		}
		while(i<p)
		{
			a[k]=b[i];
			k=k+1;
			i=i+1;
		}
		while(j<q)
		{
			a[k]=c[j];
			k=k+1;
			j=j+1;
		}
	}	
	public void mergeSort(int[] a)
	{
		int i,j=0,mid;
		mid=a.length/2;
		if(a.length>1)
		{
			int[] b=new int[mid];
                	int[] c=new int[a.length-mid];
			for(i=0;i<mid;i++)
			{
				b[i]=a[i];
			}
			for(i=mid,j=0;i<a.length;i++,j++)
			{
				c[j]=a[i];
			}
			mergeSort(b);
			mergeSort(c);
			simpleMerge(a,b,c,b.length,c.length);
		}
	}
	
};
public class lab5{
	public static void main(String[] args) throws IOException
	{
		int i,j,k=0,l;
		double start,end,elapse;
		MergeSort obj=new MergeSort();
		Random r=new Random();
		FileWriter fw = new FileWriter("plot.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		for(i=5000;i<=1000000;i=i+500)
		{
			int[] a=new int[i];
			k=0;
			for(j=0;j<i;j++)
			{
				a[k]=r.nextInt()+1;
				k=k+1;
			}
			System.out.printf("\n\n");
			/*for(l=0;l<k;l++)
			{
				System.out.printf("%d\t",a[l]);
			}*/
			start=System.currentTimeMillis();
			obj.mergeSort(a);
			end=System.currentTimeMillis();
			elapse=end-start;
			bw.write(i + "\t" + elapse*0.001 + "\n");
			System.out.println("\n"+"The time taken to sort "+i+" is: "+elapse*0.001);
			/*for(l=0;l<k;l++)
			{
				System.out.printf("%d\t",a[l]);
			}*/
		}
		bw.close();
		fw.close();
	}
};
			
