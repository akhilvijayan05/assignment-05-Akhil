package com.knoldus

/**
  * Created by akhil on 1/2/17.
  */
import java.sql.{Connection, DriverManager, PreparedStatement}
class EmployeeTableHandler {
  val url = "jdbc:mysql://localhost/employee"
  val driver = "com.mysql.jdbc.Driver"
  val username = "root"
  val password = "akhil"
  var connection: Connection = DriverManager.getConnection(url, username, password)

  def selectTable() = {

    try {
      Class.forName(driver)
      val statement = connection.createStatement
      val rs = statement.executeQuery("Select * FROM Employee")
      while (rs.next) {
        val host = rs.getString(1)
        val user = rs.getString(2)
        println("%s, %s".format(rs.getString(1), rs.getString(2)))
      }
    } catch {
      case e: Exception => {
        e.printStackTrace;
        false
      }
    }
    connection.close
    true
  }

  def insertTable(Emp_ID: Int, Name: String, Address: String, Phone: Int, Dept_ID: Int, Project_ID: Int) = {

    try {
      Class.forName(driver)
      val statement = connection.createStatement
      val rs = statement.executeUpdate("insert into Employee(Emp_ID,Name,Address,Phone,Dept_ID,Project_ID) values('" + Emp_ID + "','" + Name + "','" + Address + "','" + Phone + "','" + Dept_ID + "','" + Project_ID + "')")
    } catch {
      case e: Exception => {
        e.printStackTrace;
        false
      }
    }
    connection.close
    true
    /*try {
      Class.forName(driver)
      val statement = connection.createStatement
      val rs = statement.executeUpdate("insert into Department(Dept_ID,Name) values('"+Emp_ID+"','"+Name+"')")
    } catch {
      case e: Exception => {
        e.printStackTrace; false}
    }
    connection.close
    true*/
  }

  def updateTable(Emp_ID: Int, Name: String, Address: String, Phone: Int, Dept_ID: Int, Project_ID: Int) = {

    try {
      Class.forName(driver)
      val statement = connection.createStatement
      val rs = statement.executeUpdate("update Employee SET where Name='" + Name + "',Address='" + Address + "',Phone='" + Phone + "',Dept_ID='" + Dept_ID + "',Project_ID='" + Project_ID + "' where Emp_ID=='" + Emp_ID + "'")
    } catch {
      case e: Exception => {
        e.printStackTrace;
        false
      }
    }
    connection.close
    true
    /*try {
      Class.forName(driver)
      val statement = connection.createStatement
      val rs = statement.executeUpdate("update Department SET Name='" + Name + "' where Dept_ID='"+Dept_ID+"'")
    } catch {
      case e: Exception => {
        e.printStackTrace;
        false
      }
    }
    connection.close
    true*/
  }

  def deleteTable(Emp_ID: Int) = {

    try {

      Class.forName(driver)
      val statement = connection.createStatement
      val rs = statement.executeUpdate("Delete from Employee where Emp_ID=='" + Emp_ID + "'")
    } catch {

      case e: Exception => {

        e.printStackTrace;
        false
      }
    }
    connection.close
    true
  }
}