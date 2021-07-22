import java.io.*;
import java.util.*;

public class multimoo {
    static int n;
    static int[][] grid;
    static class region{
        int size;
        int cownum;
        Set<Integer> adj;
        region(int a,int b){size=a;cownum=b;adj=new HashSet<>();}
        region(){size=-1;cownum=-1;adj=new HashSet<>();}
    }
    static int[][] group;
    static ArrayList<region> regions;
    static List<Integer>[] owns;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("multimoo.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("multimoo.out")));
        n=Integer.parseInt(br.readLine());
        grid=new int[n][n];
        Map<Integer,Integer> nc=new HashMap<>();
        int a=0;
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                grid[i][j]=Integer.parseInt(st.nextToken());
                if(!nc.containsKey(grid[i][j])) nc.put(grid[i][j],++a);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                grid[i][j]=nc.get(grid[i][j]);
            }
        }
        regions=new ArrayList<>();
        regions.add(new region());
        owns=new ArrayList[nc.size()+1];
        for(int i=0;i<owns.length;i++) owns[i]=new ArrayList<>();
        group=new int[n][n];
        for(int i=0;i<group.length;i++)Arrays.fill(group[i],-1);
        int gc=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(group[i][j]!=-1)continue;
                regions.add(new region(0,grid[i][j]));
                dfs(i,j,++gc);
            }
        }

        //for(int[]e:grid) System.out.println(Arrays.toString(e));
        //for(int[]e:group) System.out.println(Arrays.toString(e));

        int max=0;
        for(region e:regions){
            max=Math.max(e.size,max);
        }
        pw.println(max);
        System.out.println(max);
        max=0;
        for(int i=1;i<regions.size();i++){
            int ccow=regions.get(i).cownum;
            for(int nei:regions.get(i).adj){
                Set<Integer> visited=new HashSet<>();
                int nbcow=regions.get(nei).cownum;
                Queue<Integer> q=new LinkedList<>();
                q.add(i);
                int csize=0;
                while(!q.isEmpty()){
                    int temp=q.remove();
                    if(visited.contains(temp))continue;
                    visited.add(temp);
                    csize+=regions.get(temp).size;
                    for(int e:regions.get(temp).adj){
                        if(!visited.contains(e)&&(regions.get(e).cownum==ccow||regions.get(e).cownum==nbcow)){
                            q.add(e);
                        }
                    }
                }
                max=Math.max(csize,max);
            }
        }
        pw.println(max);
        System.out.println(max);
        pw.close();
        br.close();
    }
    static void dfs(int i,int j,int gn){
        if(i<0||i>=n||j<0||j>=n)return;
        if(group[i][j]!=-1){
            return;
        }
        group[i][j]=gn;
        regions.get(gn).size++;
        if(i>0&&grid[i][j]==grid[i-1][j]) dfs(i-1,j,gn);
        if(i+1<n&&grid[i][j]==grid[i+1][j]) dfs(i+1,j,gn);
        if(j>0&&grid[i][j]==grid[i][j-1]) dfs(i,j-1,gn);
        if(j+1<n&&grid[i][j]==grid[i][j+1]) dfs(i,j+1,gn);

        if(i>0&&grid[i][j]!=grid[i-1][j]&&group[i-1][j]!=-1){
            regions.get(gn).adj.add(group[i-1][j]);
            regions.get(group[i-1][j]).adj.add(gn);
        }
        if(i+1<n&&grid[i][j]!=grid[i+1][j]&&group[i+1][j]!=-1){
            regions.get(gn).adj.add(group[i+1][j]);
            regions.get(group[i+1][j]).adj.add(gn);
        }
        if(j>0&&grid[i][j]!=grid[i][j-1]&&group[i][j-1]!=-1){
            regions.get(gn).adj.add(group[i][j-1]);
            regions.get(group[i][j-1]).adj.add(gn);
        }
        if(j+1<n&&grid[i][j]!=grid[i][j+1]&&group[i][j+1]!=-1){
            regions.get(gn).adj.add(group[i][j+1]);
            regions.get(group[i][j+1]).adj.add(gn);
        }
    }
}
