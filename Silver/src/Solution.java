import java.util.*;
class Solution {
    public static int findCircleNum(int[][] M) {
        int[] group = new int[M.length];
        int c = 1;
        Stack<Integer> d = new Stack<>();
        for(int i=0;i<M.length;i++){
            if(group[i]!=0)continue;
            d.push(i);
            while(!d.empty()){
                int temp = d.pop();
                group[temp]=c;
                for(int j=0;j<M[temp].length;j++){
                    if(M[temp][j]==1&&group[j]==0){
                        d.push(j);
                    }
                }
            }
            c++;
        }
        return c-1;
    }
    public static void main(String[] args) {
        int[][] m = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(m));
    }
}