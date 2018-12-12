package learn

import scala.collection.mutable

object Demo22 {
  def main(args: Array[String]) {
    val colors = Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")
    var nums: Map[Int, Int] = Map()
    val nums2: mutable.Map[Int, Int] = mutable.Map()

    println("Keys in colors: " + colors.keys)
    println("Values in colors: " + colors.values)
    println("Check if colors is empty: " + colors.isEmpty)
    println("Check if nums is empty: " + nums.isEmpty)
    nums += (6 -> 10)
    println(nums.keys)
    println(nums.values)
    nums2 += (5 -> 11)
    println(nums2)
  }
}
