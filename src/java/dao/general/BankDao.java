package dao.general;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import business.general.*;

public class BankDao {
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

	public static int save(bankMember e) {
		int status = 0;
		try {
			Connection con = BankDao.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into bank_tb(name,auth_id,phone,dist,mail,pass,gr_a1,gr_a2,gr_b1,gr_b2,gr_o1,gr_o2,gr_ab1,gr_ab2,conditions,location,req) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
                        
                        ps.setString(1, e.getName());
                        ps.setString(2, e.getAuth_id());
                        ps.setString(3, e.getPhone());
                        ps.setString(4, e.getDist());
                        ps.setString(5, e.getMail());
                        ps.setString(6, e.getPass());
                        ps.setString(7, e.getGr_a1());
                        ps.setString(8, e.getGr_a2());
                        ps.setString(9, e.getGr_b1());
                        ps.setString(10, e.getGr_b2());
                        ps.setString(11, e.getGr_o1());
                        ps.setString(12, e.getGr_o2());
                        ps.setString(13, e.getGr_ab1());
                        ps.setString(14, e.getGr_ab2());
                        ps.setString(15, e.getConditions());
                        ps.setString(16, e.getLocation());
                        ps.setString(17, e.getReq());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int update(bankMember e) {
		int status = 0;
		try {
			Connection con = BankDao.getConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE bank_tb SET name=?,auth_id=?,phone=?,dist=?,mail=?,pass=?,gr_a1=?,gr_a2=?,gr_b1=?,gr_b2=?,gr_o1=?,gr_o2=?,gr_ab1=?,gr_ab2=?,conditions=?,location=?,req=? WHERE sl=?");
			
			ps.setString(1, e.getName());
                        ps.setString(2, e.getAuth_id());
                        ps.setString(3, e.getPhone());
                        ps.setString(4, e.getDist());
                        ps.setString(5, e.getMail());
                        ps.setString(6, e.getPass());
                        ps.setString(7, e.getGr_a1());
                        ps.setString(8, e.getGr_a2());
                        ps.setString(9, e.getGr_b1());
                        ps.setString(10, e.getGr_b2());
                        ps.setString(11, e.getGr_o1());
                        ps.setString(12, e.getGr_o2());
                        ps.setString(13, e.getGr_ab1());
                        ps.setString(14, e.getGr_ab2());
                        ps.setString(15, e.getConditions());
                        ps.setString(16, e.getLocation());
                        ps.setString(17, e.getReq());
                        
			ps.setInt(18, e.getSl());

			status = ps.executeUpdate();

			con.close();
		} 
                catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}
 

	public static int delete(int sl) {
		int status1 = 0;
		try {
			Connection con = BankDao.getConnection();
			PreparedStatement ps = con.prepareStatement("Delete from bank_tb where sl=?");
			ps.setInt(1, sl);
			status1 = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status1;
	}

	public static bankMember getBankMemberById(int sl) {
		bankMember e = new bankMember();

		try {
			Connection con = BankDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from bank_tb where sl=?");
			ps.setInt(1, sl);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				e.setSl(rs.getInt(1));
				e.setName(rs.getString(2));
                                e.setAuth_id(rs.getString(3));
                                e.setPhone(rs.getString(4));
                                e.setDist(rs.getString(5));
                                e.setMail(rs.getString(6));
                                e.setPass(rs.getString(7));
                                e.setGr_a1(rs.getString(8));
                                e.setGr_a2(rs.getString(9));
                                e.setGr_b1(rs.getString(10));
                                e.setGr_b2(rs.getString(11));
                                e.setGr_o1(rs.getString(12));
                                e.setGr_o2(rs.getString(13));
                                e.setGr_ab1(rs.getString(14));
                                e.setGr_ab2(rs.getString(15));
                                e.setConditions(rs.getString(16));
                                e.setLocation(rs.getString(17));
                                e.setReq(rs.getString(18));
                                
				
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}

	public static List<bankMember> getAllBankMembers() {
		List<bankMember> list = new ArrayList<bankMember>();

		try {
			Connection con = BankDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from bank_tb");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bankMember e = new bankMember();
				e.setSl(rs.getInt(1));
				e.setName(rs.getString(2));
                                e.setAuth_id(rs.getString(3));
                                e.setPhone(rs.getString(4));
                                e.setDist(rs.getString(5));
                                e.setMail(rs.getString(6));
                                e.setPass(rs.getString(7));
                                e.setGr_a1(rs.getString(8));
                                e.setGr_a2(rs.getString(9));
                                e.setGr_b1(rs.getString(10));
                                e.setGr_b2(rs.getString(11));
                                e.setGr_o1(rs.getString(12));
                                e.setGr_o2(rs.getString(13));
                                e.setGr_ab1(rs.getString(14));
                                e.setGr_ab2(rs.getString(15));
                                e.setConditions(rs.getString(16));
                                e.setLocation(rs.getString(17));
                                e.setReq(rs.getString(18));
                                
				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}