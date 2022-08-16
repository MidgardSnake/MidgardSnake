package Tutorium7

class User2 ( name: String) {
  val status: String = "Studierender"

  def greet: String = s"Grüße von $name"

  override def toString = s"User ($name)"
}

object Main{
  def main(args: Array[String]): Unit = {
    val x = new User2("bambus")
    println(x.greet)
  }
}