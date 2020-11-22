package com.ihaveaname.scala.monad

/*
 *  left-identity law:
 *    unit(x).flatMap(f) == f(x)
 *  right-identity law:
 *    m.flatMap(unit) == m
 *  associativity law:
 *    m.flatMap(f).flatMap(g) == m.flatMap(x ⇒ f(x).flatMap(g))
 */

sealed trait Monad[A] {
  def flatMap[B](f: A => Monad[B]): Monad[B]
}

sealed trait MonadBuilder[A] {
  def buildMonad: A => Monad[A]
}

object MonadApp extends App {
  val unit: Int => List[Int] = (i: Int) => List(i)
  val f: Int => List[Int] = (i: Int) => List(i + 1, i, i - 1)
  val g: Int => List[Int] = (i: Int) => List(i / 2, i, i * 2)

  val x = 3
  val monad = unit(x)

  print(s"${monad.flatMap(f)} vs. ${f(x)}\n")
  print(s"${monad.flatMap(unit)} vs. ${monad}\n")
  print(s"${monad.flatMap(f).flatMap(g)} vs. ${monad.flatMap(i => f(i).flatMap(g))}")
}