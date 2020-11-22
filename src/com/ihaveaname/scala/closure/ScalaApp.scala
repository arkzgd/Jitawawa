package com.ihaveaname.scala.closure

object ScalaApp extends App {

  val greeter = Closure.getGreeter
  println(greeter())
}
