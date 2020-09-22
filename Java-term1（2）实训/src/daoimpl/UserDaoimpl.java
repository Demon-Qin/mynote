package daoimpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.DBUtils;
import dao.JDBCUtil;
import dao.UserDao;
import entity.Book;
import entity.User;

public class UserDaoimpl implements UserDao{

	@Override
	public int add(User user) {
		// TODO Auto-generated method stub
		int code = 0;
		String sql = "insert into people (id,name,booknum,bookstate,deposit) values(?,?,?,?,?)";

		code = DBUtils.update(sql,user.getId(),user.getName(),user.getBooknum(),user.getBookstate(),user.getDeposit());

		return code;
	}

	@Override
	public List<User> getUser(User user) {
		// TODO Auto-generated method stub
		String sql="select * from people where id=? and name=?";
		List<User>userlist=new ArrayList<User>();
		List<Map<String, Object>>maplist=DBUtils.query(sql,user.getId(),user.getName());
		for(Map<String, Object> map:maplist) {
			User us=new User();
			us.setId((String)(map.get("id")));
			us.setName((String)(map.get("name")));
			us.setBooknum(0);
			us.setBookstate(null);
			
			userlist.add(us);
		}
		
		
		return userlist;
	}
	@Override
	public List<User> getById(String id) {
		// TODO Auto-generated method stub
		String sql="select*from people where id=?";
        List<User> userList= new ArrayList<>();
      
		List<Map<String,Object>> mapList=DBUtils.query(sql,new String(id));
        for (Map<String,Object>map:mapList){
            User user=new User();
            user.setId((String)(map.get("id")));  
            user.setName((String)(map.get("name")));
            user.setBooknum((Integer) (map.get("booknum")));
            user.setBookstate((String)(map.get("bookstste")));
            user.setDeposit((Double)(map.get("deposit")));
            userList.add(user);
        }
        return userList;
    }
	
	public int bupdate(User user) {
		// TODO Auto-generated method stub
				 int code=0;
			        String sql="Update people set booknum=booknum+1 where id=?";
			        code=DBUtils.update(sql,user.getId());
				return code;
}
	public int rupdate(User user) {
		// TODO Auto-generated method stub
				 int code=0;
			        String sql="Update people set booknum=booknum-1 where id=?";
			        code=DBUtils.update(sql,user.getId());
				return code;
}
	public int update(User user) {
		// TODO Auto-generated method stub
	        JDBCUtil jdbcUtil= new JDBCUtil();
			String sql="update item set name=?,prices=?,count=?,note=? where id=?";
			Object[] params={user.getId(),user.getName(),user.getBooknum(),user.getBookstate(),user.getDeposit()};
			int line=0;
			try 
			{
				line = jdbcUtil.executeUpdate(sql,params);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			return line;
		}
	@Override
	public int delete(User user) {
		// TODO Auto-generated method stub
				 int code=0;
			        String sql="delete from people where id=? ";
			        code=DBUtils.update(sql,user.getId());
				return code;
	}
	public List<User> getAll() {
		// TODO Auto-generated method stub
		String sql="select * from people ";
		List<User> userList= new ArrayList<>();
		List<Map<String,Object>> mapList=DBUtils.query(sql);
		for (Map<String,Object>map:mapList){
            User user=new User();
            user.setId((String)(map.get("id")));  
            user.setName((String)(map.get("name")));
            user.setBooknum((Integer) (map.get("booknum")));
            user.setBookstate((String)(map.get("bookstste")));
            user.setDeposit((Double)(map.get("deposit")));
            userList.add(user);
        }
        return userList;
		
	}
}