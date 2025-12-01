package Practices.Week_2;

public class Q11_Rotate {
    static void rev(int[] a,int l,int r){
        while(l<r){
            int t=a[l]; a[l]=a[r]; a[r]=t;
            l++; r--;
        }
    }

    static void rotate(int[] a,int k){
        k %= a.length;
        rev(a,0,a.length-1);
        rev(a,0,k-1);
        rev(a,k,a.length-1);
    }

    public static void main(String[] args){
        int[] a={1,2,3,4,5,6,7};
        rotate(a,3);
        for(int x:a) System.out.print(x+" ");
    }
}

// 5 6 7 1 2 3 4