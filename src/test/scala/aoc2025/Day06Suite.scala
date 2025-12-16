package aoc2025

import Day06.*

class Day06Suite extends munit.FunSuite {

  val exampleInput: String = """
                       |123 328  51 64 
                       | 45 64  387 23 
                       |  6 98  215 314
                       |*   +   *   +""".stripMargin

  test("example test that succeeds") {
    val result = part1(exampleInput)
    assertEquals(result, BigInt(4277556))
  }

  test("part1 input should succeeds") {
    val input = TestUtils.readResource("day06.input")
    val result = part1(input)
    assertEquals(result, BigInt(6169101504608L))
  }

  test("example test for part2 should succeeds") {
    val result = part2(exampleInput)
    assertEquals(result, BigInt(3263827))
  }

  test("part2 input should succeeds") {
    val input = TestUtils.readResource("day06.input")
    val result = part2(input)
    assertEquals(result, BigInt(10442199710797L))
  }
}
