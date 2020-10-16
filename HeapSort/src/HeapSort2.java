
public class HeapSort2 {

	public static void main(String[] args) 
	{
		int[] z = {9, 2, 4, 5, 1, 34, 78, 6};
		int[] t = {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

		heapsort(z);
		printArray(z);
		
		heapsort(t);
		printArray(t);

	//  System.out.println(Arrays.toString(z));
	}


	public static void heapsort(int[] arr) 
    { 

        int length = arr.length; 
        int lastParentIndex = (length / 2) - 1;

        // Step 1:  Build max heap by calling heapify method
        // You'll need a loop here!
        // loop through all nodes with children
        for (int i = lastParentIndex; i >= 0; i--)
        {
        	heapify(arr, length, i);
        }
        
        // Now sort the array!
        // One by one extract an element from the max heap 

        for (int i = length - 1; i >= 0; i--) 
        { 
        	// Swap current node with end 
        	swap(arr, 0, i);

        	// call heapify on the reduced heap 
        	heapify(arr, i, 0);
     
        } 

    } 

    // To heapify a subtree rooted with node i which is an index in the array. 
    // length is the size of the heap 
	// this just does one step of heapify
    public static void heapify(int arr[], int length, int i) 
    { 

        int largest = i; // Initialize largest as root 
        int left = 2*i + 1; // left = 2*i + 1 
        int right = 2*i + 2; // right = 2*i + 2 

        // If left child is greater than largest...
        // make sure left exists
        if (left <= length - 1)
        {
        	if (arr[left] > arr[largest])
        	{
        		//swap(arr, left, largest);
        		largest = left;
        	}
        }

        // If right child is greater than largest...
        // make sure right exists
        if (right <= length - 1)
        {
        	if (arr[right] > arr[largest])
        	{
        		//swap(arr, right, largest);
        		largest = right;
        	}
        }
  
        // If largest is not root -- swap element at i with largest,                           
        // recursively heapify the affected sub-tree 
        // in order to push smaller numbers all the way down
        if (largest != i)
        {
        	swap(arr, i, largest);
        	//System.out.println();
        	//printArray(arr);
        	heapify(arr, length, largest);
        }

    }
    
    public static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
    
    public static void printArray(int[] a)
	{
		for (int i = 0; i < a.length - 1; i++)
		{
			System.out.print(a[i] + ", ");
		}
		System.out.println(a[a.length - 1]);
	}

} 