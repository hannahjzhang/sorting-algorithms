
public class Median {

	public static void main(String[] args) {
		int[] tester = { 7, 12, 9, 2, 3, 11, 1, 8, 6, 10, 5, 4 };
		int[] tester2 = { 3, 6, 1, 5, 2, 4 };
		int[] tester3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		
		System.out.println(median2(tester));
		System.out.println(median2(tester3));
		System.out.println(median(tester2));
		System.out.println(median(tester3));
	}
	
	public static void quicksort(int[] a) {
	    quick(a, 0, a.length-1);
	}
	    
	public static void quick(int[] a, int left, int right) {
	    if (right > left) {
	        int pivotPos = partition(a, left, right);
	        quick(a, left, pivotPos-1);
	        quick(a, pivotPos+1, right);
	    }
	}
	    
	public static int partition(int[] a, int left, int right) {
	    int splitPos = left;
	    for (int i = left; i < right; i++) {
	        if (a[i] < a[right]) {
	            swap(a, i, splitPos);
	            splitPos++;
	        }
	    }
	    swap(a,splitPos,right);
	    return splitPos;
	}

	public static void swap(int[] a, int i, int j) {
	    int temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
	}
	
	// used if the array is of an even size
	public static int leftMax(int[] a, int left, int right)
	{
		int leftMax = 0;
		for(int i = left; i <= right; i++)
		{
			if (a[i] > leftMax) 
			{
				leftMax = a[i];
			}
		}
		return leftMax;
	}
	public static int rightMin(int[] a, int left, int right)
	{
		int rightMin = a[right];
		for (int i = left; i <= right; i++)
		{
			if (a[i] < rightMin)
			{
				rightMin = a[i];
			}
		}
		return rightMin;
	}
	public static void printArray(int[] a)
	{
		for(int i=0; i<a.length; i++) {
			System.out.printf("%d,", a[i]);
		}
		System.out.println();
	}
	
	// iteratively
	public static double median (int[] a)
	{
		boolean run = true;
		int middle = a.length/2;
		int left = 0;
		int right = a.length - 1;
		
		while (run)
		{
			int splitPos = partition(a, left, right);
//			System.out.println(splitPos);
//			printArray(a);
			
			// if array size odd and if splitPos is on the middle
			if(a.length%2 == 1)
			{
				if (splitPos == middle)
				{
					return a[splitPos];
				}
			}
			// if array size is even and splitPos is on a middle position
			else if (a.length%2 == 0)
			{
				// if splitPos is equal to the middle, left side size is more
				if (splitPos == middle)
				{
					return (a[splitPos] + leftMax(a, left, splitPos - 1)) / 2.0;
				}
				// if splitPos is equal to middle-1, right side size is more
				else if (splitPos == middle - 1)
				{
					return (a[splitPos] + rightMin(a, splitPos + 1, right)) / 2.0;
				}
			}
			
			// splitPos < middle --> right has more numbers
			if (splitPos < middle)
			{
				left = splitPos + 1;
			}
			// splitPos > middle --> left has more numbers
			else
			{
				right = splitPos - 1;
			}
		}
		return -1;
	}
	
	// recursively
	public static double median2 (int[] a)
	{
		return medianHelper(a, 0, a.length - 1);
	}
	public static double medianHelper (int[] a, int left, int right)
	{
		int middle = a.length/2;
		
		int splitPos = partition(a, left, right);
		
		if(a.length%2 == 1)
		{
			if (splitPos == middle)
			{
				return a[splitPos];
			}
		}
		else if (a.length%2 == 0)
		{
			if (splitPos == middle)
			{
				return (a[splitPos] + leftMax(a, left, splitPos - 1)) / 2.0;
			}
			else if (splitPos == middle - 1)
			{
				return (a[splitPos] + rightMin(a, splitPos + 1, right)) / 2.0;
			}
		}
		
		if (splitPos < middle)
		{
			left = splitPos + 1;
			return medianHelper (a, left, right);
		}
		else
		{
			right = splitPos - 1;
			return medianHelper (a, left, right);
		}
		
	}

}
