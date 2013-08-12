<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login Page</title>
    <link type="text/css" rel="stylesheet" href="resources/css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="resources/css/loginStyle.css">
</head>
<body onload='document.f.j_username.focus();'>

<div class="navbar">
    <div class="navbar-inner">
        <a class="brand" href="#">Login with Username and Password </a>

    </div>
</div>


<h3 class="headerTitle"><img class="appendImg" src="resources/img/healthcare-website-design-13-300x288.jpg"> Welcome! Please input your Login and Password!</h3>
<div class='loginBar'>
 <img class="logo" src="/resources/img/Health-care-shield-icon.png" />
<form class='loginForm' name='f' action="j_spring_security_check" method='POST'>


          <div class="formRow">
            <div>Username/SSN:</br>
            <input type='text' name='j_username' value=''></div>

            <div>
            Password:</br>
            <input type='password' name='j_password' /></div>

            <div class=>
            <input class='btn btn-small' name="submit" type="submit"
                                   value="Login" />
            </div>


        </div>


</form>
</div>


</body>
</html>

