import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
public class BinarySearch{
	static int[] firstArray;
	static int[] secondArray;
	static int[] answerArray;
	public static void main(String[] args) throws IOException{
		int firstArrayLength = 0;
		int secondArrayLength = 0;
		try{
			Scanner sc = new Scanner(new File("rosalind_bins.txt"));
			firstArrayLength = Integer.parseInt(sc.nextLine());
			secondArrayLength = Integer.parseInt(sc.nextLine());
			firstArray = new int[firstArrayLength];
			secondArray = new int[secondArrayLength];
			answerArray = new int[secondArrayLength];
			firstArray = makeArray(firstArrayLength,sc);
			secondArray = makeArray(secondArrayLength,sc);
			sc.close();
		} catch(IOException e){
			System.out.println("File not found!");
		}
		for(int i=0;i<secondArrayLength;i++){
			answerArray[i]=binarySearch(firstArray,secondArray[i]);
		}
		printInFile(answerArray);
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
	static int binarySearch(int[] array,int key){
		int lo=0;
		int hi = array.length-1;
		while(lo<=hi){
			int mid = lo+(hi-lo)/2;
			if (key<array[mid])
				hi = mid-1;
			else if (key>array[mid])
				lo = mid+1;
			else return mid+1;
		}
		return -1;
	}
}
