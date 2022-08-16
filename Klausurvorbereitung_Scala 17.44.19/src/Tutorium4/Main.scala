package Tutorium4

object Main {

  def main(args: Array[String]): Unit = {
    //Tuples
    val tuple1 = ("Hi", "Nummer", 2)
    println(tuple1._1)

    val red = "red" -> 3
    println(red._2)

    //Match
    val x = 10
    val y = 20

    val max = x > y match {
      case true => x
      case false => y
    }
    println(max)

    //Range
    val list0 = 1 to 10
    val list1 = 1 to 10 by 3
    val list2 = 1 until 10
    println(list0.toList)
    println(list1.toList)
    println(list2.toList)

    //for Notation
    for (x <- 1 to 7) {
      println(s"Day: $x")
    }

    val threes = for (i <- 1 to 20 if i % 3 == 0)
      yield i // sowas wie speicher
    println(threes)

    //while

    var a = 10
    do {
      println(a)
      a -= 1
    }
    while (a != 0)

    //Methods
    val wow = println(name(4, 2))
    println(name1(2, 3))

    //Interpolation
    val namex = "James"
    println(s"Hello, $namex Norrington $name1")

    val height = 1.9d
    val namey = "James"
    println(f"$namey%s is $height%2.2f meters tall")
    println(s"$namey is $height meters tall")


    println(divide(10, toType(divide(10, 5))))


    val parser = "2.0"
    println(toType(parser))

  }

  //methods
  def name: (Int, Int) => Double = (param1, param2) => {
    val res = param1 / param2
    res
  }

  def name1 = (param1: Int, param2: Double) => {
    param1 + param2
  }

  @Override
  def divide(x: Int, y: Double): Any = {

    if (y == 0) {
      println("Division unmöglich")
    } else {
      x / y
    }
  }

  def toType(i: Any): Double =
    i.toString.toDoubleOption match {
      case Some(i) => i.asInstanceOf[Double]
      case None => 0.asInstanceOf[Double]
    }
}