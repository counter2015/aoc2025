package aoc2025

import scala.collection.immutable.NumericRange

// problem link: https://adventofcode.com/2025/day/2
object Day02 {
  
  def parseInput(input: String): Seq[NumericRange.Inclusive[Long]] = {
    input.trim
      .split(",")
      .map(_.trim)
      .map {
        case s"$start-$end" => start.toLong to end.toLong
        case _ => throw new IllegalArgumentException(s"Invalid input: $input")
      }
      .toSeq
  }

  def isInvalid(n: Long, partNum: Int): Boolean = {
    val length = n.toString.length
    length % partNum == 0 && n.toString.take(length / partNum) * (partNum) == n.toString
  }

  def isInvalidAll(n: Long): Boolean = {
    val length = n.toString.length
    (2 to length).exists(i => isInvalid(n, i))
  }

  def part1(input: String): Long = {
    val ranges = parseInput(input)
    val result = ranges.flatMap(_.toSeq).filter(n => isInvalid(n, 2))
    result.sum
  }

  def part2(input: String): Long = {
    val ranges = parseInput(input)
    val result = ranges.flatMap(_.toSeq).filter(isInvalidAll)
    result.sum
  }

}