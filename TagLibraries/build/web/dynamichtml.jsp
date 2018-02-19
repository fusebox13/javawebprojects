<%@page import="java.util.*  " %>

<%
    ArrayList<String> colorList = new ArrayList<String>();
    colorList.add("red");
    colorList.add("blue");
    colorList.add("green");
    colorList.add("pink");
    colorList.add("orange");
    colorList.add("yellow");
    colorList.add("purple");

    request.setAttribute("colorList", colorList);
%>


<%@ taglib prefix="myTags" uri="http://wccnet.edu/chasselb/simpleTags" %>

<html><body>


<hr>
Select custom tag
<form method='Post', action='SelectBeer'>
    <myTags:select name='color' size='3' optionsList='${colorList}' />
    <br><br><input type="SUBMIT">
</form>


</body></html>