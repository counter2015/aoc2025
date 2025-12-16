package aoc2025

import Day08.*

class Day08Suite extends munit.FunSuite {

  val exampleInput: String = """
                       |162,817,812
                       |57,618,57
                       |906,360,560
                       |592,479,940
                       |352,342,300
                       |466,668,158
                       |542,29,236
                       |431,825,988
                       |739,650,466
                       |52,470,668
                       |216,146,977
                       |819,987,18
                       |117,168,530
                       |805,96,715
                       |346,949,466
                       |970,615,88
                       |941,993,340
                       |862,61,35
                       |984,92,344
                       |425,690,689
                       |""".stripMargin

  test("example test that succeeds") {
    val result = part1(exampleInput, 10)
    assertEquals(result, 40L)
  }

  test("part1 input should succeeds") {
    val input = TestUtils.readResource("day08.input")
    val result = part1(input, 1000)
    assertEquals(result, 75582L) // too low
  }

  test("example test for part2 should succeeds") {
    val result = part2(exampleInput)
    assertEquals(result, 25272L)
  }

  test("part2 input should succeeds") {
    val input = TestUtils.readResource("day08.input")
    val result = part2(input)
    assertEquals(result, 59039696L) // too high
  }
}
