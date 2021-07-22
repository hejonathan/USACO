/*
ID: 77617781
TASK: castle
LANG: JAVA
*/
import java.util.*;
import java.io.*;
public class castle {
    static int m,n;
    static int[][] wall,group;
    static HashSet<Integer> west=new HashSet<>(Arrays.asList(1,3,5,7,9,11,13,15));
    static HashSet<Integer> north=new HashSet<>(Arrays.asList(2,3,6,7,10,11,14,15));
    static HashSet<Integer> east=new HashSet<>(Arrays.asList(4,5,6,7,12,13,14,15));
    static HashSet<Integer> south=new HashSet<>(Arrays.asList(8,9,10,11,12,13,14,15));
    static ArrayList<Integer> size=new ArrayList<>();
    static ArrayList<edge> edges=new ArrayList<>();
    static class edge{
        int a,b,i,j;
        char d;
        edge(int a,int b,int i,int j,char d){this.a=a;this.b=b;this.i=i;this.j=j;this.d=d;}
        boolean greaterThan(edge other){
            if(this.a==-1) return false;
            if(size.get(a)+size.get(b)!=size.get(other.a)+size.get(other.b)) return size.get(a)+size.get(b)>size.get(other.a)+size.get(other.b);
            if(j!=other.j) return j<other.j;
            if(i!=other.i) return i>other.i;
            if(d!=other.d) return d=='N';
            return true;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("castle.in"));PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));PrintWriter pw=new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        m=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        wall=new int[n][m];
        group=new int[n][m];
        for(int i=0;i<group.length;i++) Arrays.fill(group[i],-1);
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                wall[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int groupCount=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(group[i][j]!=-1)continue;
                size.add(0);
                dfs(i,j,groupCount);
                groupCount++;
            }
        }
        /*for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) pw.print(group[i][j]+" ");
            pw.println();
        }*/
        pw.println(groupCount);
        int max=0;
        for(int e:size){
            max=Math.max(max,e);
        }
        pw.println(max);
        edge maxCombined=new edge(-1,-1,-1,-1,'~');
        for(edge e:edges){
            maxCombined=maxCombined.greaterThan(e)? maxCombined:e;
        }
        pw.println(size.get(maxCombined.a)+size.get(maxCombined.b));
        pw.println((maxCombined.i+1)+" "+(maxCombined.j+1)+" "+maxCombined.d);
        pw.close();
        br.close();
    }
    static int groupNum(int i,int j){
        if(i>=0&&j>=0&&i<n&&j<m) return group[i][j];
        return -1;
    }
    static void dfs(int i,int j,int groupCount){
        if(group[i][j]!=-1) return;
        group[i][j]=groupCount;
        size.set(groupCount, size.get(groupCount)+1);
        if(!north.contains(wall[i][j])) dfs(i-1,j,groupCount);
        else{
            int gn=groupNum(i-1,j);
            if(gn!=-1&&gn!=groupCount){
                edges.add(new edge(groupCount,gn,i,j,'N'));
            }
        }
        if(!east.contains(wall[i][j])) dfs(i,j+1,groupCount);
        else{
            int gn=groupNum(i,j+1);
            if(gn!=-1&&gn!=groupCount){
                edges.add(new edge(groupCount,gn,i,j,'E'));
            }
        }
        if(!south.contains(wall[i][j])) dfs(i+1,j,groupCount);
        else{
            int gn=groupNum(i+1,j);
            if(gn!=-1&&gn!=groupCount){
                edges.add(new edge(groupCount,gn,i+1,j,'N'));
            }
        }
        if(!west.contains(wall[i][j])) dfs(i,j-1,groupCount);
        else{
            int gn=groupNum(i,j-1);
            if(gn!=-1&&gn!=groupCount){
                edges.add(new edge(groupCount,gn,i,j-1,'E'));
            }
        }
    }
}
