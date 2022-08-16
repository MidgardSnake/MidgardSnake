package Tutorium5

class Main {





}

object Main {
  var global = 2
  def main(args: Array[String]): Unit = {



    val multWith: Int => Int = {
      (y) => global *y
    }

    println(multWith(3))
    println(global)

    global = multWith(4)

    println(global)
  }


}



