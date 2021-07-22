/*
ID: 77617781
LANG: JAVA
TASK: barn1
*/
import java.io.*;
import java.util.*;
public class barn1 {
	public static void main(String[] args) throws IOException {
		BufferedReader f  = new BufferedReader(new FileReader("barn1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int m=Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
		ArrayList<Integer> blanks = new ArrayList<>();
		int [] occ = new int [c];
	
		for(int i=0; i<c; i++) {
			st = new StringTokenizer(f.readLine());
			occ[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(occ);
		for (int i=1; i<c; i++) {
			blanks.add(occ[i]-occ[i-1]-1);
		}
		
		Collections.sort(blanks, Collections.reverseOrder());
		
		int nb = 0;
		nb+=occ[0]-1;
		nb+=s-occ[c-1];
		for(int i = 1; i<m && i-1 < blanks.size(); i++) {
			//System.out.println(blanks.get(i-1));
			nb+=blanks.get(i-1);
		}
		//System.out.print(s-nb);
		out.println(s-nb);
		out.close();
	}

}
