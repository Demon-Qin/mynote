package dao;

import java.util.List;

import entity.Book;

public interface BookDao {
	int add(Book book);
	  List<Book>getBook(String bookid);
	  List<Book>getByName(String name);
	  List<Book>getById(String id);
	  List<Book>getByA(String seat);
	  /*List<Book>getByB(String seat);
	  List<Book>getByC(String seat);*/
	int delete(Book book);
	int bupdate(Book book);
	int rupdate(Book book);
	List<Book> getAll();
	
}
