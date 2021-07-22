import java.io.*;
import java.util.*;

public class stacking {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("stacking.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("stacking.out")));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()),k=Integer.parseInt(st.nextToken());
        IntTree t=new IntTree(1,n);
        for(int i=0;i<k;i++){
            st=new StringTokenizer(br.readLine());
            t.change(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),1);
        }
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=t.query(i+1,i+1);
        }
        Arrays.sort(a);
        pw.println(a[n/2]);
        System.out.println(a[n/2]);
        pw.close();
        br.close();
    }
    static class IntTree {
        public int low, high;//range
        public int delta, value;// aggregate
        public IntTree left, right;
        public IntTree(int low, int high) {
            this.low = low;
            this.high = high;
            delta = 0;
            value = 0;
            if (low == high) {
                left = null;
                right = null;
            } else {
                int mid = low + (high-low)/2;
                left = new IntTree(low, mid);
                right = new IntTree(mid + 1, high);
            }
        }
        public void prop() {// push down delta
            if (left != null) {
                left.delta += delta;
                right.delta += delta;
            } else {
                value += delta;
            }
            delta = 0;
        }
        public void update() {
            if (left != null) value = Math.max(left.value + left.delta, right.value + right.delta);
        }
        public void change(int start, int end, int extra) {// store in interval tree by adding extra
            if (high < start || end < low) return;
            prop();// Push down delta.
            if (start <= low && high <= end) {
                delta += extra;
                update();
                return;
            }
            left.change(start, end, extra);
            right.change(start, end, extra);
            update();
        }
        public int query(int start, int end) {
            if (high < start || end < low) return 0;
            if (start <= low && high <= end)
                return value + delta;
            prop();
            int leftSide = left.query(start, end);
            int rightSide = right.query(start, end);
            update();
            return Math.max(leftSide, rightSide);
        }

        public static void main(String[] args) {
            IntTree it=new IntTree(0,10);
            it.change(2,2,-3);
            it.change(3,3,-1);
            System.out.println(it.query(1,3));
        }
    }

}
