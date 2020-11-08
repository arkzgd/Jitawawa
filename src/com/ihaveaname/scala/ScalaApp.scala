package com.ihaveaname.scala

object ScalaApp extends App {

  val greeter = Closure.getGreeter
  println(greeter())

  val id: Int => Int = Functor.identity
  println(id.apply(3))
}
