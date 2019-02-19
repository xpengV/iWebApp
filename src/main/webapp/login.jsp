<%--
  Created by IntelliJ IDEA.
  User: xiaopeng
  Date: 2019/2/14
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script type="text/javascript">
        var HttpRequest = null;

        function ajaxInitEngine() {
            if (window.XMLHttpRequest) {
                HttpRequest = new XMLHttpRequest();
            } else if (window.ActiveXObject) { // IE浏览器
                try {
                    HttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e) {
                    try {
                        HttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
                    } catch (e) {
                        alert('初始化Ajax引擎失败！');
                    }
                }
            }
        }

        function send() {
            alert("click")
            ajaxInitEngine();
            HttpRequest.open("GET", "register.do", true);
            HttpRequest.onreadystatechange = function () {
                alert(1);
                if (HttpRequest.readyState == 4) {
                    if (HttpRequest.status == 200) {
                        var xmlDoc = HttpRequest.responseXML;
                        doxml(xmlDoc);
                    }
                }
            }
            HttpRequest.send(null);
        }

    </script>
</head>
<body>
login.jsp<br/>
${requestScope.info }<br/>
${sessionScope.messge }
<button onclick="send()">发送请求
</button>
</body>
</html>
