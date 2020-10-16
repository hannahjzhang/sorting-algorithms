public class MergeSort {
	
	public static void main(String[] args) {
		
//		int[] a = ArrayUtils.randomIntArray(20, 100);
//		System.out.println(Arrays.toString(a));
//		mergesort(a);
//		System.out.println(Arrays.toString(a));
		
		int[] b = {5, 4, 3, 2, 1};
		mergesort(b);
		printArray(b);
		
		int[] c = {72, 34, 200, 12, 45, 67, 89, 56};
		mergesort(c);
		printArray(c);
		
	}
	
	public static void mergesort(int[] a)
	{
		// if length is less than or equal to one, array is sorted
		if(a.length <= 1)
		{
			return;
		}
		
		// create an array for the first half
		int[] first = new int[a.length / 2];
				
		// create an array for the second half
		int[] second = new int[a.length - (a.length / 2)];
		
		// copy the first half of array into first, the second half into second
		for (int i = 0; i < a.length; i++)
		{
			if (i <= first.length - 1)
			{
				first[i] = a[i];
			}
			else
			{
				second[i - (a.length / 2)] = a[i];
			}
		}
	
		// recursively sort the partitions of the array
		mergesort(first);
		mergesort(second);
		
		// call merge to join the partitions together
		merge(first, second, a);
	}
	
	// merges two sorted arrays into an array
	private static void merge(int[] first, int[] second, int[] a)
	{
		int fIndex = 0;
		int sIndex = 0;
		
		// merge only works for this type of problem where first.length + second.length = a.length
		for (int i = 0; i <= a.length - 1; i++)
		{
			if (fIndex >= first.length)
			{
				a[i] = second[sIndex];
				sIndex++;
			}
			else if (sIndex >= second.length)
			{
				a[i] = first[fIndex];
				fIndex++;
			}
			else
			{
				if (first[fIndex] < second[sIndex])
				{
					a[i] = first[fIndex];
					fIndex++;
				}
				else
				{
					a[i] = second[sIndex];
					sIndex++;
				}
			}
		}
	}
	
	private static void printArray(int[] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + ", ");
		}
		System.out.println();
	}


}
