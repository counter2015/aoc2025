package aoc2025

import scala.collection.immutable.ArraySeq
import scala.annotation.tailrec

// problem link: https://adventofcode.com/2025/day/4
object Day04 {

  case class State(char: Char)

  case class Diagram(positions: Seq[Seq[State]]) {
    def get(x: Int, y: Int): Option[State] =
      if (x < 0 || y < 0 || x >= positions.length || y >= positions(0).length) {
        None
      } else {
        Some(positions(x)(y))
      }
  }

  def parseInput(input: String): Seq[Seq[Char]] =
    input.trim
      .split("\n")
      .map(_.trim)
      .toSeq
      .map(ArraySeq.from)

  def isAccessible(diagram: Array[Array[Char]], x: Int, y: Int): Boolean = {
    var count = 0
    for (i <- -1 to 1; j <- -1 to 1)
      if (i != 0 || j != 0) {
        val newX = x + i
        val newY = y + j
        if (newX >= 0 && newX < diagram.length && newY >= 0 && newY < diagram(0).length) {
          val newState = diagram(newX)(newY)
          if (newState == '@') {
            count += 1
          }
        }
      }
    count < 4
  }

  def removeDiagram(diagram: Array[Array[Char]], changeDiagram: Boolean = false): (Array[Array[Char]], Int) = {
    var count = 0
    for {
      i <- diagram.indices
      j <- diagram(i).indices
      if diagram(i)(j) == '@' && isAccessible(diagram, i, j)
    } {
      if (changeDiagram) {
        diagram(i)(j) = 'x'
      }
      count += 1
    }
    (diagram, count)
  }

  def part1(input: String): Int = {
    val diagram = parseInput(input)

    val (_, count) = removeDiagram(diagram.map(_.toArray).toArray)

    count
  }

  def part2(input: String): Int = {
    val diagram = parseInput(input).map(_.toArray).toArray

    @tailrec
    def loop(diagram: Array[Array[Char]], acc: Int): Int =
      val (nextDiagram, delta) = removeDiagram(diagram, true)
      if delta == 0 then acc
      else loop(nextDiagram, acc + delta)

    loop(diagram, 0)
  }

}
