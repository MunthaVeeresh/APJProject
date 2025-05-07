
public class PreeIncrement {
	public static void main(String[] args) {
		int i = 10;
		int j = 5;
		int k = 10;
		System.out.println(i++ + j++ + k-- + i-- + i-- + j--);
		System.out.println(i++ + j-- + k-- + i--);
		System.out.println(i+j+k);
	}

}
