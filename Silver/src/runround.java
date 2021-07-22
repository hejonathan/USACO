/*
ID: 77617781
TASK: runround
LANG: JAVA
*/
import java.io.*;
import java.util.*;
public class runround {
    static int nextIndex(int current,int add,int size){
        if(current+add < size) return current+add;
        return (current+add)%size;
    }
    static boolean isrr(long n){
        int[] arr=toArray(n);
        boolean[] digits=new boolean[10];
        for(int e:arr){
            if(digits[e]==true) return false;
            digits[e]=true;
        }
        if(digits[0]) return false;
        for(int i=0;i<arr.length;i++){
            arr[i]=nextIndex(i,arr[i],arr.length);
        }
        int next=0;
        boolean[] visited = new boolean[arr.length];
        while(true){
            if(visited[next]) break;
            visited[next]=true;
            next=arr[next];
        }
        for(boolean e:visited){
            if(e==false){
                return false;
            }
        }
        return next==0;
    }
    static int[] toArray(long n){
        ArrayList<Integer> list=new ArrayList<>();
        while(n>0){
            int digit=(int)(n%10);
            n/=10;
            list.add(digit);
        }
        Collections.reverse(list);
        int[] ret=new int[list.size()];
        for(int i=0;i<ret.length;i++) ret[i]=list.get(i);
        return ret;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("runround.in"));PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));PrintWriter pw=new PrintWriter(new OutputStreamWriter(System.out));
        long m=Long.parseUnsignedLong(br.readLine());
        long n=m+1;
        while(!isrr(n))
            n++;
        pw.println(n);
        pw.close();
        br.close();
    }
}
