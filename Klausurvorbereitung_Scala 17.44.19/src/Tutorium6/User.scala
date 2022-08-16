package Tutorium6

class User(val name: String) {

  def greet: String = {
    s"Hello $name"
  }

}

object User {
  def main(args: Array[String]): Unit = {
    val x = new User("Heinz")

    println(x.greet)
  }
}

object User1 extends App {
  println("Hunz")
}

