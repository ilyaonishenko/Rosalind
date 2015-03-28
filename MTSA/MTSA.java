import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
public class MTSA{
	static int[] firstArray;
	static int[] secondArray;
	static int[] answerArray;
	static int firstArrayLen;
	static int secondArrayLen;
	static int answerArrayLen;
	public static void main(String[] args) throws IOException{
		try{
			Scanner sc = new Scanner(new File("rosalind_mer.txt"));
			firstArrayLen = Integer.parseInt(sc.nextLine());
			firstArray = new int[firstArrayLen];
			firstArray = makeArray(firstArrayLen,sc);
			secondArrayLen = Integer.parseInt(sc.nextLine());
			secondArray = new int[secondArrayLen];
			secondArray = makeArray(secondArrayLen,sc);
			sc.close();
		}catch (IOException e){
			System.out.println("\nIOException");
		}
		answerArray = new int[firstArrayLen+secondArrayLen];
		answerArray = mergeInPlace(firstArray,secondArray);
		printInFile(answerArray);
	}
	public static boolean less(int v,int w){
		return v<w;
	}
	static void printArray(int[] array){
		for(int i:array)
			System.out.print(i+" ");
		System.out.println();
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
	static int[] mergeInPlace(int[] array1,int[] array2){
		int lo1 = array1[0];
		int lo2 = array2[0];
		int hi=0;
		int lo=0;
		int i = 0;
		int j =0;
		int mid = 0;
		int[] answerArray = new int[array1.length+array2.length];
		if(lo1<lo2){
			for(int k=0;k<array1.length;k++)
				answerArray[k] = array1[k];
			for(int k=0;k<array2.length;k++)
				answerArray[array1.length+k]=array2[k];
			mid = array1.length-1;
		}
		else{
			for(int k=0;k<array2.length;k++)
					answerArray[k]= array2[k];
				for(int k=0;k<array1.length;k++)
					answerArray[array2.length+k] =array1[k];
					mid = array2.length-1;
		}
		j = mid+1;
		hi = answerArray.length-1;
		int[] array = new int[answerArray.length];
		for(int k=0;k<=hi;k++)
			array[k] =answerArray[k];
		for(int k=lo;k<=hi;k++){
			if(i>mid){
				array[k] = answerArray[j++];
			}
			else if (j>hi){
				array[k] = answerArray[i++];
			}
			else if (less(answerArray[j],answerArray[i]))
			{
				array[k] = answerArray[j++];
			}
			else{
				array[k] = answerArray[i++];
			}
		}
		return array;
	}
}
