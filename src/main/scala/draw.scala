package edu.luc.cs.laufer.cs371.shapes

import Shape.*
import com.typesafe.scalalogging.LazyLogging
import doodle.core.*
import doodle.image.*
import doodle.image.syntax.all.*

object draw extends LazyLogging:

  def apply(s: Shape): Image =
    logger.debug(s"Drawing shape: $s")
    val result = s match
      case Rectangle(w, h) =>
        logger.debug(s"Drawing Rectangle($w, $h)")
        Image.rectangle(w.toDouble, h.toDouble)

      case Ellipse(w, h) =>
        logger.debug(s"Drawing Ellipse($w, $h)")
        Image.circle(w.toDouble).scale(1.0, h.toDouble / w.toDouble)

      case Location(x, y, shape) =>
        logger.debug(s"Drawing Location($x, $y, ...)")
        apply(shape).at(Point(x.toDouble, y.toDouble))

      case Group(shapes*) =>
        logger.debug(s"Drawing Group with ${shapes.size} shapes")
        if shapes.isEmpty then
          Image.empty
        else
          shapes.map(apply).reduce((img1, img2) => img1.on(img2))

    logger.debug(s"Draw result created")
    result

end draw
