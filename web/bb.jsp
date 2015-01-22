<%-- 
    Document   : bb
    Created on : 27 mars 2014, 19:53:36
    Author     : Balti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%@ page import="org.apache.commons.fileupload.*, java.util.List, java.io.File, java.util.Iterator" %>
<%
boolean isMultipart = FileUpload.isMultipartContent(request);
if(!isMultipart){
request.setAttribute("msg", "Request was not multipart!");
request.getRequestDispatcher("msg.jsp").forward(request, response);
return;
}

DiskFileUpload upload = new DiskFileUpload();
List items = upload.parseRequest(request);
Iterator itr = items.iterator();

while(itr.hasNext()){
FileItem item = (FileItem) itr.next();
if(item.isFormField()) {
String fieldName = item.getFieldName();
if(fieldName.equals("name"))
request.setAttribute("msg", "Thank You: " + item.getString());
} else {
File fullFile = new File(item.getName());
File savedFile = new File(getServletContext().getRealPath("/")+"/tmp/", fullFile.getName());
item.write(savedFile);
}
}

request.getRequestDispatcher("msg.jsp").forward(request, response);
%>
</html>
