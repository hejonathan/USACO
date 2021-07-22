import java.io.*;
import java.util.StringTokenizer;

public class appleOrchard {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken()),
                appleTime=Integer.parseInt(st.nextToken()),boneTime=Integer.parseInt(st.nextToken());
        int a=Integer.parseInt(st.nextToken()),b=Integer.parseInt(st.nextToken()),
                appleTrade=Integer.parseInt(st.nextToken()),boneTrade=Integer.parseInt(st.nextToken());
        int applesNeeded = a-n,bonesNeeded = b-m;
        int time = 0;
        /*while (applesNeeded>0){
            if(applesNeeded>=appleTrade){
                if(appleTime*appleTrade > boneTime*boneTrade) {
                    time += (applesNeeded / appleTrade) * boneTrade * boneTime;
                    applesNeeded = (applesNeeded % appleTrade);
                }else{
                    time += applesNeeded*appleTime;
                    applesNeeded = 0;
                }
            }else if(applesNeeded < appleTrade){
                if(appleTime*applesNeeded > appleTime)
            }
        }*/
        int t1 = applesNeeded*appleTime+bonesNeeded*boneTime;
        int t2 = (int)((double)applesNeeded/appleTrade+1)*boneTrade*boneTime;
        if((applesNeeded%appleTrade)*appleTime>boneTrade*boneTime){
            if((appleTrade-(appleTrade-applesNeeded))*appleTime<Math.min(boneTrade,bonesNeeded)*boneTime){
                t2+=(appleTrade-(appleTrade-applesNeeded))*appleTime;
                bonesNeeded-=boneTrade;
                t2+=bonesNeeded*boneTime;
            }else{
                t2+=Math.min(boneTrade,bonesNeeded)*boneTime;
            }
        }
        int t3= bonesNeeded/boneTrade*appleTrade*appleTime;
        if((bonesNeeded%boneTrade)*boneTime>appleTrade*appleTime){
            if((boneTrade-(boneTrade-bonesNeeded))*boneTime<Math.min(appleTrade,applesNeeded)*appleTime){
                t3+=(boneTrade-(boneTrade-bonesNeeded))*boneTime;
                applesNeeded-=appleTrade;
                t3+=applesNeeded*appleTime;
            }else{
                t3+=Math.min(appleTrade,applesNeeded)*appleTime;
            }
        }
        System.out.println(Math.min(t1,Math.min(t2,t3)));
    }

}
