package aoc2025

import Day01.*

class Day01Suite extends munit.FunSuite {

  val exampleInput: String = """
    |L68
    |L30
    |R48
    |L5
    |R60
    |L55
    |L1
    |L99
    |R14
    |L82
  """.stripMargin

  test("example test that succeeds") {
    val result = part1(exampleInput)
    assertEquals(result, 3)
  }

  test("part1 input should succeeds") {
    val input = TestUtils.readResource("day01.input")
    val result = part1(input)
    assertEquals(result, 1081)
  }

  test("example test for part2 should succeeds") {
    val result = part2(exampleInput)
    assertEquals(result, 6)
  }

  test("part2 input should succeeds") {
    val input = TestUtils.readResource("day01.input")
    val result = part2(input)
    assertEquals(result, 6689)
  }
}
