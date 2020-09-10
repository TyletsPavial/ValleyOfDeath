<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Who is the richest?</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
<%ArrayList<String> list = (ArrayList<String>) request.getAttribute("data"); %>
<script>
    var rich =<%="\"" + list.get(0) + "\""%>;
    var sum = <%=list.get(1)%>;
    function richButClick(){
        $('#rich').val(rich);
        alert(rich);
    }
    function sumButClick(){
        $('#sum').val(sum);
        alert(sum);
    }
</script>
<p><input readonly type="text" id="rich">
    <button class="rich" onclick="richButClick()">Get the richest user</button></p>
<p><input readonly type="text" id="sum">
    <button class="sum" onclick="sumButClick()" >Get the all accounts sum</button></p>
</body>
</html>
