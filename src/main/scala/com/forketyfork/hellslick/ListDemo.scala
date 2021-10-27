package com.forketyfork.hellslick

object ListDemo extends App {

  // списки
  val people = List("Воронин", "Гейгер", "Убуката")
  val positions = List("мусорщик", "следователь", "редактор", "xxx")


  // декартово произведение списков с использованием for-включения:
  val peoplePositions1 = for {             //TODO:  умный вложенный цикл (он определяет размер каждого из списков)
    person <- people                       //TODO:  список String-ов возвращает String
    position <- positions                  //TODO:  список String-ов возвращает String
  } yield s"$person = $position"           //TODO:  объединяем (контенируем) строки...

  println( peoplePositions1 )
  println( "#0  " + peoplePositions1(0) )  //TODO  доступ к элементу списка по индексу
  println( "#1  " + peoplePositions1(1) )
  println( "#2  " + peoplePositions1(2) )


  val peoplePositions2 = people.map {      //TODO:  вложенный цикл в отдельном 1-потоке
    person =>
      positions.map {
        position => s"$person = $position" //TODO:  объединяем (контенируем) строки...
      }
  }
  println(peoplePositions2)
  // декартово произведение списков прямым вызовом flatMap и map:
  val peoplePositions3 = people.flatMap {  //TODO:  вложенный цикл в отдельных N-потоков
    person =>
      positions.map {
        position => s"$person = $position" //TODO:  объединяем (контенируем) строки...
    }
  }
  println(peoplePositions2)
}
