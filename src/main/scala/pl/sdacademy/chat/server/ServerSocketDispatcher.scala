package pl.sdacademy.chat.server

import java.io.IOException
import java.net.{ServerSocket, Socket}

@throws(classOf[IOException])
class ServerSocketDispatcher(portNumber: Integer = 5567) {
  private val server: ServerSocket = new ServerSocket(portNumber)
  private val chatLog: ChatLog = new ChatLog

  def dispatch(): Unit = {
    try {
      while (true) {
        val client: Socket = server.accept
        val clientTask: Runnable = new ServerSocketReaderRunnable(client, chatLog)

        new Thread(clientTask).start()
      }
    } catch {
      case ex: IOException =>
        println("!!!!! SERVER HALTED !!!!!")
        ex.printStackTrace()
    }
  }
}
