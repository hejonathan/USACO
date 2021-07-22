import java.io.*;
import java.security.KeyPair;
import java.util.*;
//import javafx.util.*;
public class moocast {
	static class pair{
		int a;
		int b;
		pair(int a,int b){
			this.a=a;
			this.b=b;
		}
	}
	static class cows{
		int x;
		int y;
		int p;
		cows(int x,int y, int p){
			this.x=x;
			this.y=y;
			this.p=p;
		}
	}
	public static int n;
	public static void main(String[] args) throws IOException{
		pair p = new pair(1,3);
		PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
		BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
		n = Integer.parseInt(br.readLine());
		cows[] cow = new cows[n];
		for(int i=0;i<n;i++)cow[i]=new cows(0,0,0);
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cow[i].x=Integer.parseInt(st.nextToken());
			cow[i].y=Integer.parseInt(st.nextToken());
			cow[i].p=Integer.parseInt(st.nextToken());
			//System.out.println(cow[i].x+" "+cow[i].y+" "+cow[i].p);
		}
		
		List<List<Integer>> adj=new LinkedList<>();
		for(int i=0;i<n;i++)adj.add(new LinkedList<Integer>());
		
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				double dis = Math.sqrt(Math.pow(cow[i].x-cow[j].x, 2)+Math.pow(cow[i].y-cow[j].y,2));
				//System.out.println(dis);
				if(dis<=cow[i].p)adj.get(i).add(j);
				if(dis<=cow[j].p)adj.get(j).add(i);
			}
		}
		
		int mxcow = 0;
		//System.out.println(adj.get(0).toString());
		for(int i=0;i<n;i++) {
			boolean[] visited = new boolean[n];
			Arrays.fill(visited, false);
			int ccow = 0;
			Queue<Integer> q = new LinkedList<>();
			q.add(i);
			while(!q.isEmpty()) {
				int temp = q.remove();
				if(visited[temp])continue;
				ccow++;
				//System.out.print(temp);
				visited[temp]=true;
				for(int a:adj.get(temp)) {
					if(!visited[a])q.add(a);
				}
			}
			if(ccow>mxcow)mxcow=ccow;
			//System.out.println();
		}
		System.out.print(mxcow);
		output.println(mxcow);
		output.close();
		br.close();
	}

}
