package daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.BorrowDao;
import dao.DBUtils;
import entity.Book;
import entity.Borrow;
import entity.User;


public class BorrowDaoimpl implements BorrowDao{
	@Override
	public List<Borrow> getById(String id) {
		// TODO Auto-generated method stub
		String sql="select*from pmanage where id=?";
        List<Borrow> borrowList= new ArrayList<>();
      
		List<Map<String,Object>> mapList=DBUtils.query(sql,new String(id));
        for (Map<String,Object>map:mapList){
            Borrow borrow=new Borrow();
            borrow.setId((String)(map.get("id")));
            borrow.setBookid((String)(map.get("bookid")));
            borrow.setBookname((String)(map.get("bookname")));
            borrow.setBookdate((String) (map.get("bookdate")));
           
            borrowList.add(borrow);
        }
        return borrowList;
    }

	@Override
	public int add(Borrow borrow) {
		// TODO Auto-generated method stub
		int code = 0;
		String sql = "insert into pmanage (id,bookid,bookname,bookdate) values(?,?,?,?)";

		code = DBUtils.update(sql,borrow.getId(),borrow.getBookid(),borrow.getBookname(),borrow.getBookdate());

		return code;
	}
	

	@Override
	public List<Borrow> getBorrow(Borrow borrow) {
		
		return null;
	}

	@Override
	public int delete(Borrow borrow) {
		// TODO Auto-generated method stub
		 int code=0;
	        String sql="delete from pmanage where bookid=? ";
	        code=DBUtils.update(sql,borrow.getBookid());
		return code;
	}
	}


