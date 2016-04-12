/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort1;

//import xml.*;
import java.util.Arrays;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class MyClass
{
	public static void main(String str[]) throws InterruptedException
	{
            int[] arr = new int[10];
		//int[] arr = {0,0,0,0,0,0,0,0,0,0,0,0,0};
		
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


	System.out.println("unsorted elements \n"+Arrays.toString(arr));
		int low = 0;
		int high = arr.length - 1;
		
		Thread t = new Thread(new QuickSortClass(arr, low, high));
			t.start();
			t.join();

		//QuickSort(arr,low,high);
		System.out.println("Sorted elements :\n"+Arrays.toString(arr));		


	}
}




/*
Oitput:
run:
unsorted elements 
[5, 1, 0, 17, 12, 8, 4, 3, -1, 50]
Sorted elements :
[-1, 0, 1, 3, 4, 5, 8, 12, 17, 50]
BUILD SUCCESSFUL (total time: 0 seconds)
*/
