package com.knoldus

/**
  * Created by akhil on 1/2/17.
  */
import org.scalatest.FunSuite
class EmployeeTableTest extends FunSuite{
  val employee = new EmployeeTableHandler

  test("select employee table") {
    assert(employee.selectTable() == true)
  }
  test("Insert into employee table") {
    assert(employee.insertTable(1234,"Akhil","Mayur Vihar",8800377,4321,1423) == true)
  }
  test("Update employee table") {
    assert(employee.updateTable(1234,"Akhil","Mayur Vihar",8800377,4321,1423) == true)
  }
  test("Delete employee table") {
    assert(employee.deleteTable(1234) == true)
  }
}
