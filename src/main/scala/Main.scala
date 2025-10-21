package edu.luc.cs.laufer.cs371.shapes

import Shape.*

object Main:
  def main(args: Array[String]): Unit =
    println("=" * 60)
    println("Geometric Shapes Project - Demonstration")
    println("=" * 60)

    val rect = Rectangle(80, 120)
    val ellipse = Ellipse(50, 30)
    val located = Location(70, 30, rect)
    val group = Group(ellipse, Rectangle(20, 40))

    println("\n--- Shape Definitions ---")
    println(s"Rectangle: $rect")
    println(s"Ellipse: $ellipse")
    println(s"Located Rectangle: $located")
    println(s"Group: $group")

    println("\n--- Bounding Box Computation ---")
    println(s"Rectangle bounding box: ${boundingBox(rect)}")
    println(s"Ellipse bounding box: ${boundingBox(ellipse)}")
    println(s"Located bounding box: ${boundingBox(located)}")
    println(s"Group bounding box: ${boundingBox(group)}")

    println("\n--- Size Computation ---")
    println(s"Rectangle size: ${size(rect)}")
    println(s"Ellipse size: ${size(ellipse)}")
    println(s"Located size: ${size(located)}")
    println(s"Group size: ${size(group)}")

    println("\n--- Height Computation ---")
    println(s"Rectangle height: ${height(rect)}")
    println(s"Ellipse height: ${height(ellipse)}")
    println(s"Located height: ${height(located)}")
    println(s"Group height: ${height(group)}")

    println("\n--- Scale Transformation ---")
    val scaledRect = scale(2.0)(rect)
    val scaledGroup = scale(0.5)(group)
    println(s"Rectangle scaled by 2.0: $scaledRect")
    println(s"Group scaled by 0.5: $scaledGroup")

    println("\n--- Draw Behavior (Extra Credit) ---")
    val drawnRect = draw(rect)
    val drawnEllipse = draw(ellipse)
    val drawnGroup = draw(group)
    println(s"Rectangle drawn: ${drawnRect != null}")
    println(s"Ellipse drawn: ${drawnEllipse != null}")
    println(s"Group drawn: ${drawnGroup != null}")

    println("\n--- Shape Validation ---")
    try
      val validRect = Shape.validatedRectangle(10, 20)
      println(s"Valid rectangle created: $validRect")
    catch
      case e: IllegalArgumentException => println(s"Error: ${e.getMessage}")

    try
      val invalidRect = Shape.validatedRectangle(-10, 20)
      println(s"Invalid rectangle created: $invalidRect")
    catch
      case e: IllegalArgumentException => println(s"Caught expected error: ${e.getMessage}")

    println("\n" + "=" * 60)
    println("All behaviors demonstrated successfully!")
    println("=" * 60)

end Main
