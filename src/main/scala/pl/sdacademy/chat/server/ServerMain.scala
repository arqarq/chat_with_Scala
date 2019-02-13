package pl.sdacademy.chat.server

import java.io.IOException

object ServerMain {
  def main(args: Array[String]): Unit = {
    try {
      val serverSocketDispatcher = new ServerSocketDispatcher(5567)
      //      serverSocketDispatcher.dispatch()
    } catch {
      case ex: IOException => ex.printStackTrace()
    }
  }
}
