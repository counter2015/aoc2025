package aoc2025

import Day04.*

class Day04Suite extends munit.FunSuite {

  val exampleInput = """
                       |..@@.@@@@.
                       |@@@.@.@.@@
                       |@@@@@.@.@@
                       |@.@@@@..@.
                       |@@.@@@@.@@
                       |.@@@@@@@.@
                       |.@.@.@.@@@
                       |@.@@@.@@@@
                       |.@@@@@@@@.
                       |@.@.@@@.@.""".stripMargin

  test("example test that succeeds") {
    val result = part1(exampleInput)
    assertEquals(result, 13)
  }

  test("part1 input should succeeds") {
    val input = TestUtils.readResource("day04.input")
    val result = part1(input)
    assertEquals(result, 1372)
  }

  test("example test for part2 should succeeds") {
    val result = part2(exampleInput)
    assertEquals(result, 43)
  }

  test("part2 input should succeeds") {
    val input = TestUtils.readResource("day04.input")
    val result = part2(input)
    assertEquals(result, 7922)
  }
}
