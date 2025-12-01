package Practices.Week_2;

public class Q10_FirstLast {
    static int first(int[] a, int t) {
        int ans=-1,l=0,r=a.length-1;
        while(l<=r){
            int m=(l+r)/2;
            if(a[m]==t){ ans=m; r=m-1; }
            else if(a[m]<t) l=m+1;
            else r=m-1;
        }
        return ans;
    }
    static int last(int[] a, int t) {
        int ans=-1,l=0,r=a.length-1;
        while(l<=r){
            int m=(l+r)/2;
            if(a[m]==t){ ans=m; l=m+1; }
            else if(a[m]<t) l=m+1;
            else r=m-1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a={5,7,7,8,8,10};
        System.out.println(first(a,8));
        System.out.println(last(a,8));
    }
}

//3
//4