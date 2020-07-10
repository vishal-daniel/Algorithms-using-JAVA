import java.util.Scanner;
import java.util.Random;
import java.io.*;
import java.util.*;

class QuickSort{
	public int partition(int[] a,int l,int r)
	{
		int i=l,j=r+1,p=a[l],tmp;
		do
		{
			do
			{
				i=i+1;
			}while((i<r) && (a[i]<p));
			do
			{
				j=j-1;
			}while((j>l) && (a[j]>p));
			if(i<j)
			{
				tmp = a[i];
				a[i]=a[j];
				a[j]=tmp;
			}
		}while(i<j);
		tmp = a[j];
		a[j] = p;
		a[l] = tmp;
		return j;
	}
	public void quickSort(int[] a,int l,int r)
	{	
		int s;
		if(l<r)
		{
			s = partition(a,l,r);
			quickSort(a,l,s-1);
			quickSort(a,s+1,r);
		}
	}
	
};
public class lab4{
	public static void main(String[] args) throws IOException
	{
		int i,j,k=0,l;
		double start,end,elapse;
		QuickSort obj=new QuickSort();
		Random r=new Random();
		FileWriter fw = new FileWriter("QuichSort.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		for(i=5000;i<=1000000;i=i+500)
		{
			int[] a=new int[i];
			k=0;
			for(j=0;j<i;j++)
			{
				a[k]=r.nextInt(i)+1;
				k=k+1;
			}
			System.out.printf("\n\n");
			/*for(l=0;l<k;l++)
			{
				System.out.printf("%d\t",a[l]);
			}*/
			start=System.currentTimeMillis();
			obj.quickSort(a,0,a.length-1);
			end=System.currentTimeMillis();
			elapse=end-start;
			bw.write(i + "\t" + elapse*0.001 + "\n");
			System.out.println("\n"+"The time taken to sort "+i+" is: "+elapse*0.001);
			/*System.out.printf("\n");
			for(l=0;l<k;l++)
			{
				System.out.printf("%d\t",a[l]);
			}*/
		}
		bw.close();
		fw.close();
	}
};
			
