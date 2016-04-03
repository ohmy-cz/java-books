package us.cerv.books.dao;

import java.util.List;

import us.cerv.books.model.Book;
import us.cerv.books.model.Category;

public interface BookDAO {
	public List<Book>findAllBooks();
	public List<Book>findAllBooks(Integer categoryId);
	public List<Book>searchBooksByKeyword(String keyWord);
	public List<Category>findAllCategories();
	public void insert(Book book);
	public void update(Book book);
	public void delete(Long bookId);
}