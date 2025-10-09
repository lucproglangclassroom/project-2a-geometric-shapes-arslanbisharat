package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite

import Shape.*

class TestShapeValidity extends AnyFunSuite:

  test("Rectangle with positive dimensions should succeed"):
    val rect = validatedRectangle(10, 20)
    assert(rect.width == 10)
    assert(rect.height == 20)

  test("Rectangle with zero width should fail"):
    assertThrows[IllegalArgumentException]:
      validatedRectangle(0, 20)

  test("Rectangle with negative width should fail"):
    assertThrows[IllegalArgumentException]:
      validatedRectangle(-5, 20)

  test("Rectangle with zero height should fail"):
    assertThrows[IllegalArgumentException]:
      validatedRectangle(10, 0)

  test("Rectangle with negative height should fail"):
    assertThrows[IllegalArgumentException]:
      validatedRectangle(10, -5)

  test("Ellipse with positive dimensions should succeed"):
    val ellipse = validatedEllipse(30, 40)
    assert(ellipse.width == 30)
    assert(ellipse.height == 40)

  test("Ellipse with zero width should fail"):
    assertThrows[IllegalArgumentException]:
      validatedEllipse(0, 40)

  test("Ellipse with negative width should fail"):
    assertThrows[IllegalArgumentException]:
      validatedEllipse(-10, 40)

  test("Ellipse with zero height should fail"):
    assertThrows[IllegalArgumentException]:
      validatedEllipse(30, 0)

  test("Ellipse with negative height should fail"):
    assertThrows[IllegalArgumentException]:
      validatedEllipse(30, -10)

  test("Group with shapes should succeed"):
    val group = validatedGroup(Rectangle(10, 20), Ellipse(5, 10))
    assert(group.shapes.size == 2)

  test("Empty Group should fail"):
    assertThrows[IllegalArgumentException]:
      validatedGroup()

end TestShapeValidity
