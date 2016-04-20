/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bst;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author dattesh
 */
public class Binst 
{
    
    public static void main(String arg[])
    {
    
    
        
         int[] arr = new int[5];
		
        try
            {
                File f1 = new File("/home/dattesh/NetBeansProjects/Binary/src/bst/input.xml");//1


                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();//2

                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();//3

                Document doc = dBuilder.parse(f1);//4


                doc.getDocumentElement().normalize();//text node merge and removes empty nodes from xml file

                NodeList nList = doc.getElementsByTagName("number");//6

                        for(int i = 0; i<nList.getLength();i++)
                        {
                                Node nNode = nList.item(i);

                                if(nNode.getNodeType() == Node.ELEMENT_NODE)
                                {

                                        Element eElement = (Element)nNode;	
                                        arr[i] = Integer.parseInt(eElement.getElementsByTagName("value").item(0).getTextContent());

                                }
                        }	
		}catch(Exception e)
			{
				e.printStackTrace();
			}	

                System.out.println("Unsorted Array is");
                
                
                
                for(int i=0;i<arr.length;i++)
                {
                
                System.out.print(arr[i]+", ");               
                
                }
                
                
    for(int i=0;i<arr.length;i++)
    {

        for(int j=i+1;j<arr.length;j++)
        {

                if(arr[i]>arr[j])
                {

                        int temp=0;

                        temp=arr[i];
                        arr[i]=arr[j];
                        arr[j]=temp;
                }
                
        }
    }

    
        System.out.println("Unsorted Array is");
        for(int i=0;i<arr.length;i++){

        System.out.print(arr[i]+", ");
        }

        
    //
    int low=0;
    int high=arr.length -1;
    //int key=2;
    
    
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    int key = 0;
        try {
            System.out.println("Enter Key to be Searched");
            key = Integer.parseInt(br.readLine());
        } catch (IOException ex) {
            
        }
            
            
            
            
    //StringBuilder f2=new StringBuilder();
    
    bst(arr,key,low,high);

    
    
    
    }

    private static void bst(int[] arr, int key, int low, int high) {
    
        //To change body of generated methods, choose Tools | Templates.
        
        
if(low>high){

	System.out.println("Not found");
}
else{

	int mid=(low+high)/2;

	if(arr[mid]==key){


		System.out.println("Found"+(mid+1));
	}

	else if(arr[mid]>key){

		bst(arr,key,low,mid-1);
	}
	else if(arr[mid]<key){

		bst(arr,key,mid+1,high);


	}






}


    
    
    
    }
    
}
