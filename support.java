import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class support extends HttpServlet
{

    public support()
    {
    }

    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
        try
        {
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con=DriverManager.getConnection("jdbc:odbc:ecare","ecare","ecare");

//Class.forName("oracle.jdbc.driver.OracleDriver");
   //con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:project","ecare","ecare");
   st=con.createStatement();
            System.out.println("statement is created");
        }
        catch(Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }

    public void service(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        String s4 = "yes";
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        try
        {
            javax.servlet.http.HttpSession httpsession = httpservletrequest.getSession(true);
            String s = httpservletrequest.getParameter("text1");
            String s1 = httpservletrequest.getParameter("text2");
            String s2 = httpservletrequest.getParameter("text3");
            String s3 = httpservletrequest.getParameter("text4");
            System.out.println("Before inserting");
            int i = st.executeUpdate("insert into supportteam values('" + s + "','" + s1 + "','" + s2 + "','" + s3 + "')");
            System.out.println(i + " One row is inserted");
            System.out.println("After query");
            httpservletresponse.sendRedirect("./supportteamconfirm.html");
        }
        catch(Exception exception)
        {
            printwriter.println(exception.getMessage());
        }
    }
Connection con;
    Statement st;
    Statement st1;
    ResultSet rs;
}