<%@ taglib prefix="mc" uri="http://wccnet.edu/clem/mortgageTags" %>


<html>
<head>
<title>Mortgage Calculations</title>
</head>
<body>

<h1>Mortgage Calculations</h1>
<hr>
<mc:mortgage_setparms />
Principal: ${principal}
<br>Interest: ${interest}
<br>Months: ${months}
<br>Monthly_Payment: ${payment}

<table border="4">
    <tr><th>Month #</th><th>Principal</th><th>Interest</th></tr>

    <mc:mortgage_calc >
        <tr><td>${month_num}</td><td>${curr_principal}</td><td>${monthly_interest}</td></tr>
    </mc:mortgage_calc>
</table>


<hr>
<mc:mortgage_setparms principal="500" interest="5" payment="50" months="20"/>
Principal: ${principal}
<br>Interest: ${interest}
<br>Months: ${months}
<br>Monthly_Payment: ${payment}

<table border="4">
    <tr><th>Month #</th><th>Principal</th><th>Interest</th></tr>

    <mc:mortgage_calc >
        <tr><td>${month_num}</td><td>${curr_principal}</td><td>${monthly_interest}</td></tr>
    </mc:mortgage_calc>
</table>

</body></html>