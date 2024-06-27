package Chap5.Sec8SuperClassConstructor

class sec8SuperClassConstructor {
  /**
   * Problem
   * You want to control the superclass constructor that’s called when you define con‐
   * structors in a subclass.
   * Solution
   * This is a bit of a trick question, because you can control the superclass constructor
   * that’s called by the primary constructor in a subclass, but you can’t control the super‐
   * class constructor that’s called by an auxiliary constructor in the subclass.
   */
}
case class Address(city: String, state: String, zip: String)

case class Role(role: String)

class Person(var name: String, var address: Address) {
  //no way for Employee auxiliary constructors to call this constructor
  def this (name: String) = {
    this(name, null)
  }
}

class Employee(name: String, var role: Role, address: Address) extends Person(name, address) {
  def this(name: String, role: Role) = {
    this(name, role, null)
  }

  override def toString = s"$name is ${role.role} with address $address"

}

// primary constructor can use any superclass constructor
class Employee2(name: String, role: Role, address: Address) extends Person(name) {
  def this(name: String, role: Role) = {
    this(name, role, null)
  }

}

object Test extends App {
  val employee = new Employee("Trista", role = Role("CEO"))
  println(employee)

  val employee2 = new Employee("Trista", role = Role("CEO"))
  println(employee2)
}

