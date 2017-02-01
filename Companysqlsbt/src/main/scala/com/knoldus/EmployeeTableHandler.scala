package com.knoldus

/**
  * Created by akhil on 1/2/17.
  */
import java.sql.{Connection, DriverManager}
class EmployeeTableHandler {
  val url = "jdbc:mysql://localhost/employee"
  val driver = "com.mysql.jdbc.Driver"
  val username = "root"
  val password = "akhil"
  var connection: Connection = DriverManager.getConnection(url, username, password)

  def selectTable(Obj:Any) = {

    Obj match {

      case obj: Employee => {
        try {
          Class.forName(driver)
          val statement = connection.createStatement
          val rs = statement.executeQuery("Select * FROM Employee")
          while (rs.next) {
            val Emp_ID = rs.getString(1)
            val Name = rs.getString(2)
            val Address = rs.getString(3)
            val Phone = rs.getString(4)
            val Dept_ID = rs.getString(5)
            val Project_ID = rs.getString(6)
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
      case obj: Department => {
        try {
          Class.forName(driver)
          val statement = connection.createStatement
          val rs = statement.executeQuery("Select * FROM Department")
          while (rs.next) {
            val Dept_ID = rs.getString(1)
            val Name = rs.getString(2)
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
      case obj: Project => {
        try {
          Class.forName(driver)
          val statement = connection.createStatement
          val rs = statement.executeQuery("Select * FROM Project")
          while (rs.next) {
            val Project_ID = rs.getString(1)
            val Dept_ID = rs.getString(2)
            val Name = rs.getString(3)
            val Client_ID = rs.getString(4)
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
      case obj: Client => {
        try {
          Class.forName(driver)
          val statement = connection.createStatement
          val rs = statement.executeQuery("Select * FROM Client")
          while (rs.next) {
            val Client_ID = rs.getString(1)
            val Project_ID = rs.getString(2)
            val Name = rs.getString(3)
            val Address = rs.getString(4)
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
      case _: Any => {
        println("wrong input");
        false
      }
    }
  }
  def insertTable(Obj: Any) = {
    Obj match {
      case obj:Employee=>{
        try {
          Class.forName(driver)
          val statement = connection.createStatement
          val rs = statement.executeUpdate("insert into Employee(Emp_ID,Name,Address,Phone,Dept_ID,Project_ID) values('" + obj.Emp_ID + "','" + obj.Name + "','" + obj.Address + "','" + obj.Phone + "','" + obj.Dept_ID + "','" + obj.Project_ID + "')")
        } catch {
          case e: Exception => {
            e.printStackTrace;
            false
          }
        }
        connection.close
        true
      }
      case obj:Department=>{
        try {
          Class.forName(driver)
          val statement = connection.createStatement
          val rs = statement.executeUpdate("insert into Department(Dept_ID,Name) values('" + obj.Dept_ID + "','" + obj.Name + "')")
        } catch {
          case e: Exception => {
            e.printStackTrace;
            false
          }
        }
        connection.close
        true
      }
      case obj:Project=>{
        try {
          Class.forName(driver)
          val statement = connection.createStatement
          val rs = statement.executeUpdate("insert into Project(Project_ID,Dept_ID,Name,Client_ID) values('" + obj.Project_ID + "','" + obj.Dept_ID + "','" + obj.Name + "','" + obj.Client_ID + "')")
        } catch {
          case e: Exception => {
            e.printStackTrace;
            false
          }
        }
        connection.close
        true
      }
      case obj:Client=>{
        try {
          Class.forName(driver)
          val statement = connection.createStatement
          val rs = statement.executeUpdate("insert into Client(Client_ID,Project_ID,Name,Address) values('" + obj.Client_ID + "','" + obj.Project_ID + "','" + obj.Name + "','" + obj.Address + "')")
        } catch {
          case e: Exception => {
            e.printStackTrace;
            false
          }
        }
        connection.close
        true
      }
      case _:Any=>{println("Wrong Input");false}
    }

  }

  def updateTable(Obj:Any) = {

    Obj match {
      case obj:Employee=>{
        try {
          Class.forName(driver)
          val statement = connection.createStatement
          val rs = statement.executeUpdate("update Employee SET Name='" + obj.Name + "',Address='" + obj.Address + "',Phone='" + obj.Phone + "',Dept_ID='" + obj.Dept_ID + "',Project_ID='" + obj.Project_ID + "' where Emp_ID=='" + obj.Emp_ID + "'")
        } catch {
          case e: Exception => {
            e.printStackTrace;
            false
          }
        }
        connection.close
        true
      }
      case obj:Department=>{
        try {
          Class.forName(driver)
          val statement = connection.createStatement
          val rs = statement.executeUpdate("update Department SET Name='" + obj.Name + "' where Dept_ID='"+obj.Dept_ID+"'")
        } catch {
          case e: Exception => {
            e.printStackTrace;
            false
          }
        }
        connection.close
        true
      }
      case obj:Project=>{
        try {
          Class.forName(driver)
          val statement = connection.createStatement
          val rs = statement.executeUpdate("update Project SET Dept_ID='" + obj.Dept_ID + "',Name='" + obj.Name + "',Client_ID='" + obj.Client_ID + "' where Project_ID=='" + obj.Project_ID + "'")
        } catch {
          case e: Exception => {
            e.printStackTrace;
            false
          }
        }
        connection.close
        true
      }
      case obj:Client=>{
        try {
          Class.forName(driver)
          val statement = connection.createStatement
          val rs = statement.executeUpdate("update Client SET Project_ID='" + obj.Project_ID + "',Name='" + obj.Name + "',Address='" + obj.Address + "' where Client_ID=='" + obj.Client_ID + "'")
        } catch {
          case e: Exception => {
            e.printStackTrace;
            false
          }
        }
        connection.close
        true
      }
      case _:Any=>{println("Wrong Input");false}
    }
  }

  def deleteTable(Obj:Any) = {

    Obj match {
      case obj: Employee => {
        try {

          Class.forName(driver)
          val statement = connection.createStatement
          val rs = statement.executeUpdate("Delete from Employee where Emp_ID=='" + obj.Emp_ID + "'")
        } catch {

          case e: Exception => {

            e.printStackTrace;
            false
          }
        }
        connection.close
        true
      }
      case obj: Department => {
        try {

          Class.forName(driver)
          val statement = connection.createStatement
          val rs = statement.executeUpdate("Delete from Department where Dept_ID=='" + obj.Dept_ID + "'")
        } catch {

          case e: Exception => {

            e.printStackTrace;
            false
          }
        }
        connection.close
        true
      }
      case obj: Project => {
        try {

          Class.forName(driver)
          val statement = connection.createStatement
          val rs = statement.executeUpdate("Delete from Project where Project_ID=='" + obj.Project_ID + "'")
        } catch {

          case e: Exception => {

            e.printStackTrace;
            false
          }
        }
        connection.close
        true
      }
      case obj: Client => {
        try {

          Class.forName(driver)
          val statement = connection.createStatement
          val rs = statement.executeUpdate("Delete from Client where Client_ID=='" + obj.Client_ID + "'")
        } catch {

          case e: Exception => {

            e.printStackTrace;
            false
          }
        }
        connection.close
        true
      }
      case _: Any => {
        println("Wrong Input");
        false
      }
    }
  }
}