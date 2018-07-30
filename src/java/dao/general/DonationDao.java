package dao.general;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import business.general.*;

public class DonationDao {
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

	public static int save(donation e) {
		int status = 0;
		try {
			Connection con = DonationDao.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into donation_tb(name,date,to_whom,location) values (?,?,?,?)");
			
                   
                        ps.setString(1, e.getName());
                        ps.setString(2, e.getDate());
                        ps.setString(3, e.getTo_whom());
                        ps.setString(4, e.getLocation());
                        

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
			Connection con =DonationDao.getConnection();
			PreparedStatement ps = con.prepareStatement("Delete from donation_tb where sl=?");
			ps.setInt(1, sl);
			status1 = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status1;
	}

	//No search needed
        

        
          public static donation getDonationById(int sl) {
		donation e = new donation();

		try {
			Connection con = DonationDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from donation_tb where sl=?");
			ps.setInt(1, sl);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				e.setSl(rs.getInt(1));
				e.setName(rs.getString(2));
                                e.setDate(rs.getString(3));
                                e.setTo_whom(rs.getString(4));
                                e.setLocation(rs.getString(5));
                                
				
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}
          
                  
         public static List<donation> getDonationsByName(String name) {
		List<donation> list = new ArrayList<donation>();
                    
		try {
			Connection con = DonationDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from donation_tb where name=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				donation e = new donation();
				e.setSl(rs.getInt(1));
				e.setName(rs.getString(2));
                                e.setDate(rs.getString(3));
                                e.setTo_whom(rs.getString(4));
                                e.setLocation(rs.getString(5));
                                
				list.add(e);
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return list;
	}
          
          public static List<donation> getAllDonations() {
		List<donation> list = new ArrayList<donation>();

		try {
			Connection con = DonationDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from donation_tb");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				donation e = new donation();
				e.setSl(rs.getInt(1));
				e.setName(rs.getString(2));
                                e.setDate(rs.getString(3));
                                e.setTo_whom(rs.getString(4));
                                e.setLocation(rs.getString(5));
                                
				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}