package aoc2025

// problem link: https://adventofcode.com/2025/day/5
object Day05 {

  case class Range(from: Long, to: Long)

  case class Query(id: Long)

  def parseInput(input: String): (Seq[Range], Seq[Query]) = {
    val (rangeRaw, queryRaw) = (input.trim.split("\n\n")(0), input.trim.split("\n\n")(1))
    val ranges = rangeRaw.split("\n").map {
      case s"$from-$to" => Range(from.toLong, to.toLong)
      case _            => throw new IllegalArgumentException(s"Invalid input: $input")
    }
    val queries = queryRaw.split("\n").map {
      case s"$id" => Query(id.toLong)
      case _      => throw new IllegalArgumentException(s"Invalid input: $input")
    }
    (mergeRanges(ranges.toIndexedSeq), queries.toIndexedSeq)
  }

  def mergeRanges(ranges: Seq[Range]): Seq[Range] =
    ranges.sortBy(_.from).foldLeft(Seq.empty[Range]) { case (acc, range) =>
      if (acc.isEmpty) Seq(range)
      else {
        val last = acc.last
        if (last.to + 1 >= range.from) acc.init :+ Range(last.from, Math.max(range.to, last.to))
        else acc :+ range
      }
    }

  def isFresh(ranges: Seq[Range], query: Query): Boolean =
    ranges.exists(range => range.from <= query.id && range.to >= query.id)

  def part1(input: String): Int = {
    val (ranges, queries) = parseInput(input)
    queries.count(isFresh(ranges, _))
  }

  def part2(input: String): Long = {
    val (ranges, _) = parseInput(input)
    ranges.map(range => range.to - range.from + 1).sum
  }

}
