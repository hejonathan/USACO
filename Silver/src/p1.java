import java.io.*;
import java.util.*;
public class p1 {
    static class thing{
        char type;// w = wall, b = bessie, k = key
        int x;
        thing(char c, int x){
            this.type=c;
            this.x=x;
        }
        thing(char c){
            this.type=c;
            x=-1;
        }
    }
    static thing[][] grid;
    static int n;
    static int bx,by;
    static int[] adj = new int[20];
    static int[][] winning = {
            {11, 2, 3},
            {1, 2, 13},
            {14, 5, 6},
            {4, 5, 16},
            {17, 8, 9},
            {7, 8, 19},
            {1, 4, 17},
            {11, 4, 7},
            {12, 5, 8},
            {2, 5, 18},
            {13, 6, 9},
            {3, 6, 19},
            {1, 5, 19},
            {11, 5, 9}
    };
    static HashSet<Integer> path = new HashSet<>();
    static boolean isWin(int a){
        boolean ret = true;
        for(int [] e : winning){
            for(int f : e) {
                if (f == a) {
                    for(int g:e){
                        if(g!=a){
                            if(!path.contains(g)) ret=false;
                        }
                    }
                }
            }
        }
        return ret;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        grid = new thing[n+1][n+1];
        int[][] convert = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}};
        for(int i=1;i<=n;n++) {
            String s = br.readLine();
            for (int j = 0, k = 1; j < s.length(); j += 3, k++) {
                String sub = s.substring(j, j + 3);
                if (sub.equals("###")) grid[i][k] = new thing('w');
                else if (sub.equals("...")) grid[i][k] = new thing('w');
                else if (sub.equals("BBB")) {
                    grid[i][k] = new thing('s');
                    bx = i;
                    by = k;
                } else if (s.charAt(i) == 'M') {
                    int loc = convert[Integer.parseInt(sub.substring(1, 2))][Integer.parseInt(sub.substring(2, 3))];
                    grid[i][k] = new thing('k', loc + 10);
                } else if (s.charAt(i) == 'O') {
                    int loc = convert[Integer.parseInt(sub.substring(1, 2))][Integer.parseInt(sub.substring(2, 3))];
                    grid[i][k] = new thing('k', loc);
                }
            }
        }
        for(int[] e:winning){
            int a=e[0],b=e[1],c=e[2];
            
        }

    }
}
