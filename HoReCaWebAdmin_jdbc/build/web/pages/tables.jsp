<%@page import="java.util.ArrayList"%>
<%@page import="beans.ItemCategory"%>
<%@page import="beans.PlaceCategory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="../WEB-INF/jspf/left_menu.jspf" %>

<%request.setCharacterEncoding("UTF-8");

    String table_name = "";

    try {
        table_name = String.valueOf(request.getParameter("table_name"));
    } catch (Exception ex) {
        ex.printStackTrace();
    }
%>


<% if (table_name.equals("ItemCategory")) {%> 

<jsp:useBean id="itemCategoryList" class="beans.ItemCategoryList" scope="page"/>

<div class="t_list">
    <table BORDER>

        <caption>Item categories</caption>
        <tr>
            <th>id</th>
            <th>name</th>
        </tr>

        <%
            ArrayList<ItemCategory> list = itemCategoryList.getItemCategoryList();
            session.setAttribute("currentList", list);
            for (ItemCategory entity : list) {
        %>
        <tr>
            <td><%=entity.getId()%></td>
            <td><%=entity.getName()%></td>
        </tr>
        <%}%>
    </table>
</div>

<%} else if (table_name.equals("PlaceCategory")) {%>

<jsp:useBean id="placeCategoryList" class="beans.PlaceCategoryList" scope="page"/>

<div class="t_list">
    <table BORDER>

        <caption>Place categories</caption>
        <tr>
            <th>id</th>
            <th>name</th>
        </tr>

        <%
            ArrayList<PlaceCategory> list = placeCategoryList.getPlaceCategoryList();
            session.setAttribute("currentList", list);
            for (PlaceCategory entity : list) {
        %>
        <tr>
            <td><%=entity.getId()%></td>
            <td><%=entity.getName()%></td>
        </tr>
        <%}%>
    </table>
</div>

<%}%>