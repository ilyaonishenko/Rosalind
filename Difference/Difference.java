import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class Difference{
	static int[] firstArray;
	static int[] secondArray;
	static int[] makeArray(String text){
		int w = len(text);
		int[] array = new int[w];
		array = parser(text);
		return array;
	}
	static int len(String text){
		return text.split(" ").length;
	}
	static int[] parser(String text){
		int w = len(text);
		int[] array = new int[w];
		String[] stringArray = text.split(" ");
		for(int i=0;i<stringArray.length;i++){
			try{
				array[i] = Integer.parseInt(stringArray[i]);
			} catch(NumberFormatException e){
				System.out.println("Exception "+stringArray[i]);
			}
		}
		return array;
	}
	public static void main(String[] args){
		String text = "";
		try{
			Scanner sc = new Scanner(new File("answer.txt"));
			text = sc.nextLine();
			sc.close();
		} catch(IOException e)
		{
			System.out.println("Балбес");
		}
		firstArray = new int[len(text)];
		firstArray = makeArray(text);
		try{
			Scanner sc2 = new Scanner(new File("rosalind_bins_5_output.txt"));
			text  = sc2.nextLine();
			sc2.close();
		} catch(IOException e){
			System.out.println("Балбес2");
		}
		secondArray = new int[len(text)];
		secondArray = makeArray(text);
		int count =0;
		for(int i=0;i<len(text);i++)
			if(firstArray[i]!=secondArray[i])
			{
				System.out.println(firstArray[i]+" vs "+secondArray[i]+" i= "+i);
			}
			else count++;
		System.out.println("All good& Count = "+count);
	}
}
