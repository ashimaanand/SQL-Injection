<%@ page import="java.sql.*"%>
<%
String acc=request.getParameter("acc");
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/injection","root","root");
Statement st=con.createStatement();
st.executeUpdate("delete from customerdetails where accountnumber='"+acc+"'");
response.sendRedirect("CustomerDetails.jsp");
%>
