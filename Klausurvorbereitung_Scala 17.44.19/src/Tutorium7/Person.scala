package Tutorium7

class Person extends App{

  private var name = ""
  private var age = -1

  def this(name:String){
    this()
    this.name= name
  }

  def this(name:String, age:Int){
    this(name)
    this.age = age
  }

}
object Person extends App{
  val p1 = new Person("Alex")
  val p2 = new Person( "Hubert", 99)
  val p3 = new Person

  p3.name = "Hubert"
}
