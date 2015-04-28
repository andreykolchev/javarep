<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>HoReCa admin panel</title>
        <link href="css/style_index.css" rel="stylesheet" type="text/css">
    </head>

    <body>
        <div class="main">

            <div class="content">
                <p class="title"><span class="text"><img src="images/logo.png" width="100" height="100" hspace="10" vspace="10" align="middle"></span></p>
                <p class="title">HoReCa web admin (demo)</p>
               
                <!--<p>&nbsp;</p>-->

            </div>

            <div class="login_div">
                <p class="title">Enter your name:</p>
                <form class="login_form" name="username" action="pages/main.jsp" method="POST">
                    user: <input type="text" name="username" value="" size="20" />
                    <input type="submit" value="enter" />
                </form>

            </div>

            <div class="footer">
                dev: Crazy Climbers 2015
                <p class="text">Administrator <a href="mailto:support@crazy.com">support@crazy.com</a></p>
            </div>
        </div>


    </body>
</html>
