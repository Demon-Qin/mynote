package dao;

import java.util.List;

import entity.Manage;


public interface ManageDao {
  int add(Manage manage);
  List<Manage>getManage(Manage manage);
  
}