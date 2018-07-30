package dao.general;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import business.general.*;

public class NoticeDao {
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

	public static int save(notice e) {
		int status = 0;
		try {
			Connection con = NoticeDao.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into notice_tb(title,gr,unit,dist,location,contact,date,published_by) values (?,?,?,?,?,?,?,?)");
			
                       
                        ps.setString(1, e.getTitle());
                        ps.setString(2, e.getGr());
                        ps.setString(3, e.getUnit());
                        ps.setString(4, e.getDist());
                        ps.setString(5, e.getLocation());
                        ps.setString(6, e.getContact());
                        ps.setString(7, e.getDate());
                        ps.setString(8, e.getPublished_by());

			status = ps.executeUpdate();

			con.close();
		}    catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int update(notice e) {
		int status = 0;
		try {
			Connection con = NoticeDao.getConnection();
			PreparedStatement ps = con
			.prepareStatement("update notice_tb set title=?,gr=?,unit=?,dist=?,location=?,contact=?,date=?,published_by=? where sl=?");
			
			
                        ps.setString(1, e.getTitle());
                        ps.setString(2, e.getGr());
                        ps.setString(3, e.getUnit());
                        ps.setString(4, e.getDist());
                        ps.setString(5, e.getLocation());
                        ps.setString(6, e.getContact());
                        ps.setString(7, e.getDate());
                        ps.setString(8, e.getPublished_by());
                        ps.setInt(9,e.getSl());
			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int delete(int sl) {
		int status1 = 0;
		try {
			Connection con =NoticeDao.getConnection();
			PreparedStatement ps = con.prepareStatement("Delete from notice_tb where sl=?");
			ps.setInt(1, sl);
			status1 = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status1;
	}

	//No search needed
        
	public static List<notice> getAllNotices() {
		List<notice> list = new ArrayList<notice>();

		try {
			Connection con = NoticeDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from notice_tb");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				notice e = new notice();
				e.setSl(rs.getInt(1));
				e.setTitle(rs.getString(2));
                                e.setGr(rs.getString(3));
                                e.setUnit(rs.getString(4));
                                e.setDist(rs.getString(5));
                                e.setLocation(rs.getString(6));
                                e.setContact(rs.getString(7));
                                e.setDate(rs.getString(8));
                                e.setPublished_by(rs.getString(9));
				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}