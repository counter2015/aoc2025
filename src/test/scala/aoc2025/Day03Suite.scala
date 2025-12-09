package aoc2025

import Day03.*

class Day03Suite extends munit.FunSuite {

  val exampleInput = """
                       |987654321111111
                       |811111111111119
                       |234234234234278
                       |818181911112111""".stripMargin

  test("example test that succeeds") {
    val result = part1(exampleInput)
    assertEquals(result, 357L)
  }

  test("part1 input should succeeds") {
    val input = TestUtils.readResource("day03.input")
    val result = part1(input)
    assertEquals(result, 17207L)
  }

  test("example test for part2 should succeeds") {
    val result = part2(exampleInput)
    assertEquals(result, 3121910778619L)
  }

  test("part2 input should succeeds") {
    val input = TestUtils.readResource("day03.input")
    val result = part2(input)
    assertEquals(result, 170997883706617L)
  }
}
