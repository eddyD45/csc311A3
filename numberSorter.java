import java.io.IOException;

public class numberSorter {

	public static void main (String args[] ) throws IOException	{
		int [] numList = filereader.intfileToArray("numbers.txt");

		int [] bubbleList = bubbleSort(numList);
		int [] selectList = selectSort(numList);
		int [] insertList = insertSort(numList);
		
		System.out.println("**Bubble Sort**\n");
		for (int i = 0; i < bubbleList.length; i++) {
			System.out.println(bubbleList[i]);
		}
		
		System.out.println("\n**Selection Sort**\n");
		for (int i = 0; i < selectList.length; i++) {
			System.out.println(selectList[i]);
		}
		
		System.out.println("\n**Insertion Sort**\n");
		for (int i = 0; i < insertList.length; i++) {
			System.out.println(insertList[i]);
		}
		
		
		
		
	}
	
	public static int [] bubbleSort(int [] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j =  0; j < array.length - 1 - i; j++) {	//j < array.length - 1 - i because each iteration
				if (array[j] > array[j+1]) {					//of i will put the biggest value in the array at
					int temp = array[j];						//the end of the array. j doesn't have to go to 
					array[j] = array[j+1];						//to the end of the array anymore after the max
					array[j+1] = temp;							//is put in the end because that should never change
				}
			}
		}
		
		return array;
	}
	
	public static int [] selectSort(int [] array) {
		
		for (int i = 0; i < array.length; i++) {
			
			int min = array[i];
			int minIndex = i;
			
			for (int j = i; j < array.length; j++) {		//j = i because i keeps track of the first index,
				if (array[j] < min) {						//then j goes through the whole array. After the
					min = array[j];							//first iteration, the first index has the smallest
					minIndex = j;							//value. Then i shifts over one, and you use j to
				}											//find the second smallest value, then i shifts over
			}												//and so on. you don't need to worry about what came
															//before i anymore.
			if (min < array[i]) {
				int temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}
		
		
		return array;
	}
	
	public static int [] insertSort(int [] array)	{
		
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j = i;
			
			while (j > 0 && array[j - 1] > temp) {
				array[j] = array[j-1];
				j--;
			}
			array[j] = temp;
			
		}
		
		return array;
	}
	
	
}
