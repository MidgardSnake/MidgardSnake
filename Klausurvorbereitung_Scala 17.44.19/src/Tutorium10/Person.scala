package Tutorium10

trait Person {
  def name: String

  def age: Int
}

case class Employee(val name: String, val age: Int,
                    val income: Int) extends Person {

}

object Main {
  def main(args: Array[String]): Unit = {
    val person: Person = new Employee("Anna", 38, 52000)

    person match {
      case Employee(name, _, income) if (income > 50000) =>
        print(name + " do you want to donate?")
    }


  }
}

