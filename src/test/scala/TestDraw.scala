package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import doodle.image.*

import TestFixtures.*
import Shape.*

class TestDraw extends AnyFunSuite:

  test("draw simple rectangle returns valid image"):
    val image = draw(simpleRectangle)
    assert(image != null)
    assert(image.isInstanceOf[Image])

  test("draw simple ellipse returns valid image"):
    val image = draw(simpleEllipse)
    assert(image != null)
    assert(image.isInstanceOf[Image])

  test("draw simple location returns valid image"):
    val image = draw(simpleLocation)
    assert(image != null)
    assert(image.isInstanceOf[Image])

  test("draw basic group returns valid image"):
    val image = draw(basicGroup)
    assert(image != null)
    assert(image.isInstanceOf[Image])

  test("draw simple group returns valid image"):
    val image = draw(simpleGroup)
    assert(image != null)
    assert(image.isInstanceOf[Image])

  test("draw complex group returns valid image"):
    val image = draw(complexGroup)
    assert(image != null)
    assert(image.isInstanceOf[Image])

end TestDraw
