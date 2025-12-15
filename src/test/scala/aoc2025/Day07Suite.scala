package aoc2025

import Day07.*

class Day07Suite extends munit.FunSuite {

  val exampleInput = """
                       |.......S.......
                       |...............
                       |.......^.......
                       |...............
                       |......^.^......
                       |...............
                       |.....^.^.^.....
                       |...............
                       |....^.^...^....
                       |...............
                       |...^.^...^.^...
                       |...............
                       |..^...^.....^..
                       |...............
                       |.^.^.^.^.^...^.
                       |...............
                       |""".stripMargin

  test("example test that succeeds") {
    val result = part1(exampleInput)
    assertEquals(result, 21)
  }

  test("part1 input should succeeds") {
    val input = TestUtils.readResource("day07.input")
    val result = part1(input)
    assertEquals(result, 1656)
  }

  test("example test for part2 should succeeds") {
    val result = part2(exampleInput)
    assertEquals(result, 40L)
  }

  test("part2 input should succeeds") {
    val input = TestUtils.readResource("day07.input")
    val result = part2(input)
    assertEquals(result, 76624086587804L)
  }
}
