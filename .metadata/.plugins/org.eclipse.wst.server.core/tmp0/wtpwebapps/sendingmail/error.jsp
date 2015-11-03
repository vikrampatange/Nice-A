<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Error</title>
      <link rel="stylesheet" href="css/style.css" type="text/css">
    </head>
    <body>
      <center>
        <div class="error">
          <h2>Error</h2>
            <p>
               Message: <%= request.getAttribute("ErrorMessage") %>    
            </p>
        </div>
      </center>
    </body>
</html>