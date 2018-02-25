package com.ccbm.daoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.RandomAccess;
import java.util.Vector;

import com.ccbm.bean.RegisterBean;
import com.ccbm.daoI.OfficerDaoI;
import com.ccbm.db.ConnectionFactory;
import com.ccbm.db.SqlConstants;
import com.ccbm.util.DateWrapper;

public class OfficerDaoImpl implements OfficerDaoI {

	Connection con;
	PreparedStatement pstmt, pstmt1, pstm1, pstm2, pstm3;
	Statement stmt, stmt1, stmt2, stmt3,stmt4,stmt6;
	ResultSet rs, rs1, rs2, rs3;

	public OfficerDaoImpl() {

		con = ConnectionFactory.getConnection();

	}

	/**
	 * The registerDeptOfficer method of the OfficerDaoImpl Class. <br>
	 * 
	 * This method is called when wants to insert Department officer details
	 * into database.
	 * 
	 * @param Passing
	 *            RegisterBean as a one parameter.This bean contains complete
	 *            details of Department officer like name, login id,password.
	 * 
	 * @return boolean value true or false depends upon operations.
	 */
	public boolean registerDeptOfficer(RegisterBean rb)
			throws FileNotFoundException {

		int insert = 0;
		boolean flag = true;
		try {

			System.out.println("in registerDAO connection is ............"
					+ con);
			pstmt = con.prepareStatement(SqlConstants._INSERT_DEPT_OFFICER);
			System.out.println();
			String photo = rb.getPhoto();

			String dob = DateWrapper.parseDate(rb.getDob());
			System.out.println(" in dao dob............>" + dob);
			String fname = rb.getFirstName();
			String lname = rb.getLastName();
			String squestion = rb.getSquest();
			String ans = rb.getSecrete();
			String email = rb.getEmail();
			String phone = rb.getPhoneNo();
			String logintype = rb.getRole();
			System.out.println("role...........>" + logintype);
			String loginid = rb.getUserName();
			String addrtype = rb.getAddresstype();
			System.out.println("...DEptt........." + addrtype);
			String pwd = rb.getPassword();
			String hno = rb.getHouseNo();
			String street = rb.getStreet();
			String city = rb.getCity();
			String dist = rb.getDistrict();
			String state = rb.getState();
			String country = rb.getCountry();
			String pin = rb.getPin();
			String gender = rb.getGender();
			System.out.println("photo=" + photo+"dist"+dist);
			File f = new File(photo);
			FileInputStream fis = new FileInputStream(f);
			System.out.println("fole=" + f.length());

			pstmt.setString(1, fname);
			pstmt.setString(2, lname);
			pstmt.setString(3, dob);
			pstmt.setString(4, loginid);
			pstmt.setString(5, pwd);
			pstmt.setString(6, logintype);
			pstmt.setString(7, squestion);
			pstmt.setString(8, ans);

			pstmt.setBinaryStream(9, fis, (int) f.length());

			pstmt.setString(10, email);

			pstmt.setString(11, gender);

			int i = pstmt.executeUpdate();

			if (i > 0) {
				pstmt1 = con
						.prepareStatement(SqlConstants._INSERT_DEPT_OFF_ADDR);
				pstmt1.setString(1, addrtype);
				pstmt1.setString(2, hno);
				pstmt1.setString(3, street);
				pstmt1.setString(4, city);
				pstmt1.setString(5, dist);
				pstmt1.setString(6, state);
				pstmt1.setString(7, country);
				pstmt1.setString(8, pin);
				pstmt1.setString(9, phone);

				insert = pstmt1.executeUpdate();
			}
			if (insert > 0) {
				
				if(logintype.equalsIgnoreCase("distco")){
					stmt=con.createStatement();
					int m=stmt.executeUpdate("insert into district values((select nvl(max(distid),1000)+1 from district),'"+dist+"',(select max(userid) from userdetails))");
					if(m>0)
					{con.commit();}
				}
				else
				con.commit();
			} else {
				flag = false;
				con.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}

		return flag;

	}

	/**
	 * The viewDeptOfficers method of the OfficerDaoImpl Class.
	 * 
	 * This method is called when to view all department officer details.
	 * 
	 * 
	 * @return vector with department officer details depends upon operations.
	 */
	public Vector<RegisterBean> viewDeptOfficers() {
		Vector<RegisterBean> vdo = null;

		try {

			stmt = con.createStatement();// Statement(SqlConstants.
			// _VIEW_DEPT_OFFICERS);

			rs = stmt.executeQuery(SqlConstants._VIEW_DEPT_OFFICERS);
			vdo = new Vector<RegisterBean>();
			System.out.println("result -.-..-.-" + rs);
			while (rs.next()) {
				System.out.println("result....... " + rs);
				String deptoffid = (rs.getString(1));
				System.out.println("loginid.........." + deptoffid);
				String deptoffname = rs.getString(2);
				String dept = rs.getString(3);
				String dist = rs.getString(4);
				System.out.println("dept.........." + dept);
				System.out.println("result " + rs);
				RegisterBean rb = new RegisterBean();
				System.out.println("result =============" + rs);
				rb.setUserName(deptoffid);
				rb.setFirstName(deptoffname);
				rb.setAddresstype(dept);
				rb.setDistrict(dist);

				vdo.add(rb);
			}

		} catch (SQLException e) {
			// TODO: handle exception
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return vdo;

	}

	/**
	 * The viewDeptOfficers method of the OfficerDaoImpl Class.
	 * 
	 * This method is called when to view department officer details of
	 * particular department.
	 * 
	 * @param Passing
	 *            department as a one parameter.
	 * 
	 * @return vector with department officer details depends upon operations.
	 */
	public Vector<RegisterBean> viewDeptOfficers(String deprt) {
		Vector<RegisterBean> vdo = null;

		try {
			pstmt = con.prepareStatement(SqlConstants._VIEW_DEPT_OFFICERS1);
			pstmt.setString(1, deprt);
			rs = pstmt.executeQuery();
			vdo = new Vector<RegisterBean>();
			System.out.println("result -.-..-.-" + rs);
			while (rs.next()) {
				System.out.println("result....... " + rs);
				String deptoffid = (rs.getString(1));
				System.out.println("loginid.........." + deptoffid);
				String deptoffname = rs.getString(2);
				String dept = rs.getString(3);
				String dist = rs.getString(4);
				System.out.println("dept.........." + dept);
				System.out.println("result " + rs);
				RegisterBean rb = new RegisterBean();
				System.out.println("result =============" + rs);
				rb.setUserName(deptoffid);
				rb.setFirstName(deptoffname);
				rb.setAddresstype(dept);
				rb.setDistrict(dist);

				vdo.add(rb);
			}

		} catch (SQLException e) {

		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return vdo;

	}

	/**
	 * The viewDistOfficers method of the OfficerDaoImpl Class.
	 * 
	 * This method is called when to view all district officer details.
	 * 
	 * 
	 * @return vector with district officer details depends upon operations.
	 */
	public Vector<RegisterBean> viewDistOfficers() {
		Vector<RegisterBean> vdo = null;

		try {

			stmt = con.createStatement();// Statement(SqlConstants.
			// _VIEW_DEPT_OFFICERS);

			rs = stmt.executeQuery(SqlConstants._VIEW_DIST_OFFICERS);
			vdo = new Vector<RegisterBean>();
			System.out.println("result -.-..-.-" + rs);
			while (rs.next()) {
				System.out.println("result....... " + rs);
				String deptoffid = (rs.getString(1));
				System.out.println("loginid.........." + deptoffid);
				String deptoffname = rs.getString(2);
				String dept = rs.getString(3);
				String dist = rs.getString(4);
				System.out.println("dept.........." + dept);
				System.out.println("result " + rs);
				RegisterBean rb = new RegisterBean();
				System.out.println("result =============" + rs);
				rb.setUserName(deptoffid);
				rb.setFirstName(deptoffname);
				rb.setAddresstype(dept);
				rb.setDistrict(dist);

				vdo.add(rb);
			}

		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}

		return vdo;

	}

	/**
	 * The viewDistOfficers method of the OfficerDaoImpl Class.
	 * 
	 * This method is called when to view district officer details of
	 * particular department.
	 * 
	 * @param Passing
	 *            district as a one parameter.
	 * 
	 * @return vector with district officer details depends upon operations.
	 */
	public Vector<RegisterBean> viewDistOfficers(String distt) {
		Vector<RegisterBean> vdo = null;

		try {
			System.out.println("Dist" + distt);

			pstmt = con.prepareStatement(SqlConstants._VIEW_DIST_OFFICERS1);// Statement(SqlConstants.
			// _VIEW_DEPT_OFFICERS);
			pstmt.setString(1, distt);
			rs = pstmt.executeQuery();
			vdo = new Vector<RegisterBean>();
			System.out.println("result -.-..-.-" + rs);
			while (rs.next()) {
				System.out.println("result....... " + rs);
				String deptoffid = (rs.getString(1));
				System.out.println("loginid.........." + deptoffid);
				String deptoffname = rs.getString(2);
				String dept = rs.getString(3);
				String dist = rs.getString(4);
				System.out.println("dept.........." + dept);
				System.out.println("result " + rs);
				RegisterBean rb = new RegisterBean();
				System.out.println("result =============" + rs);
				rb.setUserName(deptoffid);
				rb.setFirstName(deptoffname);
				rb.setAddresstype(dept);
				rb.setDistrict(dist);

				vdo.add(rb);
			}

		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}

		return vdo;

	}

	/**
	 * The deleteDeptOff method of the OfficerDaoImpl Class.
	 * 
	 * This method is called when to delete department officer details of
	 * particular department.
	 * 
	 * @param Passing
	 *            loginId as a one parameter.
	 * 
	 * @return boolean value true or false depends upon operations.
	 */
	public boolean deleteDeptoff(String qid) throws FileNotFoundException {

		int i = 0, j = 0, k = 0, l = 0;

		boolean flag = false;
		try {

			//con.setAutoCommit(false);

			stmt2 = con.createStatement();
			rs2 = stmt2
					.executeQuery("select nvl(max(userid),1) from TRANSACTION where userid=(select userid from userdetails where loginid='"
							+ qid + "')");

			if (rs2.next()) {
				i = rs2.getInt(1);
				System.out.println("i=....>" + i);
			}

			if (i==1) {
				stmt1 = con.createStatement();
				l = stmt1
						.executeUpdate("delete from userdetails where userid=(select userid from userdetails where loginid='"
								+ qid + "')");
				if (l > 0) {

					System.out.println("l=....>" + l);
					flag = true;

					con.commit();
				}
			}

				if (i>1) {
					System.out.println("i....>" + i);
					stmt6=con.createStatement();
					stmt3=con.createStatement();
					//k = stmt.executeUpdate("delete from department where userid="+i+"");
						k = stmt6.executeUpdate("delete from department where userid=(select userid from userdetails where loginid='"+ qid + "')");
						if (k >0) {

						
						int m = stmt3.executeUpdate("delete from userdetails where userid=(select userid from userdetails where loginid='"+ qid + "')");	
						
							System.out.println("k=....>" + m);
							flag = true;

							con.commit();
						}
						else {
							if(i>1&&k<=0){
								int m1 = stmt3
								.executeUpdate("delete from userdetails where userid=(select userid from userdetails where loginid='"
										+ qid + "')");	
								
									System.out.println("k=....>" + m1);
									flag = true;

									con.commit();
									}
							else
							
							con.rollback();
					}
				
				}
			
		} catch (SQLException e) {
			System.out.println("123...");
			if(i>1&&k<=0){
				try {
					stmt1=con.createStatement();
				
				int m1;
					m1 = stmt1.executeUpdate("delete from userdetails where userid=(select userid from userdetails where loginid='"
							+ qid + "')");
					if(m1>0)
					{con.commit();
					System.out.println("k=....>" + m1);
					 flag=true;
					 }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			
			}
			e.printStackTrace();
			//flag = false;
		} catch (Exception se) {
			System.out.println("normal excep");
			try{
			if(i>1&&k<=0){
				stmt1=con.createStatement();
				int m1 = stmt1.executeUpdate("delete from userdetails where userid=(select userid from userdetails where loginid='"
						+ qid + "')");	
				
					System.out.println("k=....>" + m1);
					flag = true;

					con.commit();
			}
			
			}catch (Exception e) {
				// TODO: handle exception
				//System.out.println(e);
				e.printStackTrace();
			}
			se.printStackTrace();
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}

		return flag;

	}
	
	public boolean deleteDistoff(String qid) throws FileNotFoundException {

		int i = 0, j = 0, k = 0, l = 0;

		boolean flag = false;
	try{
		stmt=con.createStatement();
		rs=stmt.executeQuery("delete from department where userid=(select userid from userdetails where loginid='"
						+ qid + "')");	
		
	}	catch (Exception e) {
		System.out.println("In Exep");
		// TODO: handle exception
	}

return flag;
	}
}
