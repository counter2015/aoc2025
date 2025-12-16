package aoc2025

// problem link: https://adventofcode.com/2025/day/8
object Day08 {

  case class Point(x: Int, y: Int, z: Int, var id: Int = 0)
  case class Edge(a: Point, b: Point, distance: Long)

  object Point {
    def fromRaw(raw: String): Point = {
      val arr = raw.trim.split(",")
      Point(arr(0).toInt, arr(1).toInt, arr(2).toInt)
    }
  }

  def parseInput(input: String): Array[Point] =
    val raw = input.trim.split("\n").map(Point.fromRaw)
    raw.zipWithIndex.foreach { case (p, id) => p.id = id }
    raw

  def distance(a: Point, b: Point): Long =
    val dx = (a.x - b.x).toLong
    val dy = (a.y - b.y).toLong
    val dz = (a.z - b.z).toLong
    dx * dx + dy * dy + dz * dz

  def lookup(roots: Array[Int], i: Int): Int =
    if (roots(i) == i) i
    else {
      val root = lookup(roots, roots(i))
      roots(i) = root
      root
    }

  def merge(roots: Array[Int], a: Int, b: Int): Unit = {
    val ra = lookup(roots, a)
    val rb = lookup(roots, b)
    if (ra != rb) roots(rb) = ra
  }

  def connect(points: Array[Point], connectNumber: Int): Long = {
    val distances = for {
      i <- points.indices
      j <- i + 1 until points.length
    } yield Edge(points(i), points(j), distance(points(i), points(j)))

    val roots = points.map(_.id).toArray

    distances.sortBy(_.distance).take(connectNumber).foreach { case Edge(a, b, _) =>
      merge(roots, a.id, b.id)
    }

    val finalRoots = points.indices.map(lookup(roots, _))

    val sizes = finalRoots.groupMapReduce(identity)(_ => 1)(_ + _)

    val res = sizes.toList.sortBy(-_._2).take(3).map(_._2).product
    res
  }

  def part1(input: String, connectNumber: Int): Long =
    connect(parseInput(input), connectNumber)

  def part2(input: String): Long = {

    val points = parseInput(input)
    val edges = (for {
      i <- points.indices
      j <- i + 1 until points.length
    } yield Edge(points(i), points(j), distance(points(i), points(j)))).sortBy(_.distance)

    val roots = points.map(_.id).toArray

    var res = 0L
    var components = points.length
    def find(x: Int): Int = lookup(roots, x)

    edges.foreach { e =>
      val ra = find(e.a.id)
      val rb = find(e.b.id)
      if (ra != rb) {
        roots(rb) = ra
        components -= 1
        if (components == 1) {
          res = e.a.x.toLong * e.b.x.toLong
        }
      }
    }
    res
  }
}
