package com.ihaveaname.scala.closure

object Closure {
  private val message = "Hello Clojure"

  def getGreeter: () => String = () => message
}
