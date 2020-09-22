package dao;



/**使用PreparedStatement使Statement更加安全**/

import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JDBCUtil
{
	/**数据库链接必要属性：类型、地址、端口、用户名、密码、库名**/
	private static String sql;
	private static String address;
	private static String port;
	private static String username;
	private static String password;
	private static String dbname;
	/**创建唯一属性保存最总url地址**/
	private static String url;
	/**JDBC操作数据库所需对象**/
	private static Connection connection=null;	//链接对象
	private static PreparedStatement stmt=null;	//操作数据库的对象
	private static ResultSet rs=null;			//结果保存对象
	/**自身对象确保唯一**/
	private static JDBCUtil jdbcUtil= null;
	
	/********************************************************************************/
	
	public static synchronized JDBCUtil getInitJDBCUtil()
	{	
		configure("mysql","127.0.0.1","3306","root","2246260","myjavadb");
		/**确保JDBCUtil在主方法中不使用new**/
		if(jdbcUtil==null)
		{
		  	jdbcUtil = new JDBCUtil();
		}
		return jdbcUtil;
	}
	
	static
	{
		/**确保驱动不被多次创建**/
		/**加载驱动**/
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	/**配置数据库的链接信息**/
	private static void configure(String sql, String address, String port, String username, String password, String dbname)
	{
		/**这里使用JDBCUtil而不是使用this是因为变量是静态变量，在这个类中具有唯一性**/
		JDBCUtil.sql = sql;
		JDBCUtil.address = address;
		JDBCUtil.port = port;
		JDBCUtil.username = username;
		JDBCUtil.password = password;
		JDBCUtil.dbname = dbname;
		
		JDBCUtil.url="jdbc:"+JDBCUtil.sql+"://"+JDBCUtil.address+":"+JDBCUtil.port+"/"+JDBCUtil.dbname;
	}
	
	/**获取数据库链接**/
	public Connection getConnection()
	{
		try
		{
			connection=DriverManager.getConnection(JDBCUtil.url,JDBCUtil.username,JDBCUtil.password);
		}
		catch (SQLException e) 
		{
			System.err.println("数据库连接失败，检查密码用户名等填写问题");
			//e.printStackTrace();
		}
		return connection;
	}
	
	/********************************************************************************/
	/**执行操作数据库的方法**/
	/********************************************************************************/
	public int executeUpdate(String sql) throws Exception
	{
		int affectedLine=0;//受影响的行数
		/**建立数据库连接**/
		connection = getConnection();
		/**操作数据库对象**/

		stmt=connection.prepareStatement(sql);	//准备执行语句
		affectedLine = stmt.executeUpdate();	//执行语句

		closeAll();
		return affectedLine;
	}
	
	public int executeUpdate(String sql,Object[] params) throws Exception
	{
		int affectedLine=0;//受影响的行数
		/**建立数据库连接**/
		connection = getConnection();
		/**操作数据库对象**/
		stmt=connection.prepareStatement(sql);	//准备执行语句
		for(int i=0;i<params.length;i++)
		{
			/**用来给执行语句中的?'问号'赋值**/
			stmt.setObject(i+1,params[i]);
		}
		affectedLine = stmt.executeUpdate();	//执行语句
		closeAll();
		return affectedLine;
	}
	
	/********************************************************************************/
	/**
	 * 查询原理：	执行executeQuery->调用executeQueryRS获取结果集
	 * 			executeQuery方法把结果集分类整理放入顺序表中
	 */
	/********************************************************************************/
	private ResultSet executeQueryRS(String sql,Object[] params)
	{
		/**建立数据库连接**/
		connection = getConnection();
		try
		{
			stmt=connection.prepareStatement(sql);	//准备执行语句
			for(int i=0;i<params.length;i++)
			{
				/**用来给执行语句中的?'问号'赋值**/
				stmt.setObject(i+1,params[i]);
			}
			rs=stmt.executeQuery();	//执行语句
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return rs;	
	}
	
	/**mysql查询方法(不带?号参数)**/
	public List<HashMap> executeQuery(String sql)
	{
		Object temp[] = {};
		ResultSet tempRS= executeQueryRS(sql,temp);
		/**ResultSetMetaData结果集原数据，用于获取关于ResultSet列的名和值**/
		ResultSetMetaData rsmd = null;
		int columnCount = 0;
		try 
		{
			rsmd=tempRS.getMetaData();			//获取原数据
			columnCount=rsmd.getColumnCount();	//取结果集列数
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		/**新建一个顺序表，每一条记录都作为一个HashMap保存在顺序表里面**/
		List<HashMap> list=new ArrayList<HashMap>();
		try 
		{
			//对结果集进行遍历
			while(tempRS.next())
			{
				/**新建一个HashMap每一条记录都保存在一个HashMap里面**/
				HashMap<String,Object> map=new HashMap<String,Object>();
				for(int i=1;i<=columnCount;i++)
				{
					map.put(rsmd.getColumnLabel(i),rs.getObject(i));		//获取列名
				}
				list.add(map);//将HashMap放入顺序表list中
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeAll();
		}
		return list;	//返回顺序表
	}
	
	/**mysql查询方法(带?号参数)**/
	public List<HashMap> executeQuery(String sql,Object[] params)
	{
		ResultSet tempRS= executeQueryRS(sql,params);
		/**ResultSetMetaData结果集原数据，用于获取关于ResultSet列的名和值**/
		ResultSetMetaData rsmd = null;
		int columnCount = 0;
		try 
		{
			rsmd=tempRS.getMetaData();			//获取原数据
			columnCount=rsmd.getColumnCount();	//取结果集列数
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		/**新建一个顺序表，每一条记录都作为一个HashMap保存在顺序表里面**/
		List<HashMap> list=new ArrayList<HashMap>();
		try 
		{
			//对结果集进行遍历
			while(tempRS.next())
			{
				/**新建一个HashMap每一条记录都保存在一个HashMap里面**/
				HashMap<String,Object> map=new HashMap<String,Object>();
				for(int i=1;i<=columnCount;i++)
				{
					map.put(rsmd.getColumnLabel(i),rs.getObject(i));		//获取列名
				}
				list.add(map);//将HashMap放入顺序表list中
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeAll();
		}
		
		return list;	//返回顺序表
	}
	
	/********************************************************************************/
	
	public void closeAll()
	{
		/**关闭结果集对象**/
		if(rs!=null)
		{
			try 
			{	
				rs.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		/**关闭stmt对象**/
		if(stmt != null)
		{
			try 
			{	
				stmt.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}			
		}
		/**关闭connection连接对象**/
		if(connection != null)
		{
			try 
			{	
				connection.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}			
		}
	}
}
