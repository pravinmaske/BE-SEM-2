/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
@Author : Pravin Maske
*/
package quicksort1;


public class QuickSortClass implements Runnable 
{
    private final int high;
    private final int low;
    private final int[] arr;


	public QuickSortClass(int arr[],int low,int high)
	{
		this.low=low;
		this.high=high;
		this.arr=arr;
	}






	 void QuickSort(int[] arr, int low, int high) throws InterruptedException
	{
		if(arr == null || arr.length ==0)
			return;
		if(low >= high)
			return;
		int i= low;
		int j= high;
		//int middle = low + ( high-low )/2;
		int pivote = arr[low];
		while(i <= j)
		{
			while(arr[i] < pivote)
			{
				i++;
			}

			while(arr[j] > pivote)
			{
				j--;
			}

			if(i <= j)
			{
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		if(low < j)
		{

			QuickSort(arr,low,j);
			
		}
		if(high > i)
		{
			QuickSort(arr,i,high);
		}

	}

        @Override
	public void run() 
	{
		try {
			QuickSort(arr,low,high);
		} catch (InterruptedException e) {e.printStackTrace();}
	}




}
