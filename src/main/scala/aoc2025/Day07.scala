package aoc2025

import scala.annotation.tailrec

// problem link: https://adventofcode.com/2025/day/7
object Day07 {

  def parseInput(input: String): Array[Array[Char]] =
    input.trim.split("\n").map(_.trim.toCharArray)

  def findPath(diagram: Array[Array[Char]], startX: Int): Set[(Int, Int)] = {
    @tailrec
    def loop(work: List[(Int, Int)], visited: Set[(Int, Int)], splits: Set[(Int, Int)]): Set[(Int, Int)] =
      work match {
        case Nil            => splits
        case (x, y) :: rest =>
          if (y >= diagram.length || y < 0 || x < 0 || x >= diagram(y).length || visited.contains((x, y))) {
            loop(rest, visited, splits)
          } else
            diagram(y)(x) match {
              case 'S' | '.' =>
                loop((x, y + 1) :: rest, visited + ((x, y)), splits)
              case '^' =>
                val updatedSplits = splits + ((x, y))
                val next = (x - 1, y + 1) :: (x + 1, y + 1) :: rest
                loop(next, visited + ((x, y)), updatedSplits)
              case _ =>
                loop(rest, visited + ((x, y)), splits)
            }
      }

    loop(List((startX, 0)), Set.empty, Set.empty)
  }

  def findTimeLines(diagram: Array[Array[Char]], startX: Int): Long = {

    val visitedResult = collection.mutable.Map.empty[(Int, Int), Long]

    def loop(x: Int, y: Int, current: Long): Long =
      if (y >= diagram.length || y < 0 || x < 0 || x >= diagram(y).length) {
        current
      } else if (diagram(y)(x) == 'S' || diagram(y)(x) == '.') {
        loop(x, y + 1, current)
      } else if (diagram(y)(x) == '^') {
        visitedResult.getOrElseUpdate((x, y), 0) match {
          case 0 =>
            val result = loop(x - 1, y + 1, current) + loop(x + 1, y + 1, current)
            visitedResult.put((x, y), result)
            result
          case result =>
            result
        }
      } else {
        current
      }

    loop(startX, 0, 1)
  }

  def part1(input: String): Int = {
    val diagram = parseInput(input)
    val start = diagram.head.indexOf('S')
    findPath(diagram, start).size
  }

  def part2(input: String): Long = {
    val diagram = parseInput(input)
    val start = diagram.head.indexOf('S')
    findTimeLines(diagram, start)
  }
}
