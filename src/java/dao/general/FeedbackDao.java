package dao.general;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import business.general.*;

public class FeedbackDao {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bl_for_life", "root", "");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int save(feedback e) {
		int status = 0;
		try {
			Connection con = FeedbackDao.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into feedback(name,date,comments) values (?,?,?)");
			
                        
                        ps.setString(1, e.getName());
                        ps.setString(2, e.getDate());
                        ps.setString(3, e.getComments());

			status = ps.executeUpdate();

			con.close();
		}    catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

//no update needed

	public static int delete(int sl) {
		int status1 = 0;
		try {
			Connection con =NoticeDao.getConnection();
			PreparedStatement ps = con.prepareStatement("Delete from feedback where sl=?");
			ps.setInt(1, sl);
			status1 = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status1;
	}

	//No search needed
        
	public static List<feedback> getAllFeedbacks() {
		List<feedback> list = new ArrayList<feedback>();

		try {
			Connection con = FeedbackDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from feedback");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				feedback e = new feedback();
				e.setSl(rs.getInt(1));
				e.setName(rs.getString(2));
                                e.setDate(rs.getString(3));
                                e.setComments(rs.getString(4));
				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}