package pl.sdacademy.chat.server

import java.io.ObjectOutputStream
import java.net.Socket
import java.time.format.DateTimeFormatter
import java.util.concurrent.ConcurrentHashMap

class ChatLog {
  private val registerClients = new ConcurrentHashMap[Socket, ObjectOutputStream]
  private val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")


}
