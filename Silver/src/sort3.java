/*
ID: 77617781
TASK: sort3
LANG: JAVA
*/
import java.util.*;
import java.io.*;
public class sort3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("sort3.in"));PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));PrintWriter pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n=Integer.parseInt(br.readLine());
        int max=0;
        int[] arr=new int[n];
        int one=0,two=0,three=0;
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
            switch (arr[i]){
                case 1: one++;break;
                case 2: two++;break;
                case 3: three++;break;
            }
        }
        ArrayList<Integer> oneInThree=new ArrayList<>(),twoInThree=new ArrayList<>();
        for(int i=n-three;i<n;i++){
            if(arr[i]==1) oneInThree.add(i);
            else if(arr[i]==2) twoInThree.add(i);
        }
        int ans=0;
        for(int i=0;i<two+one;i++){
            if(arr[i]==3)
                if((i<one && !oneInThree.isEmpty())||twoInThree.isEmpty()){
                    int index=oneInThree.remove(0);
                    arr[index]=3;
                    arr[i]=1;
                    ans++;
                }else{
                    int index=twoInThree.remove(0);
                    arr[index]=3;
                    arr[i]=2;
                    ans++;
                }
        }
        ArrayList<Integer> oneInTwo=new ArrayList<>();
        for(int i=0;i<one;i++)
            if(arr[i]==2) {
                ans++;
            }
        pw.println(ans);
        pw.close();
        br.close();
    }
}
