package dao.general;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import business.general.*;

public class GeneralDao {
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

	public static int save(generalMember e) {
		int status = 0;
		try {
			Connection con = GeneralDao.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into gen_table(name,phone,mail,bl_gr,age,weight,pass,status,last_given,dist,location,req) values (?,?,?,?,?,?,?,?,?,?,?,?)");
			
                        
                        ps.setString(1, e.getName());
                        ps.setString(2, e.getPhone());
                        ps.setString(3, e.getMail());
                        ps.setString(4, e.getBl_gr());
                        ps.setString(5, e.getAge());
                        ps.setString(6, e.getWeight());
                        ps.setString(7, e.getPass());
                        ps.setString(8, e.getStatus());
                        ps.setString(9, e.getLast_given());
                        ps.setString(10, e.getDist());
                        ps.setString(11, e.getLocation());
                        ps.setString(12, e.getReq());

			status = ps.executeUpdate();

			con.close();
		      }    catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int update(generalMember e) {
		int status = 0;
		try {
			Connection con = GeneralDao.getConnection();
			PreparedStatement ps = con
			.prepareStatement("update gen_table set name=?,phone=?,mail=?,bl_gr=?,age=?,weight=?,pass=?,status=?,last_given=?,dist=?,location=?,req=? where sl=?");
			
			ps.setString(1, e.getName());
                        ps.setString(2, e.getPhone());
                        ps.setString(3, e.getMail());
                        ps.setString(4, e.getBl_gr());
                        ps.setString(5, e.getAge());
                        ps.setString(6, e.getWeight());
                        ps.setString(7, e.getPass());
                        ps.setString(8, e.getStatus());
                        ps.setString(9, e.getLast_given());
                        ps.setString(10, e.getDist());
                        ps.setString(11, e.getLocation());
                        ps.setString(12, e.getReq());
                        
			ps.setInt(13, e.getSl());

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
			Connection con = GeneralDao.getConnection();
			PreparedStatement ps = con.prepareStatement("Delete from gen_table where sl=?");
			ps.setInt(1, sl);
			status1 = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status1;
	}

	public static generalMember getMemberById(int sl) {
		generalMember e = new generalMember();

		try {
			Connection con = GeneralDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from gen_table where sl=?");
			ps.setInt(1, sl);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				e.setSl(rs.getInt(1));
				e.setName(rs.getString(2));
                                e.setPhone(rs.getString(3));
                                e.setMail(rs.getString(4));
                                e.setBl_gr(rs.getString(5));
                                e.setAge(rs.getString(6));
                                e.setWeight(rs.getString(7));
                                e.setPass(rs.getString(8));
                                e.setStatus(rs.getString(9));
                                e.setLast_given(rs.getString(10));
                                e.setDist(rs.getString(11));
                                e.setLocation(rs.getString(12));
                                e.setReq(rs.getString(13));  
                                
				
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}

	public static List<generalMember> getAllMembers() {
		List<generalMember> list = new ArrayList<generalMember>();

		try {
			Connection con = GeneralDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from gen_table");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				generalMember e = new generalMember();
				e.setSl(rs.getInt(1));
				e.setName(rs.getString(2));
                                e.setPhone(rs.getString(3));
                                e.setMail(rs.getString(4));
                                e.setBl_gr(rs.getString(5));
                                e.setAge(rs.getString(6));
                                e.setWeight(rs.getString(7));
                                e.setPass(rs.getString(8));
                                e.setStatus(rs.getString(9));
                                e.setLast_given(rs.getString(10));
                                e.setDist(rs.getString(11));
                                e.setLocation(rs.getString(12));
                                e.setReq(rs.getString(13));
				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}