package Tutorium7

class Person2 {
  private var
  _age=0
  def age=_age

  def age_=(newAge: Int)={
    if (newAge >_age) _age=newAge
  }

}

  object Person2 extends App{
    val kai = new Person2
    println(kai.age)

    kai.age = 21
    println(kai.age)

    kai.age_=(27)
    println(kai.age)

    kai.age


  }