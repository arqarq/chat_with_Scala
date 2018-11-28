object Run {

  implicit class IntTimes(x: Int) {
    def times[A](f: => A): Unit = {
      def loop(current: Int): Unit = if (current > 0) {
        f
        loop(current - 1)
      }

      loop(x)
      println()
    }

  }

  implicit class IntTimes2(x: String) {
    def times2[asd545H](g: => asd545H): Unit = {
      println("   " + x.codePointAt(0))

      def loop2(current: Int): Int = {
        if (current > 0) {
          g
          loop2(current - 1)
        }
        100
      }

      loop2(x.codePointAt(0))
    }
  }

}
