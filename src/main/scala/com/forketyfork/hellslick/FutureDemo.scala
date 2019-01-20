package com.forketyfork.hellslick

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

object FutureDemo extends App {

  // первая футура формирует и возвращает строку
  def getFuture1 = Future {
//    "1337"
    List("1337", "1111", "2222", "3333")
  }

  // вторая футура из строки делает число
  def getFuture2(nums: List[String]) = Future { //todo  это `Future` - класс который позволяет получать результаты (не сразу, а) дожидаясь окончания выполнения...
//    num.toInt
    val result = for { //todo  умный цыкл (он может быть вложенным)...
      num <- nums //todo  здесь из списка вытягиваем каждый элемент по порядку...
    } yield num.toInt
    result //todo  вместо `return result;` можно писать просто `result`...
  }

  // комбинированная футура, созданная с использованием for-включения
  val composedFuture1 = for {
    future1 <- getFuture1
    future2 <- getFuture2(future1)
  } yield future2
  println( Await.result(composedFuture1, 1.second) ) //todo  метод класса `Await.result` - стартует выполнения под-программы в отдельном потоке + ограничивает ожидание результатов выполения в 1-секунду

  // комбинированная футура, созданная с использованием flatMap и map
  val composedFuture2 = getFuture1.flatMap {
    result1 =>
      getFuture2(result1).map { result2 => result2 }
  }

  println( Await.result(composedFuture2, 1.second) )
}
