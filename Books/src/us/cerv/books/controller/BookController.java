package us.cerv.books.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import us.cerv.books.dao.BookDAO;
import us.cerv.books.dao.BookDAOImpl;
import us.cerv.books.model.Book;
import us.cerv.books.model.Category;

public class BookController extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		BookDAO bookDao = new BookDAOImpl();
		// calling DAO method to retrieve bookList from Database
		List<Category> categoryList = bookDao.findAllCategories();
		ServletContext context = config.getServletContext();
		context.setAttribute("categoryList", categoryList);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String base = "/";
		String url = base + "Index.jsp";
		String action = request.getParameter("action");
		String category = request.getParameter("category");
		String categoryId = request.getParameter("categoryId");
		String keyWord = request.getParameter("keyWord");
		if (action != null) {
			switch (action) {
			case "allBooks":
				findAllBooks(request, response);
				url = base + "listOfBooks.jsp";
				break;
			case "category":
				findAllCategoryBooks(request, response, categoryId);
				url = base + "category.jsp?category=" + category;
				break;
			case "search":
				searchBooks(request, response, keyWord);
				url = base + "searchResult.jsp";
				break;

			}
		}
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
		requestDispatcher.forward(request, response);
	}
	private void findAllBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			BookDAO bookDao = new BookDAOImpl();
			List<Book> bookList = bookDao.findAllBooks();
			request.setAttribute("bookList", bookList);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	private void findAllCategoryBooks(HttpServletRequest request, HttpServletResponse response, String categoryId) throws ServletException, IOException {
		try {
			BookDAO bookDao = new BookDAOImpl();
			Integer catId = 1;
			try{
			catId = Integer.parseInt(categoryId);
			} catch (Exception e) {
				
			}
			List<Book> bookList = bookDao.findAllBooks(catId);
			request.setAttribute("bookList", bookList);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	private void searchBooks(HttpServletRequest request, HttpServletResponse response, String keyWord) throws ServletException, IOException {
		try {
			BookDAO bookDao = new BookDAOImpl();
			List<Book> bookList = bookDao.searchBooksByKeyword(keyWord);

			request.setAttribute("bookList", bookList);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
