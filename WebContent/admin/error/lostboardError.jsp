<%@ page contentType="text/html; charset=UTF-8"%>
<% String msg= (String)request.getAttribute("err"); %>
<script>
alert(<%=msg %>);
history.back();
</script>