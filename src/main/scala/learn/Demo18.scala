package learn

object Demo18 extends App {
  var tup: (Int, String, String, Console.type) = (1, "String", """literal""", Console)
  var tup4 = new Tuple4[Int, String, String, Console.type](1, "cos", "cos2", Console)
  var tup2 = Tuple2(2, 4)

  println(tup.toString())
  println(tup._1)
  println(tup._2.concat(tup._3))
  println(tup._4.flush())
  println(tup4._2.concat(tup4._3))
  println(tup2._1 + tup2._2)
}
