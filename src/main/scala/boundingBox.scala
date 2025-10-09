package edu.luc.cs.laufer.cs371.shapes

import Shape.*
import com.typesafe.scalalogging.LazyLogging

object boundingBox extends LazyLogging:
  def apply(s: Shape): Location =
    logger.debug(s"Computing bounding box for: $s")
    s match
      case Rectangle(w, h) =>
        logger.debug(s"Rectangle($w, $h) -> Location(0, 0, Rectangle($w, $h))")
        val result: Location = Location(0, 0, Rectangle(w, h))
        logger.debug(s"Bounding box result: $result")
        result

      case Ellipse(w, h) =>
        logger.debug(s"Ellipse($w, $h) -> Location(${-w}, ${-h}, Rectangle(${2 * w}, ${2 * h}))")
        val result: Location = Location(-w, -h, Rectangle(2 * w, 2 * h))
        logger.debug(s"Bounding box result: $result")
        result

      case Location(x, y, shape) =>
        val Location(u, v, Rectangle(w, h)) = apply(shape): @unchecked
        logger.debug(s"Location($x, $y, ...) -> Location(${x + u}, ${y + v}, Rectangle($w, $h))")
        val result: Location = Location(x + u, y + v, Rectangle(w, h))
        logger.debug(s"Bounding box result: $result")
        result

      case Group(shapes*) =>
        logger.debug(s"Computing bounding box for Group with ${shapes.size} shapes")
        val boxes = shapes.map(apply)
        val lefts = boxes.map { case Location(x, _, Rectangle(w, _)) => x }
        val rights = boxes.map { case Location(x, _, Rectangle(w, _)) => x + w }
        val tops = boxes.map { case Location(_, y, Rectangle(_, h)) => y }
        val bottoms = boxes.map { case Location(_, y, Rectangle(_, h)) => y + h }

        val minX = lefts.min
        val maxX = rights.max
        val minY = tops.min
        val maxY = bottoms.max

        logger.debug(s"Group bounds: x[$minX, $maxX], y[$minY, $maxY]")
        val result: Location = Location(minX, minY, Rectangle(maxX - minX, maxY - minY))
        logger.debug(s"Bounding box result: $result")
        result

end boundingBox
