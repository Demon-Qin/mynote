package dao;

import java.util.List;

import entity.Book;
import entity.User;

public interface UserDao {
  int add(User user);
  List<User>getUser(User user);
  List<User>getById(String id);
  List<User>getAll();
  int bupdate(User user);
  int rupdate(User user);
  int delete(User user);
  int update(User user);
}

