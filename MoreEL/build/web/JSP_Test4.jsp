<html><body>     
       <h2> Expression Language HashMap examples</h2>
             
              
       <h3>Other ways to access HashMaps</h3>
       quotes.albert3.quote = ${quotes.albert3.quote} 

       <br>Doesn't work: Commented out code<!-- quotes.7.quote = \${quotes.7.quote} -->

       <br>Doesn't work: quotes[albert3].quote = ${quotes[albert3].quote} 

       <br>quotes["albert3"].quote = ${quotes["albert3"].quote} 

       <br>quotes["7"].quote = ${quotes["7"].quote} 
       
       <h2> Best:</h2>
        quotes[best].quote = ${quotes[best].quote} 
       <br>author: ${quotes[best].author}
       
    </body></html>