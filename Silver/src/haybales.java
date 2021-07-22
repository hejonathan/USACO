import java.io.*;
import java.util.*;
public class haybales {
    //static int[] dp = new int[1000000000];
    static int bs(List<Long> h, long t){
        if(t<h.get(0))return -1;
        if(t>h.get(h.size()-1))return h.size()-1;
        int r = h.size()-1;
        int l = 0;
        while(l<r){
            int m = l + (r-l+1)/2;
            if(h.get(m)<=t) l=m;
            else r=m-1;
        }
        return l;
    }
    static int bsl(List<Long> h, long t){
        if(t<h.get(0))return 0;
        if(t>h.get(h.size()-1))return h.size()-1;
        int r = h.size()-1;
        int l = 0;
        while(l<r){
            int m = l + (r-l)/2;
            if(h.get(m)<t) l=m+1;
            else r=m;
        }
        return l-1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("haybales.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
        List<Long> h = new ArrayList<>();
        int n=0,q=0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)h.add(Long.parseLong(st.nextToken()));
        Collections.sort(h);

        for(int i=0;i<q;i++){
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken()), b = Long.parseLong(st.nextToken());
            int right = bs(h,b), left = bs(h,a-1);
            //int right = Collections.binarySearch(h,b);
            //int left = Collections.binarySearch(h,a);
            /*if(right<=-2)right=-right-2;
            else if(right==-1)right=0;
            if(left<=-2)left=-left-2;
            else if(left==-1)left=0;*/
            int ans = right-left;
            //if(h.get(left)==a)ans++;

            //System.out.println(left+" "+right+" "+ans);
            pw.println(ans);
        }
        pw.close();
        br.close();
    }
}/*
import java.io.*;
import java.util.*;
public class haybales {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("haybales.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] list = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pw.println(countLEQ(list, b) - countLEQ(list, a-1));
        }
        pw.close();
    }
    public static int countLEQ(int[] list, int limit) {
        if(list[0] > limit) {
            return 0;
        }
        int min = 0;
        int max = list.length-1;
        // list[min] is guaranteed to be <= limit
        while(min != max) {
            int mid = (min+max+1)/2;
            if(list[mid] <= limit) {
                min = mid;
            }
            else {
                max = mid-1;
            }
        }
        return min + 1;
    }
}*/
