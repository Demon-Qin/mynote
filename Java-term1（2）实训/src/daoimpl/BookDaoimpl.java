package daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.BookDao;
import dao.DBUtils;
import entity.Book;
import entity.User;


public class BookDaoimpl implements BookDao{
	@Override
	public int delete(Book book) {
		// TODO Auto-generated method stub
		 int code=0;
	        String sql="delete from books where id=? ";
	        code=DBUtils.update(sql,book.getId());
		return code;
	}

	@Override
	public int add(Book book) {
		int code = 0;
		String sql = "insert into books (id,name,author,price,num) values(?,?,?,?,?)";
        code = DBUtils.update(sql, book.getId(),
        		                 book.getName(),
        		                 book.getAuthor(),       		                 
        		                 book.getPrice(),
        		                 book.getNum());
		System.out.println(code);
		return code;
	}

	

	@Override
	public List<Book> getByName(String name) {
		// TODO Auto-generated method stub
		String sql="select*from books where name=?";
        List<Book> bookList= new ArrayList<>();
      
		List<Map<String,Object>> mapList=DBUtils.query(sql,new String(name));
        for (Map<String,Object>map:mapList){
            Book book = new Book();
            book.setId((String)(map.get("id")));
            book.setName((String)(map.get("name")));
            book.setAuthor((String)(map.get("author")));	             
            book.setNum((Integer)(map.get("num")));
             book.setPrice((Double)(map.get("price")));
            bookList.add(book);
        }
        return bookList;
    }
	public List<Book> getById(String id) {
		// TODO Auto-generated method stub
		String sql="select*from books where id=?";
        List<Book> bookList= new ArrayList<>();
      
		List<Map<String,Object>> mapList=DBUtils.query(sql,new String(id));
        for (Map<String,Object>map:mapList){
            Book book = new Book();
            book.setId((String)(map.get("id")));
            book.setName((String)(map.get("name")));
            book.setAuthor((String)(map.get("author")));	             
            book.setNum((Integer)(map.get("num")));
             book.setPrice((Double)(map.get("price")));
            bookList.add(book);
        }
        return bookList;
    }
	
	public int bupdate(Book book) {
		// TODO Auto-generated method stub
				 int code=0;
			        String sql="Update books set num=num-1 where id=?";
			        code=DBUtils.update(sql,book.getId());
				return code;
		
	}
	public int rupdate(Book book) {
		// TODO Auto-generated method stub
				 int code=0;
			        String sql="Update books set num=num+1 where id=?";
			        code=DBUtils.update(sql,book.getId());
				return code;
		
	}

	@Override
	public  List<Book>getBook(String bookid) {		
			// TODO Auto-generated method stub
			String sql="select * from books where id=? ";
			List<Book>booklist=new ArrayList<Book>();
			List<Map<String, Object>>maplist=DBUtils.query(sql,bookid);
			for(Map<String, Object> map:maplist) {
				Book bk=new Book();
				bk.setId((String)(map.get("id")));
				bk.setName((String)(map.get("name")));
				bk.setAuthor((String)(map.get("author")));
				bk.setNum((Integer)(map.get("num")));
				bk.setPrice((Double)(map.get("price")));
				
				
				booklist.add(bk);
				
			}
			return booklist;
	}
	@Override
	public  List<Book>getByA(String seat) {		
			// TODO Auto-generated method stub
			String sql="select * from books where seat=? ";
			List<Book>booklist=new ArrayList<Book>();
			List<Map<String, Object>>maplist=DBUtils.query(sql,seat);
			for(Map<String, Object> map:maplist) {
				Book bk=new Book();
				bk.setId((String)(map.get("id")));
				bk.setName((String)(map.get("name")));
				bk.setAuthor((String)(map.get("author")));
				bk.setNum((Integer)(map.get("num")));
				bk.setPrice((Double)(map.get("price")));
				
				
				booklist.add(bk);
				
			}
			return booklist;
	}
	/*public  List<Book>getByB(String seat) {		
		// TODO Auto-generated method stub
		String sql="select * from books where seat=B ";
		List<Book>booklist=new ArrayList<Book>();
		List<Map<String, Object>>maplist=DBUtils.query(sql,seat);
		for(Map<String, Object> map:maplist) {
			Book bk=new Book();
			bk.setId((String)(map.get("id")));
			bk.setName((String)(map.get("name")));
			bk.setAuthor((String)(map.get("author")));
			bk.setNum((Integer)(map.get("num")));
			bk.setPrice((Double)(map.get("price")));
			
			
			booklist.add(bk);
			
		}
		return booklist;
}
	public  List<Book>getByC(String seat) {		
		// TODO Auto-generated method stub
		String sql="select * from books where seat=C ";
		List<Book>booklist=new ArrayList<Book>();
		List<Map<String, Object>>maplist=DBUtils.query(sql,seat);
		for(Map<String, Object> map:maplist) {
			Book bk=new Book();
			bk.setId((String)(map.get("id")));
			bk.setName((String)(map.get("name")));
			bk.setAuthor((String)(map.get("author")));
			bk.setNum((Integer)(map.get("num")));
			bk.setPrice((Double)(map.get("price")));
			
			
			booklist.add(bk);
			
		}
		return booklist;
}*/
	public List<Book> getAll() {
		// TODO Auto-generated method stub
		String sql="select * from books ";
		List<Book> booklist= new ArrayList<>();
		List<Map<String,Object>> mapList=DBUtils.query(sql);
		for (Map<String,Object>map:mapList){
            Book book =new Book();
            book.setId((String)(map.get("id")));
			book.setName((String)(map.get("name")));
			book.setAuthor((String)(map.get("author")));
			book.setNum((Integer)(map.get("num")));
			book.setPrice((Double)(map.get("price")));
			
			
			booklist.add(book);
			
		}
		return booklist;
}
}
