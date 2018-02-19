<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import="jokes.*"  %>
<%! 
    final int NUM_JOKES=3;
    Joke[] jokeList = new Joke[NUM_JOKES];
    boolean first=true;
 %>
<%
    if (first)
    {
        first = false;
        for (int i=0; i < NUM_JOKES; i++)
            jokeList[i] = new Joke();
    }
    String strIndex = request.getParameter("index");
    if (strIndex != null)
    {
        int index = Integer.parseInt(strIndex);
        Joke joke = jokeList[index];
        joke.setRating(strIndex, pageContext);
     }
%>

<html>
<head><title>My Fun Page</title></head>
<body>

<h3>3 Legged Chickens</h3>
<%
    pageContext.setAttribute("formIndex", 0);
 %>
<%@ include file="/includes/jokeInclude.jsp" %>

<pre>
A man was driving along a rural road one day when he saw a three
legged chicken.  He was amused enough to drive along side it for a
while, as he was driving he noticed the chicken was running 30 mph.
Pretty fast chicken, he thought, I wonder just how fast it can run.
So he sped up and the chicken did too!  They were now moving along
the road at 45 mph!  The man in the car sped up again, to his
surprise the chicken was still running ahead of him at 60 mph!!!
 
Suddenly the chicken turned off the road and ran down a long
driveway leading to a farmhouse.  The man followed the chicken to
the house and saw a man in the yard and dozens of three legged
chickens.  The man in the car called out to the farmer "How did you
get all these three legged chickens?"
 
The farmer replied, "I breed 'em.  Ya see it's me, my wife and my
son living here and we all like to eat the chicken leg.  Since a
chicken only has two legs, I started breeding this three legged
variety so we could all eat our favorite piece."
 
"That's amazing!" said the driver "How do they taste?"
 
"Don't rightly know, can't catch 'em."

</pre>
<hr>
<h3>Knight's Work</h3>
<%
    pageContext.setAttribute("formIndex", 1);
 %>
<%@ include file="/includes/jokeInclude.jsp" %>
<pre>
A knight and his men return to their castle after a long hard day of
fighting.
 
"How are we faring?" asks the king.
 
"Sire," replies the knight, "I have been robbing and pillaging on
your behalf all day, burning the towns of your enemies in the west."
 
"What?!?" shrieks the king. "I don't have any enemies to the west!"
 
"Oh," says the knight. "Well, you do now."


</pre>
<hr>

<h3>Big Bridge</h3>
<%
    pageContext.setAttribute("formIndex", 2);
 %>
<%@ include file="/includes/jokeInclude.jsp" %>
<pre>


One Wish

A man was walking along a California beach when he stumbled across an
old lamp. He picked it up and rubbed it and out popped a genie.  The
genie said  "OK so you released me from the lamp blah blah blah, but
this is the fourth time this week and I'm getting a little sick of
these wishes, So you can forget about three. You only get one wish."

The man sat and thought about it for a while and said, "I've always
wanted to go to Hawaii but I'm too scared to fly and I get very
seasick.  So could you build me a bridge to Hawaii so I can drive
over there?"

The gene laughed a replied, "That's impossible. Think of the
logistics of that. How would the supports ever reach the bottom of
the Pacific?  Think of how much concrete....How much steel!!!! No
think of another wish."

The man agreed and tried to think of a really good wish. He said,
"I've been married and divorced four times. My wives have always said
I don't care and that I'm insensitive. I wish that I could understand
women. To know  what they are thinking when they give me the silent
treatment, To know why they are crying, To know what they want when
they say 'nothing'...."

The gene replies "you want that bridge with two lanes or four?"

</pre>
</body>
</html>