package Tutorium9

class RedMini (val year: Int)extends Car{

  override def color: String = "Red"
}

object RedMini extends App {
  val auto = new RedMini(2005)
  println(auto.year)
  println(auto.color)
}
