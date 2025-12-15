package aoc2025

import scala.collection.mutable.ArrayBuffer

// problem link: https://adventofcode.com/2025/day/6
object Day06 {
  case class Problem(nums: List[Int], op: Char) {
    def solution: BigInt =
      nums
        .map(BigInt(_))
        .reduceLeft((a, b) =>
          op match {
            case '*' => a * b
            case '+' => a + b
            case _   => throw new IllegalArgumentException(s"Invalid operator: $op")
          }
        )
  }

  object Problem {
    def fromRaw(raw: Array[String]): Problem = {
      val op = raw.last.head
      val nums = raw.init.map(_.trim.toInt).toList
      Problem(nums, op)
    }
  }

  def parseInput(input: String): List[Problem] = {
    val lines = input.trim.split("\n")
    val rawData = lines.map(_.trim.split("\\s+")).transpose
    rawData.map(Problem.fromRaw).toList
  }

  def parseInput2(input: String): List[Problem] = {
    val rawData = input.trim.split("\n").map(_.toCharArray).transpose.reverse
    val nums = ArrayBuffer.empty[Int]
    val problems = ArrayBuffer.empty[Problem]

    rawData
      .map(_.mkString.trim)
      .filter(_.nonEmpty)
      .foreach(token =>
        if (token.nonEmpty && (token.endsWith("+") || token.endsWith("*"))) {
          val num = token.init.trim
          val op = token.last
          nums += num.toInt
          problems += Problem(nums.toList, op)
          nums.clear()
        } else {
          nums += token.trim.toInt
        }
      )

    problems.toList
  }

  def part1(input: String): BigInt =
    parseInput(input).map(_.solution).sum

  def part2(input: String): BigInt =
    parseInput2(input).map(_.solution).sum
}
