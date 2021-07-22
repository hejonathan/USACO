
public class hello {

	public static void main(String[] args) {
		double[] a = new double[51];
		a[1] = 15;
		for(int i=2;i<51;i++){
			a[i]=(a[i-1]-1)/3.0;
			System.out.println(a[i]);
		}

	}

}
