package aoc2025

import Day05.*

class Day05Suite extends munit.FunSuite {

  val exampleInput: String = """3-5
                       |10-14
                       |16-20
                       |12-18
                       |
                       |1
                       |5
                       |8
                       |11
                       |17
                       |32""".stripMargin

  test("example test that succeeds") {
    val result = part1(exampleInput)
    assertEquals(result, 3)
  }

  test("part1 input should succeeds") {
    val input = TestUtils.readResource("day05.input")
    val result = part1(input)
    assertEquals(result, 517)
  }

  test("example test for part2 should succeeds") {
    val result = part2(exampleInput)
    assertEquals(result, 14L)
  }

  test("part2 input should succeeds") {
    val input = TestUtils.readResource("day05.input")
    val result = part2(input)
    assertEquals(result, 336173027056994L)
  }
}
