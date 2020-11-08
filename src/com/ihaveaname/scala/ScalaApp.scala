package com.ihaveaname.scala

object ScalaApp extends App {

  val greeter = Closure.getGreeter
  print(greeter())
}
