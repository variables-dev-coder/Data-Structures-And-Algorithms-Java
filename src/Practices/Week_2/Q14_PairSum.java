package Practices.Week_2;

public class Q14_PairSum {
    public static boolean pair(int[] a,int k){
        int l=0,r=a.length-1;
        while(l<r){
            int sum=a[l]+a[r];
            if(sum==k) return true;
            else if(sum<k) l++;
            else r--;
        }
        return false;
    }

    public static void main(String[] args){
        int[] a={1,2,3,4,5};
        System.out.println(pair(a,9));  // true
    }
}
