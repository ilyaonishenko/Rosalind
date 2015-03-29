import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
public class MajorityElement{
	static int num;
	static int len;
	static int[] array;
	static int[] answerArray;
	public static void main(String[] args)throws IOException{
		try{
			Scanner sc = new Scanner(new File("rosalind_maj.txt"));
			int[] twoArray = new int[2];
			twoArray = makeArray(2,sc);
			num = twoArray[0];
			len = twoArray[1];
			array = new int[len];
			answerArray = new int[num];
			for(int i=0;i<num;i++){
				array = makeArray(len,sc);
				answerArray[i] = majorityElement(array);
			}
			sc.close();
		}catch(IOException e){
			System.err.println("ERROR");
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
	static int majorityElement(int[] array){
		int count = 0;
		int element = array[0];
		int N = array.length;
		for(int i=0;i<N;i++){
			if(array[i]==element)
				count++;
			else if (count==0){
				element = array[i];
				count = 1;
			}
			else count--;
		}
		count = 0;
		for(int i=0;i<N;i++){
			if(array[i]==element)
				count++;
		}
		if (count>array.length/2)
			return element;
		else return -1;
	}
}
