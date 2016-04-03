<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="us.cerv.books.controller.BookController"%>
<%@ page import="us.cerv.books.model.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="us.cerv.books.model.Book"%>
<%@ page import="us.cerv.books.dao.BookDAO"%>
<%@ page import="us.cerv.books.dao.BookDAOImpl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jan and Adi's book store</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
<link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-sm-4">
			<jsp:include page="leftColumn.jsp" flush="true" />
		</div>
		<div class="col-sm-8">
			<ul class="row list-unstyled">
			<%
				BookDAO bookDao = new BookDAOImpl();
				List<Book> bookList1 = (List<Book>) bookDao.findAllBooks();
				Iterator<Book> iterator1 = bookList1.iterator();
				while (iterator1.hasNext()) {
					Book book1 = (Book) iterator1.next();
			%>
			<li class="col-sm-3 text-center book">
				<img src="img/<%= book1.getId()  %>.jpg" class="img-responsive" alt="<%= book1.getBookTitle() %>"/>
				<h2><%= book1.getBookTitle() %></h2>
			</li>
			<%
				}
			%>
			</ul>
		</div>
	</div>
	<%@ include file="_footer.jsp" %>
</div>
</body>
</html>