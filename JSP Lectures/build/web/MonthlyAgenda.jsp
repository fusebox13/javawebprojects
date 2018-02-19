<%
    java.util.Calendar now = java.util.Calendar.getInstance();
    int month_num = now.get(java.util.Calendar.MONTH);
    String[] month_arr = {"January", "February", "March", "April", "May", "June",
                      "July", "August", "September", "October", "November", "December"};
    String month = month_arr[month_num - java.util.Calendar.JANUARY];
    String nextMonth = month_arr[(month_num - java.util.Calendar.JANUARY +1) % 12];
 %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=month%> Business Meeting</title>
    </head>
    <body>
        <h1>Agenda for the Month of <%=month%></h1>
        <ol>
            <li>Coffee and Donuts time</li>
            <li>Old business</li>
            <li>New business</li>          
            <li>Looking ahead to the Month of <%= nextMonth%></li>
        </ol>
    </body>
</html>