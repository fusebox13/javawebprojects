<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
        <form action="PersonServlet">
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
                <input class="button" type="submit" name="action" value="add"/>
            </div>
            
        </form>
        </div>
        <hr>
        <h3>${errorMessage}</h3>
        
        <table cellspacing="0" cellpadding="0">
       
            <tr><th>First Name</th><th>Middle Name</th><th>Last Name</th><th>Eye Color</th><th>Hair Color</th><th>Weight</th><th>Height</th></tr>

            <c:forEach var="person" items="${people}"  varStatus="loopStatus" >
            <tr>
            <form action="PersonServlet">
                <td><input class="outBox" type ="text" read name="firstName" value="${person.firstName}"/></td>
                <td><input class="outBox" type ="text" read name="middleName" value="${person.middleName}"/></td>
                <td><input class="outBox" type ="text" read name="lastName" value="${person.lastName}"/></td>
                <td><input class="outBox" type ="text" read name="eyeColor" value="${person.eyeColor}"/></td>
                <td><input class="outBox" type ="text" read name="hairColor" value="${person.hairColor}"/></td>
                <td><input class="outBox" type ="text" read name="weight" value="${person.weight}"/></td>
                <td><input class="outBox" type ="text" read name="height" value="${person.height}"/></td>
                <td><input class="button" type="submit" name="action" value="remove"/></td>
                <td><input class="button" type="submit" name="action" value="update"/></td>
                <input type="hidden" name="index" value="${person.index}"/>
            </form>
            </tr>
        </c:forEach>
    </table>
    
    <form action="PersonServlet">
            <input class="button" type="submit" name="action" value="destroy">
    </form>
    
            
    </body>
</html>