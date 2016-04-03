/**
 * 
 */
package us.cerv.helloworld;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import us.cerv.books.dao.BookDAO;
import us.cerv.books.dao.BookDAOImpl;
import us.cerv.books.model.Book;

public class HelloWorld extends HttpServlet {
	private static BookDAO bookDao = new BookDAOImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType("text/html");
			PrintWriter printWriter = response.getWriter();
			List<Book> books = bookDao.findAllBooks();
			for (Book book : books) {
				printWriter.println(book.getBookTitle());
			}
			printWriter.println("<h2>");
			printWriter.println("Hello World");
			printWriter.println("</h2>");
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
}