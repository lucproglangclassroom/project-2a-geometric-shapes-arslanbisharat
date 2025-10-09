package edu.luc.cs.laufer.cs371.shapes

/** data Shape = Rectangle(w, h) | Location(x, y, Shape) | Ellipse(w, h) | Group(shapes*) */
enum Shape derives CanEqual:
  case Rectangle(width: Int, height: Int)
  case Ellipse(width: Int, height: Int)
  case Location(x: Int, y: Int, shape: Shape)
  case Group(shapes: Shape*)

object Shape:
  def validatedRectangle(w: Int, h: Int): Rectangle =
    require(w > 0, s"Rectangle width must be positive: $w")
    require(h > 0, s"Rectangle height must be positive: $h")
    Rectangle(w, h)

  def validatedEllipse(w: Int, h: Int): Ellipse =
    require(w > 0, s"Ellipse width must be positive: $w")
    require(h > 0, s"Ellipse height must be positive: $h")
    Ellipse(w, h)

  def validatedGroup(shapeSeq: Shape*): Group =
    require(shapeSeq.nonEmpty, "Group must contain at least one shape")
    Group(shapeSeq*)

end Shape
