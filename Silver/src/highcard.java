import java.io.*;

public class highcard {
    static boolean[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("highcard.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));
        int n=Integer.parseInt(br.readLine());
        count=new boolean[2*n+1];
        for(int i=1;i<=n;i++){
            int a=Integer.parseInt(br.readLine());
            count[a]=true;
        }
        int elsie=0;
        for(int i=1;i<count.length;i++){
            if(count[i])elsie++;
            else{
                if(elsie>0)elsie--;
            }
        }
        //System.out.println(n-elsie);
        pw.println(n-elsie);
        pw.close();
        br.close();
    }
}
