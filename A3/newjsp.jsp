<%-- 
    Document   : newjsp
    Created on : Apr 18, 2016, 10:12:34 PM
    Author     : PRAVIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Page..!!</title>
    </head>
    <body>
        <%!
        public int size =12;
        %>
        
        
        <%!
        
        public void bin_add(int q[], int m[])
        {
            int c[] = new int[size];
            int cr = 0;
            for(int i=size-1;i>=0;i--)
            {
                c[i] = (q[i]+m[i]+cr)%2;
                cr = (q[i]+m[i]+cr)/2;
                q[i] = c[i];
            }
        }
        
        public void to_2comp(int m[])
        {
            int i = size-1;
            while(m[i--]!=1)
            {
                if(i<0)
                    break;
            }
            for(;i>=0;i--)
                m[i] = m[i]==0?1:0;
            
        }
        public void bin_sub(int q[], int m[])
        {
            try
            {
                to_2comp(m);
                bin_add(q,m);
                to_2comp(m);
            }catch(Exception e){e.printStackTrace();}
        }
        public void to_bin(int m[],int m1)
        {
            int i = size-1;
            do
            {
                if(i<0)
                    break;
                m[i--] = (m1%2);
                m1 = m1/2;
            }while(m1!=0);
        }
        %>
        <%
            int m1 = Integer.parseInt(request.getParameter("m1"));
            
            int r1  = Integer.parseInt(request.getParameter("m2"));
            
            int r[] = new int[size];
            int q[] = new int[size];
            
            int m[] = new int[size];
            int bb = 0;
            
            
                to_bin(m,m1);
                to_bin(r,r1);
            
            int w = size;
            
            
            while(w!=0)
            {
                if((r[size-1] == 1) && (bb==0))
                {
                    bin_sub(q,m);
                }
                
                if((r[size-1] == 0) && bb == 1)
                {
                    bin_add(q,m);
                }
                
                //ASR logic below..
                
                bb =r[size-1];
                int tmp = q[size-1];
                
                for(int i=size-1;i>0;i--)
                {
                    q[i] = q[i-1];
                }
                for(int i=size-1;i>0;i--)
                {
                    
                    r[i] = r[i-1];
                }
                r[0]=tmp;
                
                w--;
            }
            
            //ALU display LOGIC below
            out.println("<br>"+"\nFinal result in Binary :");
            int alu[] = new int[2*size];
            int z = 0;
            for(int i=0;i<size;i++)
            {
                alu[z++] = q[i];
                
            }
            
            for(int i = 0;i<size;i++)
            {
                alu[z++] = r[i];
                
            }
            for(int i = 0;i<2*size;i++)
            {
                out.println(alu[i]);
            }
            
        %>
    </body>
</html>
