import java.io.*;
//import xml.*;
import java.util.Arrays;
import org.w3c.dom.*;


import java.io.File;
import java.util.Arrays;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException; 



import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class Qk
{
	public static void main(String str[])
	{
		int[] arr = {0,0,0,0,0};
		readFromXML(arr);
		//readFromXML(arr);
		System.out.println("unsorted elements \n"+Arrays.toString(arr));
		int low = 0;
		int high = arr.length - 1;
		QuickSort(arr,low,high);
		System.out.println("Sorted elements :\n"+Arrays.toString(arr));
	}

	public static void QuickSort(int[] arr, int low, int high)
	{
		if(arr == null || arr.length ==0)
			return;
		if(low >= high)
			return;
		int i= low;
		int j= high;
		int middle = low + ( high-low )/2;
		int pivote = arr[middle];
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

	

	public static void readFromXML(int[] arr)
	{
		try
		{
					File fXmlFile = new File("input.xml");//1

					
					DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();//2

					DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();//3
					
					Document doc = dBuilder.parse(fXmlFile);//4
					doc.getDocumentElement().normalize();

					NodeList nList = doc.getElementsByTagName("number");//6

					for(int temp = 0; temp<nList.getLength();temp++)
					{
						Node nNode = nList.item(temp);

						if(nNode.getNodeType() == Node.ELEMENT_NODE)
						{

							Element eElement = (Element)nNode;	
							arr[temp] = Integer.parseInt(eElement.getElementsByTagName("value").item(0).getTextContent());

						}
					}	
		}catch(Exception e)
			{
				e.printStackTrace();
			}				
}






}

