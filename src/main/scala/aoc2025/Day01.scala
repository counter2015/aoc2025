package aoc2025

// problem link: https://adventofcode.com/2025/day/1
object Day01 {

  def parseInput(input: String): Seq[Int] =
    input.trim
      .split("\n")
      .map {
        case s"L$id" => -id.trim.toInt
        case s"R$id" => id.trim.toInt
        case _       => throw new IllegalArgumentException(s"Invalid input: $input")
      }
      .toSeq

  val startPosition = 50
  val totalPositions = 100

  private def nextPosition(position: Int, instruction: Int): Int =
    ((position + instruction) % totalPositions + totalPositions) % totalPositions

  def part1(input: String): Int = {
    val instructions = parseInput(input)
    val (_, count) = instructions.foldLeft((startPosition, 0)) { case ((position, count), instruction) =>
      val newPosition = nextPosition(position, instruction)
      (newPosition, count + (if (newPosition == 0) 1 else 0))
    }
    count
  }

  def part2(input: String): Int = {
    val instructions = parseInput(input)
    val (_, count) = instructions.foldLeft((startPosition, 0)) { case ((position, count), instruction) =>
      val newPosition = nextPosition(position, instruction)

      val newCount = if (instruction > 0) {
        (instruction + position) / totalPositions
      } else if (instruction == 0) {
        0
      } else {
        if (instruction + position <= 0) {
          val overZeroCount = if (position == 0) 0 else 1
          (instruction + position).abs / totalPositions + overZeroCount
        } else {
          0
        }
      }

      (newPosition, count + newCount)
    }
    count
  }
}
