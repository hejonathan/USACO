import java.io.*;
import java.util.*;

public class cruise {
    static class Node{
        int l,r;
        Node(int left,int right){l=left;r=right;}
        public String toString(){return l+" "+r;}
    }
    static class state{
        int nd;
        int it;
        state(int node, int iteration){nd=node;it=iteration;}
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            state state = (state) o;
            return it == state.it &&
                    Objects.equals(nd, state.nd);
        }
        @Override
        public int hashCode() {
            return Objects.hash(nd, it);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("cruise.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cruise.out")));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken()),j=Integer.parseInt(st.nextToken());
        long k=(long)j*(long)m;
        Node[] node=new Node[n+1];
        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine());
            node[i]=new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        char[] seq=new char[m+1];
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=m;i++){
            seq[i]=st.nextToken().charAt(0);
        }
        //traverse M again until find the same state, storing nodes in a cycle
        //when found k-=times, i=current iteration in m
        //create an arraylist of the cycle found
        //return arr[i]+(m*k)%cycle.size
        Map<state,Integer> path=new LinkedHashMap<>();
        int i=1;
        int s=1;
        state cur=new state(1,i);
        while(!path.containsKey(cur)){
            path.put(cur,s);
            //System.out.println(cur.nd+" "+s+" "+cur.it);
            if(k==0){
                pw.println(cur.nd);
                pw.close();
                return;
            }
            int next=(seq[cur.it]=='L')? node[cur.nd].l:node[cur.nd].r;
            i++;
            if(i>m)i=1;
            s++;
            k--;
            cur=new state(next,i);
        }
        //List<Integer> cycle=new ArrayList<>();
        int last=path.get(cur);
        int t=0;
        for(state e:path.keySet()){
            if(path.get(e)>=last) t++;
        }
        k%=t;
        /*int ans=0;
        //int nits=0;
        //nits=(int)k*m-last+1;
        //ans=cycle.get(nits%cycle.size());
        ans=cycle.get((int)k);
        pw.println(ans);*/
        //System.out.println(ans);
        while(k>0){
            //path.put(cur,s);
            //System.out.println(cur.nd+" "+s+" "+cur.it);

            int next=(seq[cur.it]=='L')? node[cur.nd].l:node[cur.nd].r;
            i++;
            if(i>m)i=1;
            s++;
            k--;
            cur=new state(next,i);
        }
        pw.println(cur.nd);
        pw.close();
        br.close();
    }
    /*static class pair{
        int x,s;
        pair(int position, int instruction){x=position;s=instruction;}
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            pair pair = (pair) o;
            return x == pair.x &&
                    s == pair.s;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, s);
        }
    }
    static int[] L,R;
    static char[] S;
    static int m;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("cruise.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cruise.out")));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        long k=Integer.parseInt(st.nextToken());
        L=new int[n];
        R=new int[n];
        S=new char[n];
        k*=m;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            L[i]=Integer.parseInt(st.nextToken())-1;
            R[i]=Integer.parseInt(st.nextToken())-1;
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            S[i]=st.nextToken().charAt(0);
        }
        pair slow=new pair(0,0);
        pair fast=new pair(0,0);
        for(;k>0;k--){
            slow=getNext(slow);
            fast=getNext(getNext(fast));
            if(slow==fast){
                k--;
                break;
            }
        }
        if(k>0){
            int t=1;
            for(slow=getNext(slow);slow!=fast;t++){
                slow=getNext(slow);
            }
            k%=t;
        }
        for(;k>0;k--){
            slow=getNext(slow);
        }
        pw.println(slow.x+1);
        pw.close();
        br.close();
    }
    static pair getNext(pair a){
        if(S[a.s]=='L') return new pair(L[a.x],(a.s+1)%m);
        else return new pair(R[a.x],(a.s+1)%m);
    }*/
}
