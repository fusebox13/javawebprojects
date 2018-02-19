<%-- 
    Document   : index
    Created on : Dec 3, 2013, 12:11:38 PM
    Author     : Dan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style ="height: 100%">
    <head>
        <link rel="stylesheet" type="text/css" href="font.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>le Reddit Image Scraper</title>
    </head>
    <body style="background-color:white;height:100%">
        
        <div style ="height: 100%">
            
            <div style="height:50px;background:#C3C3E5;padding:20px">
                <div style="float:left;font-family: Cursif;font-size:24px;color: white"><center>le Reddit Image Scraper</font></center></div>
                <form action="IndexServlet">
                    <center>
                        <input type ="submit" value ="Go" name="submit" style="float:right;min-height:30px;">
                        <input type="text" name ="subreddit" value ="Enter a subreddit." style="float:right;height:30px;width:150px" onfocus="this.value = '';">
                    </center>
                </form>
            </div>
            
            <div style="min-height:5%;padding:10px"> 
                <form action="IndexServlet">
                    <center>
                        <input type="image" src="downvote.png" value ="<" name="submit" style="max-height: 5%">
                        <input type="image"src="upvote.png" value =">" name="submit" style="max-height: 5%">
                    <center>
                </form>
            </div>
            
            
            
            
            
            <div style =max-height:90%><img src="${randomImage.imageUrl}" style="max-width:80%;display: block;margin-left:auto;margin-right:auto"></div>

        </div>
       
    </body>
</html>
