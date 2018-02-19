<html><body>
  <form action=Expressions.jsp>
      <br>x: <input type="text" name="x" value="${param.x}">
      <br>y: <input type="text" name="y" value="${param.y}">
      <br>z: <input type="text" name="z" value="${param.z}">
      <br><input type="submit">
  </form>

<hr>
<p>
    <br>x + y is ${param.x + param.y}
    <br>x - y is ${param.x - param.y}
    <br>x * y is ${param.x * param.y}
    <br>x / y is ${param.x / param.y}
    <br>x % y is ${param.x % param.y}
    
    <p>x == y is ${param.x == param.y}
    <br>x != y is ${param.x != param.y}
    <br>x < y is ${param.x < param.y}
    <br>x <= y is ${param.x <= param.y}
    <br>x > y is ${param.x > param.y}
    <br>x >= y is ${param.x >= param.y}
    
    <p>
    <br>x < z && x > y is ${param.x < param.z && param.x > param.y}
    <br>x < z || x > y is ${param.x < param.z || param.x > param.y}
    <br>(x < z) || (x > y) is ${(param.x < param.z) || (param.x > param.y)} 
    <br>!(x < z)  is ${!(param.x < param.z) }
    <p>
    <br>x == 1 is ${param.x == 1}
    <br>x == '1' is ${param.x == '1'}
    <br>x == '1x' is ${param.x == '1x'}

        
</body></html>