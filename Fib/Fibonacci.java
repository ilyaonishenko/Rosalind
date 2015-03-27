import java.util.Scanner;
public class Fibonacci{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		t++;
		int[] array = new int[t];
		array[0] = 0;
		array[1] = 1;
		for (int i=2;i<array.length;i++){
			array[i]=next(array[i-1],array[i-2]);
		}
		System.out.println(array[array.length-1]);
	}
	public static int next(int v,int w){
		return v+w;
	}
}
