import java.util.ArrayList;
import java.util.Scanner;

public class recursion {
    static void subsequece(int i,int arr[],ArrayList<Integer> al,int cs,int s){
       
        if(i==arr.length){
            if(s==cs){
              System.out.println(al);  
            }
            return;
        }
        al.add(arr[i]);
        subsequece(i+1, arr, al,cs+arr[i],s); // taking the element
        al.remove(al.size() - 1);
        subsequece(i+1, arr, al,cs,s);//not taking the element
    }
    public static void main(String[] args) {
        int arr[]=new int[4];
        Scanner sc= new Scanner(System.in);
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        
        ArrayList<Integer> al = new ArrayList<>();
        subsequece(0,arr,al,0,2);
    }
}
