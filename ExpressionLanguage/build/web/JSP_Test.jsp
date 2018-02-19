<html><body>
<h1>${title}</h1>

<h2>Mayor's name=${bob.name}</h2>
<h2>Mayor's age= ${bob.age}</h2>


<h2>state name = ${state.name}</h2>
<h3>Population=${state.population}</h3>

<table border="4">
    <tr><th></th><th>Capital</th><th>Largest City</th></tr>
    
    <tr><th>Name</th><td>${state.capital.name}</td><td>${state.largestCity.name}</td></tr>
    <tr><th>Population</th><td>${state.capital.population}</td><td>${state.largestCity.population}</td></tr>
    <tr><th>Mayor Name</th><td>${state.capital.mayor.name}</td><td>${state.largestCity.mayor.name}</td></tr>
    <tr><th>Mayor Age</th><td>${state.capital.mayor.age}</td><td>${state.largestCity.mayor.age}</td></tr>
    
</table>
</body></html>