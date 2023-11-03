package Employee_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeManagementSystem {
    // Database connection and operations
    // - Implement methods to insert, update, and retrieve employee data
    // - Implement methods to insert and retrieve attendance data
    // - Implement methods to calculate pay details

    public void insertEmployee(String eid,String ename) {
        // Code to insert employee data into the database
    	try {
			Connection con=DriverManager.getConnection("jdbc:mysql:///templo","root","root");
			Statement st=con.createStatement();
			//String query="select *from templo. where studentid=1";
			String query="insert into templo.tempdetails values ('"+eid+"','"+ename+"')";
			//ResultSet rs = st.executeQuery(query);
			int i=st.executeUpdate(query);
			
			if(i==1) {
				System.out.println("inserted");
				
			}
			else {
				System.out.println("not");
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
    }

     public void updateEmployee(String eid,String uename) {
//         Code to update employee data in the database
    	  try {
  			Connection con=DriverManager.getConnection("jdbc:mysql:///templo","root","root");
  			Statement st=con.createStatement();
  			//String query="select *from templo. where studentid=1";
  			String query="update templo.tempdetails set tename='"+uename+"' where tempid='"+eid+"'";
  			//ResultSet rs = st.executeQuery(query);
  			int i=st.executeUpdate(query);
  			
  			if(i==1) {
  				System.out.println("updated");
  				
  			}
  			else {
  				System.out.println("not");
  			}
  			
  		}
  		catch(Exception e) {
  			System.out.println(e);
  		}
    	  
      }
//     public void getEmployeeById(String empId) {
//         // Code to retrieve an employee by empId from the database
//    	 try {
//   			Connection con=DriverManager.getConnection("jdbc:mysql:///templo","root","root");
//   			Statement st=con.createStatement();
//   			//String query="select *from templo. where studentid=1";
//   			String query="select *from templo.tempdetails where tempid='"+empId+"'";
//   			ResultSet rs = st.executeQuery(query);
//   			while(rs.next()) {
//   				System.out.println(rs.getString(1)+" "+rs.getString(2));
//   			}
//   			
//   		}
//   		catch(Exception e) {
//   			System.out.println(e);
//   		}
     
		
//    	 
//      
//      
//}

	public void getEmployeeById(String empid) {
		// TODO Auto-generated method stub
		try {
   			Connection con=DriverManager.getConnection("jdbc:mysql:///templo","root","root");
   			Statement st=con.createStatement();
   			//String query="select *from templo. where studentid=1";
   			String query="select *from templo.tempdetails where tempid='"+empid+"'";
   			ResultSet rs = st.executeQuery(query);
   			while(rs.next()) {
   				System.out.println(rs.getString(1)+" "+rs.getString(2));
   			}
   			
   		}
   		catch(Exception e) {
   			System.out.println(e);
   		}
		
	}
	
	public void insertEmployeeAttendance(String empid,int dayspresent) {
        // Code to insert attendance data into the database
		
		int salperday=1000;
		int def=salperday*dayspresent;
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql:///templo","root","root");
			Statement st=con.createStatement();
			
			//String query="select *from templo. where studentid=1";
			String query="insert into templo.emp_sal values ('"+empid+"',"+dayspresent+","+def+")";
			//ResultSet rs = st.executeQuery(query);
			int i=st.executeUpdate(query);
			
			if(i==1) {
				System.out.println("salary updated ");
				
			}
			else {
				System.out.println("not");
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
    }

	public void getEmployeesalarydetails(String empid) {
		// TODO Auto-generated method stub
		try {
   			Connection con=DriverManager.getConnection("jdbc:mysql:///templo","root","root");
   			Statement st=con.createStatement();
   			//String query="select *from templo. where studentid=1";
   			String query="select * from templo.tempdetails right join templo.emp_sal on  templo.tempdetails.tempid=templo.emp_sal.tempid where templo.emp_sal.tempid='"+empid+"'";
   			
   			
   			ResultSet rs = st.executeQuery(query);
   			while(rs.next()) {
   				
   				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(4)+" "+rs.getInt(5));
   			}	
   			
   			
   		}
   		catch(Exception e) {
   			System.out.println(e);
   		}
		
		
	}

	
}
	