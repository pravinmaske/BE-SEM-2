<%-- 
    Document   : newjsp
    Created on : Apr 17, 2016, 5:48:32 PM
    Author     : PRAVIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String f1 = request.getParameter("File1");
            String f2 = request.getParameter("File2");
            
            out.println("\ncomparing two files ");
            out.println("\nThe result of two files :");
            if(compareStrings(f1,f2))
               
            {
                out.println("plagiarism detected cheaters..!!");
            }
            else
            {
                out.println("plagiarism not detected.. unique contents");
            }
        %>
        <%!
            public static boolean compareStrings(String a, String b)
            {
            
            boolean result = false;
                String[] piecesA = a.split("\\s");
                String[] piecesB =b.split("\\s");
                
                int count1=0;
                int count2=0;
                
               for (int counter = 0; counter <= piecesA.length - 1; counter++)
             { 
                   for(int counter2 = 0; counter2<= piecesB.length - 1; counter2++)
                   { 
                     if(piecesA[counter].equals(piecesB[counter2]))
                     { 
                       count1++; 
                     } 
                   } 
             } 
                
               
               
               
               
                 for(int counter=0; counter<=piecesA.length - 1;counter++)
                {
                    for(int counter1 = 0; counter1 < piecesB.length; counter1++)
                    {
                        if(piecesA[counter].equals(piecesB[counter1]))
                        {
                            count2++;
                        }
                    }
                }
                
               if((count1/(int)piecesA.length)*100>=68 && (count2/(int)piecesB.length)*100>=68)
               {
                   result =  true;
               }
                
            
            return result;
            }
        %>
    </body>
</html>
