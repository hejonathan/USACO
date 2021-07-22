/*
ID: 77617781
TASK: preface
LANG: JAVA
*/
import java.util.*;
import java.io.*;
public class preface {
    //static int i1,v5,x10,l50,c100,d500,m1000;
    static int[][] list;
    static int[] mem=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("preface.in"));PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));PrintWriter pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n=Integer.parseInt(br.readLine());
        list=new int[n+1][1001];
        for(int i=0;i<=n;i++)Arrays.fill(list[i],0);
        for(int i=1;i<=n;i++){
            if(list[i-1][0]!=0&&i%5!=0&&i%5!=4){
                for(int e:mem) list[i][e]=list[i-1][e];
                list[i][1]++;
                continue;
            }
            int value=i;
            for(int j=0;value>0;j++){
                list[i][mem[j]]+=value/mem[j];
                value-=(value/mem[j])*mem[j];
            }
            list[i][0]=1;
        }
        for(int i=2;i<=n;i++){
            for(int e:mem){
                if(list[i-1][e]!=-1) list[i][e]+=list[i-1][e];
            }
        }
        list[n][100]+=list[n][900];
        list[n][1000]+=list[n][900];
        list[n][100]+=list[n][400];
        list[n][500]+=list[n][400];
        list[n][10]+=list[n][90];
        list[n][100]+=list[n][90];
        list[n][10]+=list[n][40];
        list[n][50]+=list[n][40];
        list[n][1]+=list[n][9];
        list[n][10]+=list[n][9];
        list[n][1]+=list[n][4];
        list[n][5]+=list[n][4];
        if(list[n][1]>0) pw.println("I "+list[n][1]);
        if(list[n][5]>0)pw.println("V "+list[n][5]);
        if(list[n][10]>0)pw.println("X "+list[n][10]);
        if(list[n][50]>0) pw.println("L "+list[n][50]);
        if(list[n][100]>0)pw.println("C "+list[n][100]);
        if(list[n][500]>0)pw.println("D "+list[n][500]);
        if(list[n][1000]>0)pw.println("M "+list[n][1000]);
        pw.close();
        br.close();
    }
}
