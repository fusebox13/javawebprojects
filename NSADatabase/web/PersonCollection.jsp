<%-- 
    Document   : PersonCollection
    Created on : Oct 19, 2013, 11:07:55 AM
    Author     : Dan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Person.*" %>
<%
    PersonCollection personCollection = PersonCollection.update(pageContext);    
%>


<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Super Secret NSA Database</title>
    </head>
    <body>
        <h1>Super Secret NSA Database</h1>
        <p>
        <div>    
        <form action="PersonCollection.jsp">
            <div class="row">
                <div class="label">First Name</div>
                <div class="form"> <input class="nameBox" type="text" name="firstName"  /></div>
            </div>
            <div class="row">
                <div class="label">Middle Name</div>
                <div class="form"> <input class="nameBox" type="text" name="middleName"  /></div>
            </div>
            <div class="row">
                <div class="label">Last Name</div>
                <div class="form"> <input class="nameBox" type="text" name="lastName"  /></div>
            </div>
       
            <div class="row">
                <div class="selectLabel">Eye Color</div>
                
                <div class="selectLabel">Hair Color</div>
                <div class="hwLabel">Weight</div>
                <div class="hwLabel">Height</div>
                
            </div>
            
            <div class="row">
                <div class="select">
                    <select class ="selectBox" name="eyeColor">
                        <option value="Amber">Amber</option>
                        <option value="Blue">Blue</option>
                        <option value="Brown">Brown</option>
                        <option value="Gray">Gray</option>
                        <option value="Green">Green</option>
                        <option value="Hazel">Hazel</option>
                        <option value="Red">Red</option>
                        <option value="Violet">Violet</option>
                    </select>
                </div>
                <div class="select">
                    <select class ="selectBox" name="hairColor">
                        <option value="Auburn">Auburn</option>
                        <option value="Black">Black</option>
                        <option value="Brown">Brown</option>
                        <option value="Blond">Blond</option>
                        <option value="Chestnut">Chestnut</option>
                        <option value="Red">Red</option>
                        <option value="Gray">Gray</option>
                        <option value="White">White</option>
                    </select>
                </div>
                <div class="hwLabel">
                    <input class="hwBox" type="text" name="weight" width/>
                </div>
                <div class="hwLabel">
                    <input class="hwBox" type="text" name ="height"/> 
                </div>
            
            </div>
            <div class="row">
                <input class="button" type="submit" name="action" value="Add"/>
            </div>
            
        </form>
        </div>
        <hr>
        <h3><%=personCollection.getErrorMessage()%></h3>
        
        <table cellspacing="0" cellpadding="0">
            <%
                if(personCollection.hasEntries())
                {
            %>
            
            <tr><th>First Name</th><th>Middle Name</th><th>Last Name</th><th>Eye Color</th><th>Hair Color</th><th>Weight</th><th>Height</th></tr>
        
            <%
                
                    for (int i=0; i < personCollection.size(); i++)
                    {
                        Person tdPerson = personCollection.getPerson(i);
            %>
            
            <tr>
            <form action="PersonCollection.jsp">
                <td><input class="outBox" type ="text" read name="firstName" value="<%=tdPerson.getAttribute("firstName")%>"/></td>
                <td><input class="outBox" type ="text" read name="middleName" value="<%=tdPerson.getAttribute("middleName")%>"/></td>
                <td><input class="outBox" type ="text" read name="lastName" value="<%=tdPerson.getAttribute("lastName")%>"/></td>
                <td><input class="outBox" type ="text" read name="eyeColor" value="<%=tdPerson.getAttribute("eyeColor")%>"/></td>
                <td><input class="outBox" type ="text" read name="hairColor" value="<%=tdPerson.getAttribute("hairColor")%>"/></td>
                <td><input class="outBox" type ="text" read name="weight" value="<%=tdPerson.getAttribute("weight")%>"/></td>
                <td><input class="outBox" type ="text" read name="height" value="<%=tdPerson.getAttribute("height")%>"/></td>
                <td><input class="button" type="submit" name="action" value="remove"/></td>
                <td><input class="button" type="submit" name="action" value="update"/></td>
                <input type="hidden" name="index" value="<%= i%>"/>
            </form>
            </tr>
            <%
                    }
            %>
    </table>
    
    <form action="PersonCollection.jsp">
            <input class="button" type="submit" name="action" value="Destroy">
    </form>
    <%
                }
    %>
        
            
    </body>
</html>
