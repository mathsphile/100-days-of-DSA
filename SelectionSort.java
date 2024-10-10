import java.util.Scanner;

class Sort
{
    void Selection(int arr[], int n)
    {
        int i,j,min;
        for(i=0;i<n-2;i++)
      {
        min=i;
        for(j=i;j<n-1;j++)
        {
            if(arr[j]<arr[min])
            {
                int temp=arr[j];
                arr[j]=arr[min];
                arr[min]=temp;
            
            }
        }
      }
    }
}
public class SelectionSort
{
    public static void main(String[] args) {
        System.out.println("Enter the number of elements in the array");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        Sort s=new Sort();
        s.Selection(arr,n);
        System.out.println("The sorted array is");
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }
}