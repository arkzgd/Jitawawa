package com.ihaveaname.scala.functor

object ScalaApp extends App {
  val id: Int => Int = Functor.identity
  println(id.apply(3))
}
