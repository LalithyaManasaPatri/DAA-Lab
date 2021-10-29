/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package quicksort;

/**
 *
 * @author 19bcd7013
 */
import java.util.*;
public class QuickSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n=in.nextInt();
        int A[]=new int[n];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++)
        {
            A[i]=in.nextInt();
        }
        int p=0,r=n-1;
        quickSort(A,p,r);
        for(int i=0;i<n;i++)
        {
            System.out.print(A[i]+" ");
        }
    }
    
    static void quickSort(int A[],int p,int r)
    {
        int q=0;
        if(p<r)
        {
           q=partition(A,p,r);
           quickSort(A,p,q-1);
           quickSort(A,q+1,r);
        }
        
    }
    
    static int partition(int A[],int p,int r)
    {
        int x=A[r];
        int i=p-1;
        for(int j=p;j<=r-1;j++)
        {
            if(A[j]>=x)
            {
                i++;
                swap(A,i,j);
            }
        }
        swap(A,i+1,r);
        return i+1;
    }
    
    static void swap(int A[],int i,int j)
    {
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }
}