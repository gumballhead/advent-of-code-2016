package com.adventofcode.day3

fun main(args: Array<String>) = println(TriangleIterator().asSequence().count(::isValidTriangle))
