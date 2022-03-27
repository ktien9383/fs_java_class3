package com.crud.service;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import com.crud.model.Student;


public class StudentDAO {
	private static Connection getConnection() {
		Connection con=null;
		//Step 1 : load Driver in memory
		try {
			//to call Class loader to load class in memory at dymanic time
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		
			//Step 2: Database information 
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cred", "root","Vietnams$88");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return con;
		
	}
		public int insertData(Student student) {
			int result=0;
			try {
			Connection con=getConnection();
			
			java.sql.Date sdob=new java.sql.Date(student.getDOB().getTime());
			//To insert records 
			PreparedStatement ps=con.prepareStatement("insert into studentDetails(rollno, studname,dob) values(?,?,?)");
			ps.setInt(1,student.getRollno());
			ps.setString(2,student.getStudname());
			ps.setDate(3, sdob);
			result=ps.executeUpdate();
			con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		
		public ArrayList<Student> getRecords(){
			ArrayList<Student> list=new ArrayList<>();
			try {
				Connection con=getConnection();
				//To get all Records
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from studentdetails");
				//Add all Records in ArrayList		
								
				while(rs.next()) {
					
					list.add(new Student(rs.getInt(1),rs.getString(2),rs.getDate(3)));
					
					
					
				}
				stmt.close();
				con.close();
			}
				catch(Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		public Student getStudentByRollno(int rollno) {
			Student student=null;
			try {
				Connection con=getConnection();
				PreparedStatement ps=con.prepareStatement("Select * from studentdetails where rollno=?");
				ps.setInt(1, rollno);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
					student=new Student(rs.getInt(1),rs.getString(2),rs.getDate(3));
				
				con.close();
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		return student;
		}
		public int UpdateData(Student student) {
			int result=0;
			try {
			Connection con=getConnection();
			
			java.sql.Date sdob=new java.sql.Date(student.getDOB().getTime());
			System.out.println(student.getDOB());
			//To insert records 
			PreparedStatement ps=con.prepareStatement("update studentDetails set studname=?,dob=? where rollno=?");
			ps.setInt(3,student.getRollno());
			ps.setString(1,student.getStudname());
			ps.setDate(2, sdob);
			result=ps.executeUpdate();
			con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		public int getStudentIdDelete(int rollno) {
			int result=0;
			try {
			Connection con=getConnection();
			
			
			//To insert records 
			PreparedStatement ps=con.prepareStatement("delete from studentdetails where rollno=?");
			
			ps.setInt(1,rollno);
			
			result=ps.executeUpdate();
			con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return result;
		}
}
