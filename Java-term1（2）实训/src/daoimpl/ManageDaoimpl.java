package daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.DBUtils;
import dao.ManageDao;
import dao.UserDao;
import entity.Manage;


public class ManageDaoimpl implements ManageDao{

	public int add(Manage manage) {
		// TODO Auto-generated method stub
		int code = 0;
		String sql = "insert into manages (id,password) values(?,?)";

		code = DBUtils.update(sql,manage.getId(),manage.getPassword());

		return code;
	}

	@Override
	public List<Manage> getManage(Manage manage) {
		// TODO Auto-generated method stub
		String sql="select * from manages where id=? and password=?";
		List<Manage>managelist=new ArrayList<Manage>();
		List<Map<String, Object>>maplist=DBUtils.query(sql,manage.getId(),manage.getPassword());
		for(Map<String, Object> map:maplist) {
			Manage us=new Manage();
			us.setId((String)(map.get("id")));
			us.setPassword((String)(map.get("password")));
			
			managelist.add(us);
		}
		
		
		return managelist;
	}
}