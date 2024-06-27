package Chap5.Sec14GeneratingBoilerplateCodeWithCaseClasses

class GeneratingBoilerPlateCodeWithCaseClasses {
  /**
   * Problem
   * You’re working with match expressions, Akka actors, or other situations where you
   * want to use the case class syntax to generate boilerplate code, including accessor
   * and mutator methods, along with apply, unapply, toString, equals, and hashCode methods,
   * and more.
   */
  /**
   * Solution
   * When you want your class to have many additional built-in features—such as creat‐
   * ing classes in functional programming—define your class as a case class, declaring any parameters it needs in its constructor:
   * // name and relation are 'val' by default
   * case class Person(name: String, relation: String)
   * Defining a class as a case class results in a lot of useful boilerplate code being generated, with the following benefits:
   * • Accessor methods are generated for the constructor parameters because case class constructor parameters are val by default.
   * Mutator methods are also generated for parameters that are declared as var.
   * • A good default toString method is generated.
   * • An unapply method is generated, making it easy to use case classes in match
   * expressions.
   * • equals and hashCode methods are generated, so instances can easily be com‐ pared and used in collections.
   */
  // case class constructor parameters are val by default, non mutable.
  /**
   * Case objects
   * Scala also has case objects, which are similar to case classes in that many similar additional methods are generated.
   * Case objects are useful in certain situations, such as when creating immutable messages for Akka actors:
   * sealed trait Message
   * case class Speak(text: String) extends Message
   * case object StopSpeaking extends Message
   * In this example, Speak requires a parameter, so it's declared as a case class, but StopSpeaking requires no parameter, so it's
   * declared as a case object.
   *
   * However, note in Scala3, enums can often be used instead of case objects:
   * enum Message:
   *  case Speak(text: String)
   *  case StopSpeaking
   */
}
