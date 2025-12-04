package aoc2025

import Day02.*

class Day02Suite extends munit.FunSuite {

  val exampleInput = """11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124"""


  test("example test that succeeds") {
    val result = part1(exampleInput)
    assertEquals(result, 1227775554L)
  }

  test("part1 input should succeeds") {
    val input = TestUtils.readResource("day02.input")
    val result = part1(input)
    assertEquals(result, 40214376723L)
  }

  test("example test for part2 should succeeds") {
    val result = part2(exampleInput)
    assertEquals(result, 4174379265L)
  }

  test("part2 input should succeeds") {
    val input = TestUtils.readResource("day02.input")
    val result = part2(input)
    assertEquals(result, 50793864718L)
  }
}
