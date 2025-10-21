[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=20970633)

# Project 2a: Geometric Shapes (Object-Oriented Scala)

## Project Structure

The project follows standard Scala/sbt structure:

```
src/
├── main/
│   ├── scala/
│   │   ├── shapes.scala          # Shape ADT definitions
│   │   ├── boundingBox.scala     # Bounding box computation
│   │   ├── size.scala            # Count leaf shapes
│   │   ├── height.scala          # Tree height computation
│   │   ├── scale.scala           # Scaling transformation
│   │   ├── draw.scala            # Graphical rendering (extra credit)
│   │   └── Main.scala            # Main application
│   └── resources/
│       └── logback.xml           # Logging configuration
└── test/
    └── scala/
        ├── TestBoundingBox.scala # Bounding box tests
        ├── TestSize.scala        # Size behavior tests
        ├── TestHeight.scala      # Height behavior tests
        ├── TestScale.scala       # Scale behavior tests
        ├── TestShapeValidity.scala # Shape validation tests
        ├── TestDraw.scala        # Draw behavior tests (extra credit)
        └── TestFixtures.scala    # Shared test data
```

## Shape Hierarchy

The project defines four shape types using Scala 3 enums:

- `Rectangle(width: Int, height: Int)` - A rectangle with width and height
- `Ellipse(width: Int, height: Int)` - An ellipse with width and height
- `Location(x: Int, y: Int, shape: Shape)` - A positioned shape
- `Group(shapes: Shape*)` - A collection of shapes

## Implemented Behaviors

### 1. Bounding Box
Computes the minimal rectangle that encloses a shape.
- File: `src/main/scala/boundingBox.scala`
- Uses: `map`, `min`, `max` for functional operations
- Returns: `Location` with the bounding rectangle

### 2. Size
Counts the number of concrete leaf shapes (Rectangle and Ellipse) in a shape tree.
- File: `src/main/scala/size.scala`
- Uses: `map`, `sum`
- Returns: `Int` count of leaf shapes

### 3. Height
Computes the height (depth) of the shape tree structure.
- File: `src/main/scala/height.scala`
- Uses: `map`, `max`
- Returns: `Int` tree height

### 4. Scale
Scales all dimensions of a shape by a given factor, including positions.
- File: `src/main/scala/scale.scala`
- Uses: `map` for recursive transformation
- Returns: Transformed `Shape`

### 5. Draw (Extra Credit)
Renders shapes graphically using the Doodle library.
- File: `src/main/scala/draw.scala`
- Converts Shape ADT to Doodle Image objects
- Handles all shape types with proper positioning
- Returns: `doodle.image.Image`

## Shape Validation

The project includes validation functions for shape constructors:
- `validatedRectangle(w: Int, h: Int)` - Ensures positive dimensions
- `validatedEllipse(w: Int, h: Int)` - Ensures positive dimensions
- `validatedGroup(shapes: Shape*)` - Ensures non-empty groups

All validation functions use `require` to enforce preconditions.

## How to Run

### Prerequisites
- Java 11 or higher
- sbt (Scala Build Tool)

### Compile the Project
```bash
sbt compile
```

### Run Tests
```bash
# Run all tests
sbt test

# Run specific test suite
sbt "testOnly edu.luc.cs.laufer.cs371.shapes.TestBoundingBox"
sbt "testOnly edu.luc.cs.laufer.cs371.shapes.TestSize"
sbt "testOnly edu.luc.cs.laufer.cs371.shapes.TestHeight"
sbt "testOnly edu.luc.cs.laufer.cs371.shapes.TestScale"
sbt "testOnly edu.luc.cs.laufer.cs371.shapes.TestShapeValidity"
sbt "testOnly edu.luc.cs.laufer.cs371.shapes.TestDraw"
```

### Run the Main Application
```bash
sbt run
```

## Logging Configuration

The project uses Logback for configurable logging. Configuration file: `src/main/resources/logback.xml`

Current settings:
- Root level: INFO
- Shapes package: DEBUG

To change logging levels, edit `logback.xml`:
```xml
<logger name="edu.luc.cs.laufer.cs371.shapes" level="DEBUG"/>
```

Available levels: TRACE, DEBUG, INFO, WARN, ERROR

## Testing

The project includes comprehensive test suites:

- **TestBoundingBox**: 6 tests covering all shape types
- **TestSize**: 6 tests from simple to complex shapes
- **TestHeight**: 6 tests verifying tree height computation
- **TestScale**: 6 tests for scaling transformations
- **TestShapeValidity**: 12 tests for constructor validation
- **TestDraw**: 6 tests verifying image generation (extra credit)

All tests use ScalaTest's FunSuite style.

## Functional Programming Features

The implementation demonstrates functional programming principles:
- Immutable data structures (case classes)
- Pattern matching for type-safe decomposition
- Higher-order functions (map, sum, min, max)
- Recursion instead of loops
- No side effects in core logic

## Extra Credit

Extra credit tasks **COMPLETED**:
- Graphical rendering using Doodle - Implemented in [draw.scala](src/main/scala/draw.scala)
- Automated unit testing of draw behavior - Implemented in [TestDraw.scala](src/test/scala/TestDraw.scala) with 6 tests

## Assignment Completion

All required components have been implemented:
- All case classes defined
- boundingBox function complete
- Shape constructor validation with tests
- size, height, and scale functions implemented
- Functional methods (map, sum, min, max) used appropriately
- Comprehensive test suites for all behaviors
- Configurable debug output using logging library
- Extra credit: draw behavior with Doodle and automated testing

## Author

Arslan Bisharat and Hattie Lyons

## License

This project is part of an academic assignment.
