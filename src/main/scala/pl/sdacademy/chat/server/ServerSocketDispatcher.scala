package pl.sdacademy.chat.server

import java.io.IOException
import java.net.ServerSocket

@throws(classOf[IOException])
class ServerSocketDispatcher(portNumber: Integer) {
  private val server: ServerSocket = new ServerSocket(portNumber)
  private val chatLog: ChatLog = new ChatLog


}
