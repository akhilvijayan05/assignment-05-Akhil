package com.knoldus

/**
  * Created by akhil on 1/2/17.
  */
import org.scalatest.FunSuite
class EmployeeTableTest extends FunSuite{
  val Sbt = new EmployeeTableHandler
  val list=List(Employee(1234,"Akhil","Mayur Vihar",8800377,4321,1423),Department(4321,"Software"),Project(1423,4321,"SBT Project",3412),Client(3412,1423,"Raj","Mayur Vihar"))
  test("select employee table") {
    list.foreach(obj=>assert(Sbt.selectTable(obj) == true))
  }
  test("Insert into employee table") {
    list.foreach(obj=>assert(Sbt.insertTable(obj) == true))
  }
  test("Update employee table") {
    list.foreach(obj=>assert(Sbt.updateTable(obj) == true))
  }
  test("Delete employee table") {
    list.foreach(obj=>assert(Sbt.deleteTable(obj) == true))
  }
}
