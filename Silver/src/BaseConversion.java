import java.io.*;
import java.util.*;
public class BaseConversion {
	public static String table="0123456789abcdef";
	public static int toDeci(String ori, int origbase, boolean p) {//from any base to decimal
		int ans=0;
		int count=0;
		if(p)System.out.println(ori+":");
		for(int i=ori.length()-1;i>=0;i--) {
			int index = table.indexOf(ori.charAt(i));
			if(index>=origbase) return -1;
			if(p)System.out.println(ori.charAt(i)+": "+index*(int)Math.pow(origbase, count));
			ans+=index*Math.pow(origbase, count++);
		}
		return ans;
	}
	public static String toBase(int deci, int destbase,boolean p) {//from decimal to any base
		int remainder=0;
		String ans="";
		if(p)System.out.print(deci+":");
		do {
			remainder=deci%destbase;
			if(p)System.out.println(table.charAt(remainder));
			deci/=destbase;
			ans=table.charAt(remainder)+ans;
			if(p)System.out.print(deci+" ");
		}while(deci!=0);
		return ans;
	}
	public static String keepnum1(String ori) {//automatically gets rid of the spaces and special characters
		return ori.replaceAll("[ A-Z.|,]", "");
	}
	public static String keepnum(String ori) {//automatically gets rid of the spaces and special characters
		return ori.replaceAll("[ A-Za-z.|,]", "");
	}
	public static String rsum(String a, String b, int base) {
		int dsum=toDeci(a,base,false)+toDeci(b,base,false);
		return toBase(dsum,base,false);
	}
	public static void sum() throws IOException{//returns the sum of two numbers in any base
		Scanner scanner = new Scanner(new File("base.in"));//I convert both numbers to decimal, but there are more efficient ways of doing it
		String a="";
		//System.out.print("Find Sum\nbase (enter the number to convert before hitting 'return'):\n(-1 to exit)");
		int base=Integer.parseInt(scanner.nextLine());
		while(!a.equals("-1")) {
			a=scanner.nextLine();
			//System.out.println(a);
			if(a.equals("-1"))break;
			String[] q = a.split("\\+",2);
			//System.out.println(keepnum1(q[0])+"\n"+keepnum1(q[1]));
			System.out.println(rsum(keepnum1(q[0]),keepnum1(q[1]),base));
			//System.out.println();
		}
		scanner.close();
	}
	public static void convert() throws IOException{//copy and paste the questions from the mission into this after deleting the line number
		Scanner scanner = new Scanner(new File("base.in"));
		int dest=0, orig=0;
		//System.out.print("dest:");
		orig=Integer.parseInt(scanner.nextLine());
		//System.out.print("origin:");
		dest=Integer.parseInt(scanner.nextLine());
		if(orig==10) {
			String temp=scanner.nextLine();
			int t=Integer.parseInt(keepnum(temp));
			while(t!=-1) {
				System.out.print(toBase(t,dest,true)+"\n");
				temp=scanner.nextLine();
				t=Integer.parseInt(keepnum(temp));
			}
		}else if(dest==10){
			String t;
			if(orig!=16) t=keepnum(scanner.nextLine());
			else t=keepnum1(scanner.nextLine());

			//System.out.println();
			while(!t.equals("-1")) {
				
				System.out.println(toDeci(t,orig,true));
				//System.out.println();
				if(orig!=16) t=keepnum(scanner.nextLine());
				else t=keepnum1(scanner.nextLine());
			}
		}
		scanner.close();
	}
	public static int a(int b) {
		return b;
	}
	public static void main(String[] args) throws IOException{
		//there are many known bugs to this program
		/*Scanner s = new Scanner(System.in);
		System.out.print("What would you like to do?\n 1.Convert\n 2.Find Sum\n");
		int a=0;
		while(a!=1&&a!=2) {
			a=s.nextInt();
			if(a==1)convert();
			else if(a==2)sum();
			else System.out.print("Invalid response\n");
		}*/
		//convert();
		sum();
	}
}
