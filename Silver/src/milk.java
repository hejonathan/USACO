/*
ID: 77617781
LANG: JAVA
TASK: milk
*/
import java.io.*;
import java.util.*;
import java.nio.*;
class milk {
	public static class farmer{
		int p,a;
		farmer(int p,int a){
			this.p=p;
			this.a=a;
		}
	}
	
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("milk.in"));
	    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
	    ArrayList<farmer> fm = new ArrayList<>();
	    int n=in.nextInt(),m=in.nextInt();
	    if(n==0||m==0) {output.println(0);output.close();return;}
	    for(int i=0;i<m;i++) {
	    	fm.add(new farmer(in.nextInt(),in.nextInt()));
	    }
	    Collections.sort(fm, (fm1,fm2)->fm1.p-fm2.p);
	    int i=0;
	    int cost = 0;
	    while(i<fm.size()&&n>=fm.get(i).a) {
	    	cost += fm.get(i).a * fm.get(i).p;
	    	n-=fm.get(i).a;
	    	i++;
	    }
	    if(n>0)
	    	cost+=fm.get(i).p * n;
	    output.println(cost);
	    output.close();
	}

}
