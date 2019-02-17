package pl.sdacademy.chat.server

import java.io.{IOException, ObjectOutputStream}
import java.net.Socket
import java.time.format.DateTimeFormatter
import java.util
import java.util.concurrent.ConcurrentHashMap

import pl.sdacademy.chat.model.{ChatMessage, DatedChatMessage}

import scala.collection.JavaConverters._

class ChatLog(all: String) {
  private val registerClients = new ConcurrentHashMap[Socket, ObjectOutputStream]
  private val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

  def this() = this("")

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

  def acceptMessage(message: ChatMessage): Unit = {
    val datedMessage = new DatedChatMessage(message)
    printMessage(datedMessage)
    updateClients(datedMessage)
  }

  private def updateClients(datedMessage: DatedChatMessage): Unit = {
    val allEntries: util.Set[util.Map.Entry[Socket, ObjectOutputStream]] = registerClients.entrySet
    for (entry: util.Map.Entry[Socket, ObjectOutputStream] <- allEntries.asScala) {
      val connectionToClient: ObjectOutputStream = entry.getValue
      try {
        connectionToClient.writeObject(datedMessage)
        connectionToClient.flush()
      } catch {
        case ex: IOException =>
          unregister(entry.getKey)
      }
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
      } catch {
        case ex: IOException =>
      }
    }
    false
  }

  private def printMessage(datedMessage: DatedChatMessage): Unit = {
    println(dateFormatter.format(datedMessage.getReceiveDate)
      + " " + datedMessage.getAuthor
      + ": " + datedMessage.getMessage)
  }
}
