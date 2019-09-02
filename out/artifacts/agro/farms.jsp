<!DOCTYPE html>
<%@ page import="data.Farm" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Farms</title>
</head>
<body>
<h2>Список хозяйств</h2>
<% List<Farm> farmList = ((List<Farm>) request.getAttribute("farms")); %>
<table border="2">
    <%
        out.println("<table border=2>");
        out.println("<tr>");
        out.println("<td>Название</td>");
        out.println("<td>Агроном</td>");
        out.println("<td>Координата X</td>");
        out.println("<td>Координата Y</td>");
        out.println("</tr>");
        for ( Farm farm : farmList ) {
            out.println("<tr>");
            out.println("<td>" + farm.getName() + "</td>");
            out.println("<td>" + farm.getOwner() + "</td>");
            out.println("<td>" + farm.getxCoord() + "</td>");
            out.println("<td>" + farm.getyCoord() + "</td>");
            out.println(String.format("<td><form action=\"farms_delete\" method=\"get\">\n" +
                    "            <input type=\"hidden\" name=\"id\" value=\"%s\">\n" +
                    "            <input type=\"submit\" value=\"Удалить\">\n" +
                    "        </form></td>", farm.getId()));
            out.println("</tr>");
        }
    %>
</table>
<button>Add</button>
</body>
</html>
