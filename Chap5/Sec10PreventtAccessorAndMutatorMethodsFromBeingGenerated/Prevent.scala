package Chap5.Sec10PreventtAccessorAndMutatorMethodsFromBeingGenerated

class Prevent {
  /**Problem
   *When you define a class field as a var, Scala automatically generates accessor (getter)
   *and mutator (setter) methods for it, and defining a field as a val automatically gener‐
   *ates an accessor method, but you don’t want either an accessor or a mutator.
   * Solution
   * The solution is to either:
   * • Add the private access modifier to the val or var declaration so it can only be
   * accessed by instances of the current class
   * • Add the protected access modifier so it can be accessed by classes that extend
   * the current class
   */
}
class Animal {
  private var _numLegs = 2
  def numLegs = _numLegs // getter
  // Note the _= immediately after the method name, which is part of Scala's syntax for setters.
  def numLegs_= (numLegs: Int): Unit = _numLegs = numLegs //setter

  // note we can access the `_numLegs` field of another animal instance
  def iHaveMoreLegs(that: Animal): Boolean =
    this._numLegs > that._numLegs
}

// you can't modify the numLegs inside Dog, because it's private, change it from private to protected will work
//class Dog extends Animal {
//  _numLegs = 4
//}

object Test extends App {
  val a = new Animal()
  assert(a.numLegs == 2)

  a.numLegs = 4
  assert(a.numLegs == 4)

  val b = new Animal()
  assert(a.iHaveMoreLegs(b))

  // error, you can't access private field
//  println(a._numLegs)
}