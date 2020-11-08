package com.ihaveaname.scala

object Closure {
  private val message = "Hello Clojure"

  def getGreeter: () => String = () => message
}