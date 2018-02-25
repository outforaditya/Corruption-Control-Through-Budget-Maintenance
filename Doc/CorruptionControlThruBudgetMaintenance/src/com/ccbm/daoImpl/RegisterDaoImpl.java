package com.ccbm.daoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Vector;

import com.ccbm.bean.BudgetBean;
import com.ccbm.bean.FeedbackBean;
import com.ccbm.bean.LoginBean;
import com.ccbm.bean.RegisterBean;
import com.ccbm.bean.TransactionBean;
import com.ccbm.daoI.RegisterDaoI;
import com.ccbm.db.ConnectionFactory;
import com.ccbm.db.SqlConstants;
import com.ccbm.exception.ConnectionException;
import com.ccbm.util.DateUtil;
import com.ccbm.util.DateWrapper;

public class RegisterDaoImpl implements RegisterDaoI {

	Connection con;
	PreparedStatement pstmt, pstmt1, pstm1, pstm2, pstm3;
	Statement stmt, stmt1, stmt2, stmt3;
	ResultSet rs, rs1, rs2, rs3;

	public RegisterDaoImpl() {

		con = ConnectionFactory.getConnection();

	}

	/**
	 * The checkAvailabilty method of the RegisterDaoImpl Class.
	 * 
	 * This method is called when to check user name availability.
	 * 
	 * @param Passing
	 *            userId as a one parameter.
	 * 
	 * @return boolean value true or false depends upon operations.
	 */
	public boolean checkAvailability(String userid) throws ConnectionException{
		boolean flag = false;
		try {
			con.setAutoCommit(true);
			pstmt = con.prepareStatement(SqlConstants._CHECK_AVAILABILITY);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ConnectionException("Server problem....");
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new ConnectionException("Server problem....");
			}
		}
		return flag;
	}

	/**
	 * The addDept method of the RegisterDaoImpl Class.
	 * 
	 * This method is called when to insert department and sub department into
	 * database .
	 * 
	 * @param Passing
	 *            department as a one parameter.
	 * @param Passing
	 *            sub department as a one parameter.
	 * @return boolean value true or false depends upon operations.
	 */
	public boolean addDept(String dept, String subdept)throws ConnectionException {
		boolean flag = false;
		int n = 0;
		try {
			pstmt = con.prepareStatement(SqlConstants._CHECK_DEPT_AVAIL);
			pstmt.setString(1, dept);
			rs = pstmt.executeQuery();
			pstm1 = con.prepareStatement(SqlConstants._CHECK_SUBDEPT_AVAIL);
			pstm1.setString(1, subdept);
			rs1 = pstm1.executeQuery();

			if (rs.next()) {
				if (rs1.next()) {
					flag = false;

				} else {
					pstm2 = con.prepareStatement(SqlConstants._INSERT_SUBDEPT);
					pstm2.setString(1, subdept);
					pstm2.setString(2, dept);
					n = pstm2.executeUpdate();
					flag = true;

				}
			} else {

				pstm3 = con.prepareStatement(SqlConstants._INSERT_DEPT);
				pstm3.setString(1, dept);
				n = pstm3.executeUpdate();
				if (n > 0) {
					pstm2 = con.prepareStatement(SqlConstants._INSERT_SUBDEPT);
					pstm2.setString(1, subdept);
					pstm2.setString(2, dept);

					n = pstm2.executeUpdate();
					flag = true;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ConnectionException("Server problem..");
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new ConnectionException("Server problem..");
			}
		}
		return flag;
	}

	/**
	 * The registerCitizen method of the RegisterDaoImpl Class.
	 * 
	 * This method is called when to insert citizen details into database.
	 * 
	 * @param Passing
	 *            RegisterBean as a one parameter.
	 * 
	 * @return boolean value true or false depends upon operations.
	 */
	public boolean registerCitizen(RegisterBean rb)
			throws ConnectionException{

		int insert = 0;
		boolean flag = true;
		try {

			System.out.println("in registerDAO connection is ." + con);
			pstmt = con.prepareStatement(SqlConstants._INSERT_USERS);
			System.out.println();
			String photo = rb.getPhoto();

			String dob = DateWrapper.parseDate(rb.getDob());
			System.out.println(" in dao dob" + dob);
			String fname = rb.getFirstName();
			String lname = rb.getLastName();
			String squestion = rb.getSquest();
			String ans = rb.getSecrete();
			String email = rb.getEmail();
			String phone = rb.getPhoneNo();
			String logintype = rb.getRole();
			System.out.println("role" + logintype);
			String loginid = rb.getUserName();
			String pwd = rb.getPassword();
			String hno = rb.getHouseNo();
			String street = rb.getStreet();
			String city = rb.getCity();
			String dist = rb.getDistrict();
			String state = rb.getState();
			String country = rb.getCountry();
			String pin = rb.getPin();
			String gender = rb.getGender();
			System.out.println("photo=" + photo);
			File f = new File(photo);
			FileInputStream fis = new FileInputStream(f);
			System.out.println("fole=" + f.length());
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
				pstmt1 = con.prepareStatement(SqlConstants._INSERT_ADDRESS);
				pstmt1.setString(1, hno);
				pstmt1.setString(2, street);
				pstmt1.setString(3, city);
				pstmt1.setString(4, dist);
				pstmt1.setString(5, state);
				pstmt1.setString(6, country);
				pstmt1.setString(7, pin);
				pstmt1.setString(8, phone);

				insert = pstmt1.executeUpdate();
			}
			if (insert > 0) {

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
	 * The addFeedback method of the RegisterDaoImpl Class. <br>
	 * 
	 * This method is called when to Citizen gives Feedback.
	 * 
	 * @param Passing
	 *            FeedbackBean as a one parameter.
	 * 
	 * @return boolean value true or false depends upon operations.
	 */
	public boolean addFeedback(FeedbackBean fb) throws ConnectionException{

		boolean flag = false;
		try {

			System.out.println("in registerDAO connection is ." + con);
			pstmt = con.prepareStatement(SqlConstants._INSERT_FEED);

			String name = fb.getName();
			String ph = fb.getPhone();
			// int phone=Integer.parseInt(ph);
			System.out.println(ph);
			String mail = fb.getMail();
			String feedback = fb.getFeedback();
			String city = fb.getCity();
			String state = fb.getState();

			pstmt.setString(1, name);
			pstmt.setString(2, ph);
			pstmt.setString(3, mail);
			pstmt.setString(4, feedback);
			pstmt.setString(5, city);
			pstmt.setString(6, state);

			int i = pstmt.executeUpdate();

			if (i > 0) {
				flag = true;

				con.commit();
			} else {
				flag = false;
				con.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		} catch (Exception se) {
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

	/**
	 * The addQuery method of the RegisterDaoImpl Class.
	 * 
	 * This method is called when to PostQuery
	 * 
	 * @param Passing
	 *            FeedbackBean as a one parameter.
	 * @return boolean value true or false depends upon operations.
	 */
	public boolean addQuery(FeedbackBean fb) throws ConnectionException {

		int userid = 0;
		boolean flag = false;
		try {

			System.out.println("in registerDAO connection is ." + con);
			pstmt = con.prepareStatement(SqlConstants._INSERT_QUERY);
			String username = fb.getUserid();
			String query = fb.getQuery();
			String querydate = fb.getQdate();
			stmt = con.createStatement();
			rs = stmt
					.executeQuery("select userid from userdetails where loginid='"
							+ username + "'");
			if (rs.next()) {

				userid = rs.getInt(1);
			}

			// int phone=Integer.parseInt(ph);

			pstmt.setInt(1, userid);
			pstmt.setString(2, query);

			pstmt.setString(3, querydate);

			int i = pstmt.executeUpdate();

			if (i > 0) {
				flag = true;

				con.commit();
			} else {
				flag = false;
				con.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		} catch (Exception se) {
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

	/**
	 * The replyToQuery method of the RegisterDaoImpl Class.
	 * 
	 * This method is called when to give reply to Query
	 * 
	 * @param Passing
	 *            FeedbackBean as a one parameter.
	 * @return boolean value true or false depends upon operations.
	 */
	public boolean replyToQuery(FeedbackBean fb) throws ConnectionException {

		int userid = 0;
		boolean flag = false;
		try {

			System.out.println("in registerDAO connection is ." + con);
			pstmt = con.prepareStatement(SqlConstants._INSERT_ANSWER);
			String username = fb.getUserid();
			String ans = fb.getAns();
			String qid = fb.getQid();
			String adate = fb.getAdate();
			// int user=Integer.parseInt(username);
			int queid = Integer.parseInt(qid);
			stmt = con.createStatement();
			rs = stmt
					.executeQuery("select userid from userdetails where loginid='"
							+ username + "'");
			if (rs.next()) {

				userid = rs.getInt(1);
			}

			// int phone=Integer.parseInt(ph);

			pstmt.setInt(1, userid);
			pstmt.setString(2, ans);

			pstmt.setString(3, adate);
			pstmt.setInt(4, queid);

			int i = pstmt.executeUpdate();

			if (i > 0) {
				stmt = con.createStatement();
				rs = stmt
						.executeQuery("update query set qstatus='solved' where qid="
								+ queid);

				if (rs.next()) {
					flag = true;

					con.commit();
				}
			} else {
				flag = false;
				con.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		} catch (Exception se) {
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

	/**
	 * The deleteQuery method of the RegisterDaoImpl Class.
	 * 
	 * This method is called when to delete Query Details.
	 * 
	 * @param Passing
	 *            qId as a one parameter.
	 * 
	 * @return boolean value true or false depends upon operations.
	 */
	public boolean deleteQuery(String qid) throws ConnectionException {

		int i = 0;
		boolean flag = false;
		try {

			int queid = Integer.parseInt(qid);
			stmt = con.createStatement();
			i = stmt.executeUpdate("delete from answer where qidref=" + queid);
			if (i > 0) {
				stmt = con.createStatement();
				i = stmt.executeUpdate("delete from query where qid=" + queid);
				if (i > 0)

				{
					flag = true;

					con.commit();
				}
			}

			else {
				flag = false;
				con.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		} catch (Exception se) {
			se.printStackTrace();
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}

		System.out.println("flag=====" + flag);
		return flag;

	}

	/**
	 * The passwordRecovery method of the RegisterDaoImpl Class.
	 * 
	 * This method is called when wants to recover password.
	 * 
	 * @param Passing
	 *            RegisterBean as a one parameter.
	 * @return String value depends upon operations.
	 */
	public String passwordRecovery(RegisterBean rb) {
		String password = "nopassword";
		try {

			String question = rb.getSquest();
			String ans = rb.getSecrete();
			String loginid = rb.getUserName();

			System.out.println(question + "..." + ans + "...." + loginid);

			pstmt = con.prepareStatement(SqlConstants._RECOVER_PASSWORD);
			pstmt.setString(1, loginid);
			pstmt.setString(2, question);
			pstmt.setString(3, ans);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				password = rs.getString(1).trim();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("passworddd..." + password.trim());
		return password;
	}

	/**
	 * The checkUser method of the RegisterDaoImpl Class.
	 * 
	 * This method is called when to generate transaction password to valid user.
	 * 
	 * @param Passing
	 *            userName as a one parameter.
	 * @param Passing
	 *            dob as a one parameter.
	 * @param Passing
	 *            password as a one parameter.
	 * @return String value  depends upon operations.
	 */
	public String checkUser(String dob, String username, String password) {
		String transid = "No password Generated.. ";
		int n = 0;
		try {

			con.setAutoCommit(true);
			SecureRandom r = new SecureRandom();

			// Random r1=new Random();

			int randnumb = r.nextInt();

			if (randnumb < 0)

				randnumb = randnumb * (-1);

			StringBuffer newPassword = new StringBuffer();

			// newPassword.append(“prj_name”);

			newPassword.append(String.valueOf(randnumb));
			String psw = username + newPassword;

			// return newPassword.toString();
			System.out.println(newPassword + "------>");
			System.out.println(psw);

			/*
			 * stmt1=con.createStatement(); rs1=stmt1.executeQuery("select
			 * status from transaction where tran_id=(select tran_id from
			 * transaction where userid=(select userid from userdetails where
			 * loginid='"+username+"'))"); if(rs1.next()) {
			 * 
			 * String status=rs1.getString(1);
			 * System.out.println("status"+status);
			 * if(status.equalsIgnoreCase("NO")) {
			 */
			pstmt = con.prepareStatement(SqlConstants._INSERT_TRANSACTION);
			pstmt.setString(1, username);
			System.out.println(username);
			pstmt.setString(2, password);
			pstmt.setString(3, dob);
			pstmt.setString(4, psw);
			n = pstmt.executeUpdate();
			System.out.println("n........." + n);
			if (n > 0) {
				con.commit();
				stmt = con.createStatement();
				rs = stmt
						.executeQuery("select transaction_password from transaction where userid=(select userid from userdetails where loginid='"
								+ username + "')");
				if (rs.next()) {

					transid = rs.getString(1);
					con.commit();

				}
			}
			// }

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}

		System.out.println("Trans passworddd..." + transid);
		return transid;
	}

	/**
	 * The roleCheck method of the RegisterDaoImpl Class.
	 * 
	 * This method is called when want to check role of user.
	 * 
	 * @param Passing
	 *            LoginBean as a one parameter.
	 * @return String value  depends upon operations.
	 */
	public String roleCheck(LoginBean lb) {

		String role = "";

		try {
			con = ConnectionFactory.getConnection();

			pstmt = con.prepareStatement(SqlConstants._CHECK_USER);

			String uname = lb.getUsername();

			String pwd = lb.getPassword();

			pstmt.setString(1, uname);
			pstmt.setString(2, pwd);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				role = rs.getString(1);

			}

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("Exception raised" + e);
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return role;

	}

	/**
	 * The viewDistricts method of the RegisterDaoImpl Class.
	 * 
	 * This method is called when to view districts.
	 * 
	 * @return vector with district names  depends upon operations.
	 */
	public Vector<TransactionBean> viewDistricts() {
		Vector<TransactionBean> vdo = null;

		try {
			con.setAutoCommit(true);

			stmt = con.createStatement();
			System.out.println("stmt" + stmt);
			vdo = new Vector<TransactionBean>();
			rs = stmt
					.executeQuery("select district from addresses where userid in (SELECT USERID FROM userdetails where logintype='distco')");
			System.out.println("stmt....rs" + rs);
			while (rs.next()) {
				System.out.println("stmt...in rs.next");

				String district = rs.getString(1);

				System.out.println("result -.-..-.-" + rs);

				TransactionBean rb = new TransactionBean();
				rb.setDistrict(district);

				vdo.add(rb);

			}

		}

		catch (SQLException e) {
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
	 * The viewDepartments method of the RegisterDaoImpl Class.
	 * 
	 * This method is called when to view all Departments.
	 * 
	 * @return vector with department names depends upon operations.
	 */
	public Vector<BudgetBean> viewDepartments() {
		Vector<BudgetBean> vdo = null;

		try {

			stmt = con.createStatement();// Statement(SqlConstants.
			// _VIEW_DEPT_OFFICERS);

			rs = stmt.executeQuery(SqlConstants._VIEW_DEPARTMENTS);
			vdo = new Vector<BudgetBean>();
			System.out.println("result -.-..-.-" + rs);
			while (rs.next()) {
				System.out.println("result....... " + rs);
				String deptname = (rs.getString(1));
				System.out.println("dept.........." + deptname);

				BudgetBean rb = new BudgetBean();
				System.out.println("result =============" + rs);
				rb.setDeptname(deptname);
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
	 * The viewDistrictsforCitizen method of the RegisterDaoImpl Class.
	 * 
	 * This method is called when to view districts.
	 * 
	 * @return vector with district  depends upon operations.
	 */
	public Vector<BudgetBean> viewDistrictsforcitzen() {
		Vector<BudgetBean> vdo = null;

		try {

			stmt = con.createStatement();// Statement(SqlConstants.
			// _VIEW_DEPT_OFFICERS);

			rs = stmt.executeQuery(SqlConstants._VIEW_DISTRICT);
			vdo = new Vector<BudgetBean>();
			System.out.println("result -.-..-.-" + rs);
			while (rs.next()) {
				System.out.println("result....... " + rs);
				int distid = rs.getInt(1);
				String distname = rs.getString(2);
				System.out.println("dept.........." + distname);

				BudgetBean rb = new BudgetBean();
				System.out.println("result =============" + rs);
				rb.setDistno(distid);
				rb.setDistrict(distname);
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
	 * The viewStateBudget method of the RegisterDaoImpl Class.
	 * 
	 * This method is called when to view StateBudget at Department level.
	 * 
	 * @return vector with state budget details depends upon operations.
	 */
	public Vector<BudgetBean> viewStateBudget() {
		Vector<BudgetBean> vdo = null;

		try {

			stmt = con.createStatement();// Statement(SqlConstants.
			// _VIEW_DEPT_OFFICERS);

			rs = stmt.executeQuery(SqlConstants._VIEW_STATEBUDGET);
			vdo = new Vector<BudgetBean>();
			System.out.println("result -.-..-.-" + rs);
			while (rs.next()) {
				System.out.println("result....... " + rs);
				String deptname = (rs.getString(1));
				String budgetdate = (rs.getString(2));
				String subdeptname = (rs.getString(3));
				String amount = Integer.toString(rs.getInt(4));
				String year = Integer.toString(rs.getInt(5));
				System.out.println("dept.........." + deptname);

				BudgetBean rb = new BudgetBean();
				System.out.println("result =============" + rs);
				rb.setDeptname(deptname);
				rb.setSubdeptname(subdeptname);
				rb.setBudgetdate(budgetdate);
				rb.setAmount(amount);
				rb.setYear(year);
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
	 * The viewQuery method of the RegisterDaoImpl Class.
	 * 
	 * This method is called when to view all queries.
	 * 
	 * @return vector with queries  depends upon operations.
	 */
	public Vector<FeedbackBean> viewQuery() {
		Vector<FeedbackBean> vdo = null;
		String name = "";

		try {

			stmt = con.createStatement();// Statement(SqlConstants.
			// _VIEW_DEPT_OFFICERS);

			rs = stmt.executeQuery(SqlConstants._VIEW_QUERY);
			vdo = new Vector<FeedbackBean>();
			System.out.println("result -.-..-.-" + rs);
			while (rs.next()) {
				System.out.println("result....... " + rs);

				String query = (rs.getString(3));
				String qdate = (rs.getString(4));
				String qstatus = (rs.getString(5));
				String qid = Integer.toString(rs.getInt(1));
				String uid = Integer.toString(rs.getInt(2));
				int userid = rs.getInt(2);
				stmt1 = con.createStatement();
				rs1 = stmt1
						.executeQuery("select firstname,lastname from userdetails where userid="
								+ userid);
				if (rs1.next()) {
					name = rs1.getString(1) + "." + rs1.getString(2);
				}

				FeedbackBean rb = new FeedbackBean();
				System.out.println("result =============" + rs);
				rb.setQid(qid);
				rb.setUserid(uid);
				rb.setQuery(query);
				rb.setQdate(qdate);
				rb.setQstatus(qstatus);
				rb.setName(name);
				vdo.add(rb);
			}

			System.out.println(vdo.size());
		} catch (SQLException e) {
			System.out.println(e);
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
	 * The viewQuerySolution method of the RegisterDaoImpl Class.
	 * 
	 * This method is called when to view solution to posted query of particular user.
	 * 
	 * @param Passing
	 *            userName as a one parameter.
	 * @return vector with query solution  depends upon operations.
	 */
	public Vector<FeedbackBean> viewQuerySolution(String user) {
		Vector<FeedbackBean> vdo = null;
		String ans = "", adate = "";

		try {

			stmt = con.createStatement();// Statement(SqlConstants.
			// _VIEW_DEPT_OFFICERS);

			rs = stmt
					.executeQuery("select qid from query where userid=(select userid from userdetails where loginid='"
							+ user + "' and qstatus='solved')");
			vdo = new Vector<FeedbackBean>();
			System.out.println("result -.-..-.-" + rs);
			while (rs.next()) {
				System.out.println("result....... " + rs);
				int qid = rs.getInt(1);
				System.out.println("qid....... " + qid);
				stmt1 = con.createStatement();
				rs1 = stmt
						.executeQuery("select answer,to_char(adate,'dd-mm-yyyy') from answer where qidref="
								+ qid);
				if (rs1.next()) {

					System.out.println("result....... " + rs1);
					ans = rs1.getString(1);
					adate = rs1.getString(2);

					FeedbackBean rb = new FeedbackBean();
					System.out.println("result =============" + rs);

					rb.setAns(ans);
					rb.setAdate(adate);

					vdo.add(rb);
				}
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
	 * The viewSubDepartments method of the RegisterDaoImpl Class.
	 * 
	 * This method is called when to view sub departments.
	 * 
	 * @param Passing
	 *            deptName as a one parameter.
	 * @return vector with sub department names depends upon operations.
	 */
	public Vector<BudgetBean> viewSubDepartments(String deptname) {
		Vector<BudgetBean> vdo = null;

		try {
			pstmt = con.prepareStatement(SqlConstants._VIEW_SUBDEPARTMENTS);
			pstmt.setString(1, deptname);
			rs = pstmt.executeQuery();

			// stmt=con.createStatement();//Statement(SqlConstants.
			// _VIEW_DEPT_OFFICERS);

			// rs=stmt.executeQuery(SqlConstants. _VIEW_SUBDEPARTMENTS);
			vdo = new Vector<BudgetBean>();
			System.out.println("result -.-..-.-" + rs);
			while (rs.next()) {
				System.out.println("result....... " + rs);
				String subdeptname = (rs.getString(1));
				int amount = rs.getInt(2);
				int year = rs.getInt(3);
				System.out.println("dept.........." + subdeptname);

				BudgetBean rb = new BudgetBean();
				System.out.println("result =============" + rs);
				rb.setSubdeptname(subdeptname);
				rb.setAmount(Integer.toString(amount));
				rb.setYear(Integer.toString(year));
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

}
