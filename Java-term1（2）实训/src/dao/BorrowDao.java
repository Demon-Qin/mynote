package dao;

import java.util.List;

import entity.Book;
import entity.Borrow;


public interface BorrowDao {
	 int add(Borrow borrow);
	  List<Borrow>getBorrow(Borrow borrow);
	  List<Borrow>getById(String id);
	  int delete(Borrow borrow);
}
