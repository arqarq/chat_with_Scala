package pl.sdacademy.chat.server

import java.io.{IOException, ObjectOutputStream}
import java.net.Socket
import java.time.format.DateTimeFormatter
import java.util.concurrent.ConcurrentHashMap

class ChatLog {
  private val registerClients = new ConcurrentHashMap[Socket, ObjectOutputStream]
  private val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

  def register(client: Socket): Boolean = {
    try {
      val streamToClient = new ObjectOutputStream(client.getOutputStream)
      val addressIP = client.getInetAddress.toString

      registerClients.put(client, streamToClient)
      println("### " + addressIP.substring(1) + " connected ###")
      true
    } catch {
      case ex: IOException =>
        println("### Someone tried to connect, but was rejected ###")
        false
    }
  }

  def unregister(client: Socket): Boolean = {
    val connectionToRemovedClient: ObjectOutputStream = registerClients.remove(client)
    if (connectionToRemovedClient != null) {
      try {
        connectionToRemovedClient.close()
        val addressIP = client.getInetAddress.toString
        println("### " + addressIP.substring(1) + " disconnected ###")
        return true
      }
      catch {
        case ex: IOException =>
      }
    }
    false
  }
}
