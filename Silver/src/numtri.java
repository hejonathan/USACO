/*
ID: 77617781
TASK: numtri
LANG: JAVA
*/
import java.util.*;
import java.io.*;
public class numtri {
    static int max=Integer.MIN_VALUE;
    static ArrayList<Integer>[] triangle;//items(n)=1+n
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("numtri.in"));PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        triangle=new ArrayList[n];
        for(int i=0;i<n;i++){
            triangle[i]=new ArrayList<>();
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<i+1;j++){
                triangle[i].add(Integer.parseInt(st.nextToken()));
                int add=i==0? 0:Math.max(j<i? triangle[i-1].get(j):0, j>0? triangle[i-1].get(j-1):0);
                triangle[i].set(j,triangle[i].get(j)+add);
            }
        }
        for(int e:triangle[n-1]){
            max=Math.max(e,max);
        }
        System.out.println(max);
        pw.println(max);pw.close();
        br.close();
    }
}
