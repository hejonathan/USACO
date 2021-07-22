import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution {
    static boolean within(String a,String b){
        int hra=Integer.parseInt(a.substring(0,2));
        int mia=Integer.parseInt(a.substring(3));
        int hrb=Integer.parseInt(b.substring(0,2));
        int mib=Integer.parseInt(b.substring(3));
        if(hra==hrb)return true;
        else{
            if(hra+1==hrb){
                return mib<=mia;
            }
        }
        return false;
    }
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        HashMap<String, List<String>> times = new HashMap<>();
        for(int i=0;i<keyName.length;i++){
            if(!times.containsKey(keyName[i])){
                times.put(keyName[i],new ArrayList<String>());
            }
            times.get(keyName[i]).add(keyTime[i]);
        }
        List<String> names = new LinkedList<>();
        for(HashMap.Entry<String,List<String>> e:times.entrySet()){
            Collections.sort(e.getValue());
            List<String> t = e.getValue();
            for(int i=0;i<t.size()-2;i++){
                if(within(t.get(i),t.get(i+2))){
                    names.add(e.getKey());
                    break;
                }
            }
        }
        return names;
    }
}