// To get a singleton
// 1. make the main constructor private
// 2. then make the companion object a getInstance method
class Brain private {
  override def toString = "This is the brain."
}

object Brain {
  val brain = new Brain
  def getInstance = brain
}

object SingletonTest {
  /**
   * this won't compile
   * val brain = new Brain

   */
  def main(args: Array[String]): Unit = {
    val brain = Brain.getInstance
    println(brain)
  }
}