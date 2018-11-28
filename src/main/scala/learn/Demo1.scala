package learn

class Point(val xc: Int, val yc: Int) {
  var x: Int = xc
  var y: Int = yc

  def move(dx: Int, dy: Int) {
    x = x + dx
    y = y + dy
    println("learn.Point x location: " + x)
    println("learn.Point y location: " + y)
  }
}

class Location(override val xc: Int, override val yc: Int, val zc: Int) extends Point(xc, yc) {
  var z: Int = zc

  def move(dx: Int, dy: Int, dz: Int) {
    x = x + dx
    y = y + dy
    z = z + dz
    println("learn.Point x location: " + x)
    println("learn.Point y location: " + y)
    println("learn.Point z location: " + z)
  }
}

object Demo {
  def main(args: Array[String]) {
    val loc = new Location(10, 20, 15)

    // Move to a new location
    loc.move(10, 10, 5)
  }
}
