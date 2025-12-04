package aoc2025

import scala.io.Source

object TestUtils {
  def readResource(path: String): String = {
    val source = Source.fromResource(path)
    try
      source.getLines().mkString("\n")
    finally
      source.close()
  }
}
