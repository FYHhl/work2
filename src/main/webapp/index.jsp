<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<button id="btn">按钮</button>
</body>
</html>
<script type="text/javascript" src="jquery-3.4.1.min.js"></script>
<script>
    var btn=document.getElementById("btn");
    btn.onclick=function (){
        $.ajax({
            url:"teachers",
            type:"GET",
            success:function (data) {
                window.location.href="teacher.jsp";
            }
        })
    }
</script>