<%@ page import="us.cerv.books.controller.BookController"%>
<%@ page import="us.cerv.books.model.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>

<div class="menu well">
	<h3>Find your book</h3>
	<form class="search" method="post">
		<span class="input-group">
			<input type="hidden" name="action" value="search" />
			<input id="text" class="form-control" type="text" name="keyWord" value="<%= request.getParameter("keyWord") != null ? request.getParameter("keyWord") : "" %>" />
			<span class="input-group-btn">
				<button id="submit" type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span> Search</button>
			</span>
		</span>
	</form>
	<h3>Categories</h3>
	<ul class="list-unstyled">
		<%
			String cid = request.getParameter("categoryId");
			List<Category> categoryList1 = (List<Category>) application.getAttribute("categoryList");
			Iterator<Category> iterator1 = categoryList1.iterator();
			while (iterator1.hasNext()) {
				Category category1 = (Category) iterator1.next();
		%>
		<li><a class="btn btn-default btn-xs btn-block <%= (cid != null && category1.getId() == Integer.parseInt(cid) ? "active" : "") %>"
			href="?action=category&categoryId=<%=category1.getId()%>&category=<%=category1.getCategoryDescription()%>"><%=category1.getCategoryDescription()%></a>
		</li>
		<%
			}
		%>
	</ul>
</div>