package Chap5.sec15DefiningAuxiliaryConstructorsForCaseClasses

class DefiningAuxiliaryConstructorsForCaseClasses {
  /**
   * Problem
   * Similar to the previous recipe, you want to define one or more auxiliary constructors for a case class rather than a plain class.
   * Solution
   * A case class is a special type of class that generates a lot of boilerplate code for you. Because of the way they work,
   * adding what appears to be an auxiliary constructor to a case class is different than adding an auxiliary constructor to a regular class.
   * This is because they’re not really constructors: they’re apply methods in the companion object of the class.
   * To demonstrate this, start with this case class in a file named Person.scala: // initial case class
   * case class Person(var name: String, var age: Int) This lets you create a new Person instance:
   * val p = Person("John Smith", 30)
   * While this code looks the same as a regular class, it’s actually implemented differ‐ ently. When you write that last line of code,
   * behind the scenes the Scala compiler con‐ verts it into this:
   * val p = Person.apply("John Smith", 30)
   *
   * This is a call to an apply method in the companion object of the Person class. You don’t see this—you just see the line that you wrote—but
   * this is how the compiler translates your code. As a result, if you want to add new constructors to your case class, you write new apply
   * methods. (To be clear, the word constructor is used loosely here. Writing an apply method is more like writing a factory method.)
   * For instance, if you decide that you want to add two auxiliary constructors to let you create new Person instances, one without specifying
   * any parameters and another by only specifying name, the solution is to add apply methods to the companion object of the Person case class
   * in the Person.scala file:
   */
}

case class Person(var name: String, var age: Int)

// the companion object
object Person {
  // This is one of the rare situtaions where new is required, in this situation, it tells the
  // compiler to use the class constructor.
  def apply() = new Person("<no name>", 0)

  def apply(name: String) = new Person(name, 0)

}

object Test extends App {
  val a = Person
  val b = Person("Sarah")
  val c = Person("Sarah", 32)
}