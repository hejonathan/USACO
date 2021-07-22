import java.io.*;
import java.util.*;
public class p2 {
    // a, b, c, a+b, b+c, a+c, a+b+c
    // 0  1  2,   3,   4,   5,    6
    static long[] numbers;
    static class pair{
        long a,b,c;
        pair(long a,long b,long c){this.a=a;this.b=b;this.c=c;}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            pair pair = (pair) o;
            return a == pair.a &&
                    b == pair.b &&
                    c == pair.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c);
        }
    }
    static HashSet<pair> hs;
    static void works(int[] order){
        long[] value = new long[7];
        long[] check = new long[7];

        for(int i=0;i<numbers.length;i++){
            value[order[i]] = numbers[i];
        }
        for(int i=0;i<value.length;i++) check[i]=value[i];
        HashSet<Long> a;
        HashSet<Long> b;
        HashSet<Long> c;
        do{
            a = new HashSet<>();
            b = new HashSet<>();
            c = new HashSet<>();
            if(value[0]!=0) a.add(value[0]);
            if(value[3]!=0&&value[1]!=0) a.add(value[3]-value[1]);
            if(value[5]!=0&&value[2]!=0) a.add(value[5]-value[2]);
            if(value[6]!=0&&value[4]!=0) a.add(value[6]-value[4]);
            if(a.size()>1) return;
            if(!a.isEmpty()) for (long e : a) {value[0]=e;}

            if(value[1]!=0) b.add(value[1]);
            if(value[3]!=0&&value[0]!=0) b.add(value[3]-value[0]);
            if(value[4]!=0&&value[2]!=0) b.add(value[4]-value[2]);
            if(value[6]!=0&&value[5]!=0) b.add(value[6]-value[5]);
            if(b.size()>1) return;
            if(!b.isEmpty()) for (long e : b) {value[1]=e;}

            if(value[2]!=0) c.add(value[2]);
            if(value[4]!=0&&value[1]!=0) c.add(value[4]-value[1]);
            if(value[5]!=0&&value[0]!=0) c.add(value[5]-value[0]);
            if(value[6]!=0&&value[3]!=0) c.add(value[6]-value[3]);
            if(c.size()>1) return;
            if(!c.isEmpty()) for (long e : c) {value[2]=e;}

        }while(value[0]==0||value[1]==0||value[2]==0);

        if(check[3]!=0 && check[3]!=value[0]+value[1]) return;
        if(check[4]!=0 && check[4]!=value[2]+value[1]) return;
        if(check[5]!=0 && check[5]!=value[2]+value[0]) return;
        if(check[6]!=0 && check[6]!=value[0]+value[1]+value[2]) return;

        if(1<=value[0]&&value[0]<=value[1]&&value[1]<=value[2]&&!hs.contains(new pair(value[0],value[1],value[2]))) {
            //System.out.println(value[0]+" "+value[1]+" "+value[2]);
            hs.add(new pair(value[0],value[1],value[2]));
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
        for(int i=0;i<cases;i++){
            hs = new HashSet<>();
            int n = Integer.parseInt(br.readLine());
            numbers = new long[7];
            Arrays.fill(numbers,0);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) numbers[j] = Long.parseLong(st.nextToken());
            int[] order = new int[]{3,0,1,2,4,6,5};
            //works(order);
            printAllRecursive(7,order);
            System.out.println(hs.size());
        }
    }
    static void swap(int[] input, int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }
    static void printAllRecursive(int n, int[] elements) {//borrowed
        if(n == 1) {
            works(elements);
        } else {
            for(int i = 0; i < n-1; i++) {
                printAllRecursive(n - 1, elements);
                if(n % 2 == 0) {
                    swap(elements, i, n-1);
                } else {
                    swap(elements, 0, n-1);
                }
            }
            printAllRecursive(n - 1, elements);
        }
    }

}
