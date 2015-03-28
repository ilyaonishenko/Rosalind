import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
public class InsertionSort{
	static int[] array;
	static int count;
	public static boolean less(int v,int w){
		return v<w;
	}
	static void exch(int[] array,int i,int j){
		int t = array[i];
		array[i]=array[j];
		array[j]=t;
	}
	static int[] makeArray(int w,Scanner sc){
		String text = sc.nextLine();
		int[] array = new int[w];
		array = parser(text,w);
		return array;
	}
	static int[] parser(String text,int w){
		int[] array = new int[w];
		String[] stringArray = text.split(" ");
		for(int i=0;i<stringArray.length;i++){
			array[i] = Integer.parseInt(stringArray[i]);
		}
		return array;
	}
	static void printInFile(int[] array) throws IOException{
		FileWriter fw = new FileWriter(new File("answer.txt"));
		for(int i:array)
			fw.write(i+" ");
		fw.flush();
		fw.close();
	}
	static int insertionSort(int[] array){
		int N=array.length;
		int count=0;
		for(int i=0;i<N;i++){
			for(int j=i;j>0&&less(array[j],array[j-1]);j--){
				exch(array,j,j-1);
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args){
		int arrayLenght=0;
		try{
			Scanner sc = new Scanner(new File("rosalind_ins.txt"));
			arrayLenght = Integer.parseInt(sc.nextLine());
			array = new int[arrayLenght];
			array = makeArray(arrayLenght,sc);
			sc.close();
		} catch(IOException e){
			System.out.println("IOException");
		}
		count = insertionSort(array);
		System.out.println("Количество перестановок: "+count);
	}
}
