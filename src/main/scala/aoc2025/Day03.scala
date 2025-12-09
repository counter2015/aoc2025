package aoc2025

import scala.annotation.tailrec

// problem link: https://adventofcode.com/2025/day/3
object Day03 {
  def parseInput(input: String): Seq[String] =
    input.trim
      .split("\n")
      .map(_.trim)
      .toSeq

  def maxJoltage(bank: String, m: Int): Long = {
    val digits = bank.map(_.asDigit)
    val n = digits.length

    @tailrec
    def loop(pos: Int, start: Int, res: Long): Long =
      if (pos >= m) {
        res
      } else {

        val end = n - (m - pos)

        var bestIdx = start
        var bestVal = digits(start)
        var i = start + 1
        while i <= end do
          val d = digits(i)
          if d > bestVal then
            bestVal = d
            bestIdx = i
          i += 1

        loop(pos + 1, bestIdx + 1, res * 10 + bestVal)
      }

    loop(0, 0, 0L)
  }

  def part1(input: String): Long = {
    val banks = parseInput(input)
    banks.map(bank => maxJoltage(bank, 2)).sum
  }

  def part2(input: String): Long = {
    val banks = parseInput(input)
    banks.map(bank => maxJoltage(bank, 12)).sum
  }

}
