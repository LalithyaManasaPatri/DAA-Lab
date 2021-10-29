import java.util.*;
public class MergeSort {

    /**
     * @param args the command line arguments
     */
    static void Merge_Sort(int A[],int p,int r)
    {
        if(p<r)
        {
            int q=(p+r)/2;
            Merge_Sort(A,p,q);
            Merge_Sort(A,q+1,r);
            Merge(A,p,q,r);
        }
    }
   
    static int[] Merge(int A[],int p,int q,int r)
    {
        int n1=q-p+1;
        int n2=r-q;
        int L1[]=new int[n1+1]; // In order to store the sentinel, I have created an array of size n1+1. Changed by Dr. Vikash Kumar Singh
        int L2[]=new int[n2+1]; // In order to store the sentinel, I have created an array of size n2+1. Changed by Dr. Vikash Kumar Singh
        for(int i=0;i<n1;i++)
        {
            L1[i]=A[p+i];
        }
        for(int j=0;j<n2;j++)
        {
            L2[j]=A[q+j+1];
        }
        int i=0,j=0;
       // int k=p;
       L1[n1] = Integer.MAX_VALUE; // Changed by Dr. Vikash Kumar Singh
       L2[n2] = Integer.MAX_VALUE; // Changed by Dr. Vikash Kumar Singh

// Explanation: At the last indices of both the lists i.e. L1 and L2 we have the value, say, 2147483647. Now, we keep on comparing starting from first index of both the list and once the pointer reach to the last index of any one of the lists then this largest value will be compared with the smaller value in other list. Once we are at the last index of both the list, by that time the for loop in line 38 gets terminated. Hence, it works fine.
     
        for(int k = p; k<=r; k++)
        {
           
            if(L1[i]<L2[j])
            {
                A[k]=L1[i];
                i++;
            }
            else{
                A[k]=L2[j];
                j++;
            }
        }
               
        return A;
    }
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
        int p=0,r=A.length-1;
        Merge_Sort(A,p,r);
        for(int i=0;i<n;i++)
        {
            System.out.print(A[i]+" ");
        }
    }
   
}
