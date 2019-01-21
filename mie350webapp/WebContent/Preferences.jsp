<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<style>
    body { 
        background-image: url(' background.jpg');
        font-family: Arial, Helvetica, sans-serif;
        min-height: 100%;
        background-position: center;
        background-repeat: no-repeat;
        background-size: 100%      
            }
 div.topnav {
             overflow: hidden;
            background-color: #00000093;
            
           
        }

    div.topnav a {
        float: left;
        color: #f2f2f2;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
        font-size: 23px;
         }

div.topnav a:hover {
    background-color: #ffffff67;
    color: #474747;
        }
     
   




input[type=text], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #474747;
    box-sizing: border-box;
}

input[type=submit] {
    width: 100%;
    background-color: #000000c5;;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #96918e;
}

input[type=submit]:hover {
    background-color: #96918e;
}

div.forminput {
    border-radius: 5px;
    padding: 20px;
}




}
.modal-content {
    background-color: #fefefe91;
    margin: 3% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
    border: 1px solid #888;
    height:60%;
    width: 40%; /* Could be more or less, depending on screen size */
    padding: 16px;
}

}


</style>
<body>
        <div class="topnav">
				<a class="fa fa-home" href="Homepage.jsp">Home</a>
		</div>
              
    <div style="padding-right:16px">
   
    <script>
            $(function() {
                $('input[name=dob]').datepicker();
            });
        </script>
   
   
    <div class= "forminput">
    <form class="modal-content " method="post" action='SCreateAccountController' name="frmAddUser">
    <h3>long URL:</br>
    </h3>

    <h3>short URL:</h3>
   
    
 
    

    </form>

</body>
</html>