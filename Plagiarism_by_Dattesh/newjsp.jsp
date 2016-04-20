<%-- 
    Document   : newjsp2
    Created on : 20 Apr, 2016, 6:22:01 PM
    Author     : dattesh
--%>

<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%!
        
            public static int searchString(String[] str1, String key) {
        int first = 0;
        int last  = str1.length;

        while (first < last) {
            int mid = (first + last) / 2;
            if (key.compareTo(str1[mid]) < 0) {
                last = mid;
            } else if (key.compareTo(str1[mid]) > 0) {
                first = mid + 1;
            } else {
                return 1;
            }
        }
        return -1;
    }
        
        
        %>
        
        
        
        
        <%
            
            String fileOne = request.getParameter("File1");
            //String fileTwo = request.getParameter("File2");
             BufferedReader br=null;
             br=new BufferedReader(new FileReader("/home/dattesh/NetBeansProjects/Plagiarism/web/testing.txt"));
             StringBuilder f3=new StringBuilder();
             
            do{
                
                f3.append(br.readLine());
            }while(br.readLine()!=null);    
            
             String f4 =f3.toString();
            
            
            out.println("Comparing the 2 files......");out.println("<br>");
            String[] str1 = fileOne.split("\\s");
            String[] str2 = f4.split("\\s");
            
            for (int j = 0; j < str1.length; j++) { //alphabetical order sorting of str1
                for (int i = j + 1; i < str1.length; i++) {
                    if (str1[i].compareTo(str1[j]) < 0) {
                      String t = str1[j];
                      str1[j] = str1[i];
                      str1[i] = t;
                    }
                }              
            }
            
            
            int results; double plag=0;
            for (int key = 0; key < str2.length; key++){
                results = searchString(str1, str2[key]);
                if (results == 1) {
                    plag = plag+1;
                }
            
            }
            double plagPercent = (plag/str2.length)*100;
            
            out.println("Similarity between two text is "+ plagPercent);
            out.println("Plagrism "+((plagPercent>50.0) ? "exist" : "does not exist"));
            
            
        %>
    </body>
</html>
