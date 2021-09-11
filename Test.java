
import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	public class Test {

	public static void main(String[] args) {
		Test objTest=new Test();
	        //insert data
		objTest.create_data("1", "anju", "anjn@gmail.com");
		objTest.create_data("2", "jawad", "jawad@gmail.com");
	        //read data
		objTest.read_data("1");
		objTest.read_data("2");
	        //update data
		objTest.update_data("2", "33", "jawad2", "jawad2@gmail");
	      
		
	}

	public void create_data(String sl_no,String name,String email){
		DB_Connection obj_DB_Connection=new DB_Connection();
		Connection connection=obj_DB_Connection.get_connection();
		PreparedStatement ps=null;
		try {
			String query="insert into user(sl_no,name,email) values (?,?,?)";
			ps=connection.prepareStatement(query);
			ps.setString(1, sl_no);
			ps.setString(2, name);
			ps.setString(3, email);
			System.out.println(ps);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void read_data(String sl_no){
		DB_Connection obj_DB_Connection=new DB_Connection();
		Connection connection=obj_DB_Connection.get_connection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String query="select * from user";
			ps=connection.prepareStatement(query);
			//ps.setString(1, sl_no);
			System.out.println(ps);
			rs=ps.executeQuery();
			while(rs.next()){
			System.out.println("Sl no -"+rs.getString("sl_no"));
			System.out.println("name -"+rs.getString("name"));
			System.out.println("email -"+rs.getString("email"));
			System.out.println("---------------");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void update_data(String sl_no,String new_sl_no,String name,String email){
		DB_Connection obj_DB_Connection=new DB_Connection();
		Connection connection=obj_DB_Connection.get_connection();
		PreparedStatement ps=null;
		try {
			String query="update user set sl_no=?,name=?,email=? where sl_no=?";
			ps=connection.prepareStatement(query);
			ps.setString(1, new_sl_no);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, sl_no);
			System.out.println(ps);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void delete_data(String sl_no){
		DB_Connection obj_DB_Connection=new DB_Connection();
		Connection connection=obj_DB_Connection.get_connection();
		PreparedStatement ps=null;
		try {
			String query="delete from user where sl_no=?";
			ps=connection.prepareStatement(query);
			ps.setString(1, sl_no);
			System.out.println(ps);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

	}


}