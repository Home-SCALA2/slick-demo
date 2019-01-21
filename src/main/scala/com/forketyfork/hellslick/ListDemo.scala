//package com.forketyfork.hellslick
//
//object ListDemo extends App {
//
//  // списки
//  val people = List("Воронин", "Гейгер", "Убуката")
//  val positions = List("мусорщик", "следователь", "редактор", "xxx")
//
//
//  // декартово произведение списков с использованием for-включения:
//  val peoplePositions1 = for { //todo:  умный вложенный цыкл (он определяет размер каждого из списков)
//    person <- people      //todo:  список String-ов возвращает String
//    position <- positions //todo:  список String-ов возвращает String
//  } yield s"$person = $position" //todo:  объединяем (контенируем) строки...
//  println( peoplePositions1 )
//  println( "#0  " + peoplePositions1(0) ) //todo  доступ к элементу списка по индексу
//  println( "#1  " + peoplePositions1(1) )
//  println( "#2  " + peoplePositions1(2) )
//
//
//  val peoplePositions2 = people.map { //todo:  вложенный цыкл в отдельном 1-потоке
//    person =>
//      positions.map {
//        position => s"$person = $position" //todo:  объединяем (контенируем) строки...
//      }
//  }
//  println(peoplePositions2)
//  // декартово произведение списков прямым вызовом flatMap и map:
//  val peoplePositions3 = people.flatMap { //todo:  вложенный цыкл в отдельных N-потоков
//    person =>
//      positions.map {
//        position => s"$person = $position" //todo:  объединяем (контенируем) строки...
//    }
//  }
//  println(peoplePositions2)
//}
