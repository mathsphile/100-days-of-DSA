import java.util.Scanner;

class Sort {

    void Insertion(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int j=i;
            while(j>0 && arr[j-1]>arr[j])
            {
            
            
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j ] = temp;
                    j--;
                }
            }
        }
    }



public class InsertionSort {
    public static void main(String[] args) {

        System.out.println("Enter the number of elements in the array");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Sort s = new Sort();
        s.Insertion(arr);
        System.out.println("The sorted array is");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
