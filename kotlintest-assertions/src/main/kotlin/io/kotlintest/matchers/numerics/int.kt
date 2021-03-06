package io.kotlintest.matchers.numerics

import io.kotlintest.Matcher
import io.kotlintest.Result

fun even() = object : Matcher<Int> {
  override fun test(value: Int): Result =
      Result(value % 2 == 0, "$value should be even", "$value should be odd")
}

fun odd() = object : Matcher<Int> {
  override fun test(value: Int): Result =
      Result(value % 2 == 1, "$value should be odd", "$value should be even")
}