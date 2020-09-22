package dao;



/**ʹ��PreparedStatementʹStatement���Ӱ�ȫ**/

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
	/**���ݿ����ӱ�Ҫ���ԣ����͡���ַ���˿ڡ��û��������롢����**/
	private static String sql;
	private static String address;
	private static String port;
	private static String username;
	private static String password;
	private static String dbname;
	/**����Ψһ���Ա�������url��ַ**/
	private static String url;
	/**JDBC�������ݿ��������**/
	private static Connection connection=null;	//���Ӷ���
	private static PreparedStatement stmt=null;	//�������ݿ�Ķ���
	private static ResultSet rs=null;			//����������
	/**�������ȷ��Ψһ**/
	private static JDBCUtil jdbcUtil= null;
	
	/********************************************************************************/
	
	public static synchronized JDBCUtil getInitJDBCUtil()
	{	
		configure("mysql","127.0.0.1","3306","root","2246260","myjavadb");
		/**ȷ��JDBCUtil���������в�ʹ��new**/
		if(jdbcUtil==null)
		{
		  	jdbcUtil = new JDBCUtil();
		}
		return jdbcUtil;
	}
	
	static
	{
		/**ȷ������������δ���**/
		/**��������**/
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	/**�������ݿ��������Ϣ**/
	private static void configure(String sql, String address, String port, String username, String password, String dbname)
	{
		/**����ʹ��JDBCUtil������ʹ��this����Ϊ�����Ǿ�̬��������������о���Ψһ��**/
		JDBCUtil.sql = sql;
		JDBCUtil.address = address;
		JDBCUtil.port = port;
		JDBCUtil.username = username;
		JDBCUtil.password = password;
		JDBCUtil.dbname = dbname;
		
		JDBCUtil.url="jdbc:"+JDBCUtil.sql+"://"+JDBCUtil.address+":"+JDBCUtil.port+"/"+JDBCUtil.dbname;
	}
	
	/**��ȡ���ݿ�����**/
	public Connection getConnection()
	{
		try
		{
			connection=DriverManager.getConnection(JDBCUtil.url,JDBCUtil.username,JDBCUtil.password);
		}
		catch (SQLException e) 
		{
			System.err.println("���ݿ�����ʧ�ܣ���������û�������д����");
			//e.printStackTrace();
		}
		return connection;
	}
	
	/********************************************************************************/
	/**ִ�в������ݿ�ķ���**/
	/********************************************************************************/
	public int executeUpdate(String sql) throws Exception
	{
		int affectedLine=0;//��Ӱ�������
		/**�������ݿ�����**/
		connection = getConnection();
		/**�������ݿ����**/

		stmt=connection.prepareStatement(sql);	//׼��ִ�����
		affectedLine = stmt.executeUpdate();	//ִ�����

		closeAll();
		return affectedLine;
	}
	
	public int executeUpdate(String sql,Object[] params) throws Exception
	{
		int affectedLine=0;//��Ӱ�������
		/**�������ݿ�����**/
		connection = getConnection();
		/**�������ݿ����**/
		stmt=connection.prepareStatement(sql);	//׼��ִ�����
		for(int i=0;i<params.length;i++)
		{
			/**������ִ������е�?'�ʺ�'��ֵ**/
			stmt.setObject(i+1,params[i]);
		}
		affectedLine = stmt.executeUpdate();	//ִ�����
		closeAll();
		return affectedLine;
	}
	
	/********************************************************************************/
	/**
	 * ��ѯԭ��	ִ��executeQuery->����executeQueryRS��ȡ�����
	 * 			executeQuery�����ѽ���������������˳�����
	 */
	/********************************************************************************/
	private ResultSet executeQueryRS(String sql,Object[] params)
	{
		/**�������ݿ�����**/
		connection = getConnection();
		try
		{
			stmt=connection.prepareStatement(sql);	//׼��ִ�����
			for(int i=0;i<params.length;i++)
			{
				/**������ִ������е�?'�ʺ�'��ֵ**/
				stmt.setObject(i+1,params[i]);
			}
			rs=stmt.executeQuery();	//ִ�����
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return rs;	
	}
	
	/**mysql��ѯ����(����?�Ų���)**/
	public List<HashMap> executeQuery(String sql)
	{
		Object temp[] = {};
		ResultSet tempRS= executeQueryRS(sql,temp);
		/**ResultSetMetaData�����ԭ���ݣ����ڻ�ȡ����ResultSet�е�����ֵ**/
		ResultSetMetaData rsmd = null;
		int columnCount = 0;
		try 
		{
			rsmd=tempRS.getMetaData();			//��ȡԭ����
			columnCount=rsmd.getColumnCount();	//ȡ���������
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		/**�½�һ��˳���ÿһ����¼����Ϊһ��HashMap������˳�������**/
		List<HashMap> list=new ArrayList<HashMap>();
		try 
		{
			//�Խ�������б���
			while(tempRS.next())
			{
				/**�½�һ��HashMapÿһ����¼��������һ��HashMap����**/
				HashMap<String,Object> map=new HashMap<String,Object>();
				for(int i=1;i<=columnCount;i++)
				{
					map.put(rsmd.getColumnLabel(i),rs.getObject(i));		//��ȡ����
				}
				list.add(map);//��HashMap����˳���list��
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
		return list;	//����˳���
	}
	
	/**mysql��ѯ����(��?�Ų���)**/
	public List<HashMap> executeQuery(String sql,Object[] params)
	{
		ResultSet tempRS= executeQueryRS(sql,params);
		/**ResultSetMetaData�����ԭ���ݣ����ڻ�ȡ����ResultSet�е�����ֵ**/
		ResultSetMetaData rsmd = null;
		int columnCount = 0;
		try 
		{
			rsmd=tempRS.getMetaData();			//��ȡԭ����
			columnCount=rsmd.getColumnCount();	//ȡ���������
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		/**�½�һ��˳���ÿһ����¼����Ϊһ��HashMap������˳�������**/
		List<HashMap> list=new ArrayList<HashMap>();
		try 
		{
			//�Խ�������б���
			while(tempRS.next())
			{
				/**�½�һ��HashMapÿһ����¼��������һ��HashMap����**/
				HashMap<String,Object> map=new HashMap<String,Object>();
				for(int i=1;i<=columnCount;i++)
				{
					map.put(rsmd.getColumnLabel(i),rs.getObject(i));		//��ȡ����
				}
				list.add(map);//��HashMap����˳���list��
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
		
		return list;	//����˳���
	}
	
	/********************************************************************************/
	
	public void closeAll()
	{
		/**�رս��������**/
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
		/**�ر�stmt����**/
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
		/**�ر�connection���Ӷ���**/
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
