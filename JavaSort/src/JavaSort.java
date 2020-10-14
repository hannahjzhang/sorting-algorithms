

public class JavaSort {

	public static void main(String[] args) {
		int[] nums = new int[25];
		
		for(int i = 0; i<25; i++) {
			nums[i] = (int) (Math.random() * 26);
		}
		
		for(int a: nums) {
			System.out.print(a + ", ");
		}
		
		System.out.println();
		
		insertionSort2(nums);
		System.out.println();
		
		for(int a: nums) {
			System.out.print(a + ", ");
		}
		
	}
	
	public static void bubbleSort(int[] nums) 
	{
		for(int i=0; i< nums.length; i++) 
		{
			for(int j = 0; j< nums.length-i; j++) 
			{
				if(j + 1 > nums.length - 1) 
				{
					break;
				}
				else if (nums[j] > nums[j+1]) 
				{
					swap(nums, j, j+1);
				}
			}
		}
	}
	
	public static void swap(int[] nums, int a, int b) 
	{
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
	
	public static void insertionSort(int[] nums)
	{
		for (int i = 0; i < nums.length; i++)
		{
			int value = nums[i];
			for (int j = i - 1; j >= 0; j--)
			{
				if (nums[j] > value)
				{
					swap(nums, j, j + 1);
				}
				else
				{
					break;
				}
			}
		}
	}
	
	public static void insertionSort2(int[] nums)
	{
		for (int currentPos = 1; currentPos < nums.length; currentPos++)
		{
			int checkPos = currentPos;
			int temp = nums[currentPos];
			
			// make sure that the value is greater than 0
			// and that it is not the greatest value so far (or else do not move)
			while (checkPos > 0 && temp < nums[checkPos - 1])
			{
				// set a value to the value to the left of it (shifts everything to the right)
				nums[checkPos] = nums[checkPos - 1];
				checkPos--;
			}
			// set the correct place to the number
			nums[checkPos] = temp;
		}
	}
	
	public static void selectionSort(int[] nums) 
	{
		for(int j = 0; j < nums.length - 1; j++) 
		{
			int lowestNumIndex = j;
			for(int i = j + 1; i < nums.length; i++) 
			{
				if(nums[i] < nums[lowestNumIndex]) 
				{
					lowestNumIndex = i;
				}
			}
			swap(nums, lowestNumIndex, j); 
			
		}
	}

}


