// we can assign code block to filed, and when the code block
// takes long time to run, we could use lazy to modify it.
class Foo {
   lazy val text =  io.Source.fromFile("/Users/tosavana/mashibing.txt").getLines.foreach(println)
}

object Text extends App {
    val f = new Foo
    f.text
}
 