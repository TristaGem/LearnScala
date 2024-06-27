package Chap5

class sec10ExtendClass {

}
case class Address(city: String, state: String, zip: String = "")
class Person(var name: String, var address: Address) {
  override def toString = if (address == null) name else s"$name @ $address"
}

class Employee(name: String, address: Address, var age: Int) extends Person(name, address) {

}

object Test extends App {
  val teresa = new Employee("Teresa", Address("Lynnwood", "WA"), 25)
  println(teresa.name)
  println(teresa.address)
  println(teresa.age)
}


