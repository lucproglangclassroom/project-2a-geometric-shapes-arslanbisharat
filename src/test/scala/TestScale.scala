package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite

import TestFixtures.*
import Shape.*

class TestScale extends AnyFunSuite:

  test("scale simple ellipse by 2"):
    val scaled = scale(2.0)(simpleEllipse)
    assert(scaled == Ellipse(100, 60))

  test("scale simple rectangle by 0.5"):
    val scaled = scale(0.5)(simpleRectangle)
    assert(scaled == Rectangle(40, 60))

  test("scale simple location by 2"):
    val scaled = scale(2.0)(simpleLocation)
    assert(scaled == Location(140, 60, Rectangle(160, 240)))

  test("scale basic group by 3"):
    val scaled = scale(3.0)(basicGroup)
    assert(scaled == Group(Ellipse(150, 90), Rectangle(60, 120)))

  test("scale simple group by 0.5"):
    val scaled = scale(0.5)(simpleGroup)
    assert(scaled == Group(
      Location(100, 50, Ellipse(25, 15)),
      Location(200, 150, Rectangle(50, 25))
    ))

  test("scale complex group by 2"):
    val scaled = scale(2.0)(complexGroup)
    val expected = Location(100, 200,
      Group(
        Ellipse(40, 80),
        Location(300, 100,
          Group(
            Rectangle(100, 60),
            Rectangle(600, 120),
            Location(200, 400,
              Ellipse(100, 60)
            )
          )),
        Rectangle(200, 400)
      ))
    assert(scaled == expected)

end TestScale
