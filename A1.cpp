#include<iostream>
#include<stdio.h>
using namespace std;

void binarySearch(int arr[], int num, int first, int last)
{
	if(first>last)
	{
		cout<<"\nelement not found..!\n";
	}
	else
	{
		int mid;
		mid=(first+last)/2;
		
		if(arr[mid] == num)
		{
			cout<<"\nelement found at index : "<<mid+1<<endl;
		}
		else if(arr[mid]>num)
		{
			binarySearch(arr,num,first,mid-1);
		}
		else if(arr[mid]<num)
		{
			binarySearch(arr,num,mid+1,last);
		}
	}

}
int main()
{
	int arr[100],beg,end,i,j,num,n,temp;
	cout<<"\nEnter size of array";
	cin>>n;

	cout<<"\nEnter unordered elements :\n";
	for(i=0;i<n;i++)
	{
		cin>>arr[i];
	}

	cout<<"sorted elements :\n";

	for(i=0;i<n;i++)
	{
		for(j=i+1;j<n;j++)
		{
			if(arr[i]>arr[j])
			{
				temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
	}


	for(i=0;i<n;i++)
	{
		cout<<"  "<<arr[i];
	}
	cout<<"\nEnter number to search :\t";
	cin>>num;
	beg=0;
	end=n-1;
	binarySearch(arr,num,beg,end);
	
return 0;

}
