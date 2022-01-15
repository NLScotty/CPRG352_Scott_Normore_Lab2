<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <form action="arithmetic" method="post">
            <label for="nnumber1">First Number:</label>
            <input type="text" name="number1" id="number1" value="${input1}">
            <label for="number2">Second Number:</label>
            <input type="text" name="number2" id="number2" value="${input2}">
            <button type="submit" name="operation" value="add">+</button>
            <button type="submit" name="operation" value="subtract">-</button>
            <button type="submit" name="operation" value="multiply">*</button>
            <button type="submit" name="operation" value="divide">%</button>
        </form>
        <p>Result: ${message}</p>
        <a href="http://localhost:8080/Calculators/age">Age Calculator</a>
    </body>
</html>
