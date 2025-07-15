package com.infosys.servlet_simple_demo_crud.dao;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.infosys.servlet_simple_demo_crud.connection.StudentConnection;
import com.infosys.servlet_simple_demo_crud.entity.Student;

public class StudentDao {
	Connection connection = StudentConnection.getStudentConnection();

	// >>>>>>>>>>>>>>>>>> Save/Insert Student details <<<<<<<<<<<<<<<<<<<<<<<<<<<<

	public Student saveStudentDao(Student student) {

		String INSERT_STUDENT_QUERY = "insert into studentregis(id,name,password,email,phoneNumber,dob,gender) values(?,?,?,?,?,?,?)";

		if (connection != null) {

			try {
				PreparedStatement ps = connection.prepareStatement(INSERT_STUDENT_QUERY);

				ps.setInt(1, student.getId());
				ps.setString(2, student.getName());
				ps.setString(3, student.getPassword());
				ps.setString(4, student.getEmail());
				ps.setLong(5, student.getPhone());
				ps.setObject(6, student.getDob());
				ps.setString(7, student.getGender());

				int output = ps.executeUpdate();
				
//				String output=ps.executeUpdate()>0? "Data Entered Successfully": "Something went wrong";

				if (output != 0) {
					System.out.println("Data Stored Successfully!!!");
					return student;
				} else {
					System.out.println("Data NOT SENT!!!");
					return null;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}

		} else {
			System.out.println("!! Connection is not Established !!");
			return null;
		}

	}
	
	
	// >>>>>>>>>>>>>>>>>> get Student detail By Email Password --here we also used (Stored
			// Procedure) <<<<<<<<<<<<<<<<<<<<<<<<<<<<

			public Student getStudentByEmailPasswordDao(String emailInput,String passwordInput) {

				final String GET_CUSTOMER_BY_ID_QUERY = "select * from studentregis WHERE email = ? AND password = ?";

				try {
					PreparedStatement ps=connection.prepareStatement(GET_CUSTOMER_BY_ID_QUERY);
					ps.setString(1, emailInput);
					ps.setString(2, passwordInput);
					ResultSet set = ps.executeQuery();

//					CallableStatement callableStatement = connection.prepareCall("call getCustomerById(?)");
//					callableStatement.setInt(1, id);
//					ResultSet set = callableStatement.executeQuery();

					if (set.next()) {
						int id = set.getInt("id");
						String name = set.getString("name");
						String password=set.getString("password");
						String email = set.getString("email");
						long phoneNumber = set.getLong("phoneNumber");
						LocalDate dob = LocalDate.parse(set.getString("dob"));
						String gender=set.getString("gender");

						Student student=new Student(id, name, password, email, phoneNumber, dob, gender);
//						Student student = new Student();
//						student.setId(id);
//						student.setName(name);
//						student.setPassword(password);
//						student.setEmail(email);
//						student.setPhone(phoneNumber);
//						student.setDob(dob);
//						student.setGender(gender);
						
						System.out.println("Login SuccessFully.");
						return student;

					} else {
						System.out.println("Given Email or Password Does not Matches!!!");
						return null;
					}

				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}

			}
		
			
			
			// >>>>>>>>>>>>>>>>>> Update Student All-Details By Id <<<<<<<<<<<<<<<<<<<<<<<<<<<<

			public boolean updateStudentDetailsById(int targetId, String name,String password, String email, long phoneNumber, LocalDate dob, String gender) {

				final String UPDATE_STUDENT_NAME_BY_ID_QUERY = "Update studentregis set name=?,password=?,email=?,phoneNumber=?,dob=?,gender=? where id=?";

				try {

					PreparedStatement ps = connection.prepareStatement(UPDATE_STUDENT_NAME_BY_ID_QUERY);
					ps.setString(1, name);
					ps.setString(2, password);
					ps.setString(3, email);
					ps.setLong(4, phoneNumber);
					ps.setObject(5, dob);
					ps.setString(6, gender);
					ps.setInt(7, targetId);
					
					

					int a = ps.executeUpdate();

					if (a != 0) {
						System.out.println("Details of target id:" + targetId + " Update Successfully in Student DB. ");
						return true;
					} else {
						System.out.println("Target id:" + targetId + " is not in DB or You Changed the Student ID. ");
						return false;
					}

				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}

			}
			
			
			// >>>>>>>>>>>>>>>>>> Delete Student By Id <<<<<<<<<<<<<<<<<<<<<<<<<<<<

			public boolean deleteStudentById(int targetId) {

				final String DELETE_STUDENT_BY_ID_QUERY = "Delete from studentregis where id=?";

				try {

					PreparedStatement ps = connection.prepareStatement(DELETE_STUDENT_BY_ID_QUERY);
					ps.setInt(1, targetId);

					int affectedRow = ps.executeUpdate(); 

//					return affectedRow>0?true:false;
					
					if (affectedRow != 0) {
						System.out.println("DataRow of Student whose id=" + targetId + " is Deleted Successfully");
						return true;
					}

					else {
						System.out.println("Select ID is not found!!!");
						return false;
					}

				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Something went wrong !!");
					return false;
				}

			}
			
			//get student details by id
			public Student getStudentByIdDao(int targetId) {

				final String GET_CUSTOMER_BY_ID_QUERY = "select * from customer where id=?";

				try {
					PreparedStatement ps=connection.prepareStatement(GET_CUSTOMER_BY_ID_QUERY);

					ps.setInt(1, targetId);
					ResultSet set = ps.executeQuery();


					if (set.next()) {
						int id = set.getInt("id");
						String name = set.getString("name");
						String password=set.getString("password");
						String email = set.getString("email");
						long phoneNumber = set.getLong("phoneNumber");
						LocalDate dob = LocalDate.parse(set.getString("dob"));
						String gender=set.getString("gender");

						Student student=new Student(id, name, password, email, phoneNumber, dob, gender);

						return student;

					} else {
						System.out.println("Given ID is not found!!!");
						return null;
					}

				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}

			}
			
}
