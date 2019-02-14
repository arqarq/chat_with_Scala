package pl.sdacademy.chat.server

import java.io.{IOException, ObjectInputStream}
import java.net.Socket

import pl.sdacademy.chat.model.ChatMessage

import scala.util.control.Breaks._

class ServerSocketReaderRunnable(private val client: Socket,
                                 private val chatLog: ChatLog
                                ) extends Thread {
  override def run(): Unit = {
    if (!chatLog.register(client)) {
    }
    try val clientInput = new ObjectInputStream(client.getInputStream) {
      processClientInput(clientInput)
    } catch {
      case
        ex: IOException =>
        println("### Client disconnected due to network problem ###")
        ex: ClassNotFoundException =>
          println("### Client disconnected due to invalid message format ###")
    }
    //    chatLog.unregister(client)
  }

  @throws(classOf[IOException])
  @throws(classOf[ClassNotFoundException])
  private def processClientInput(clientInput: ObjectInputStream): Unit = {
    breakable {
      while (true) {
        val chatMessage = clientInput.readObject().asInstanceOf[ChatMessage]
        if (chatMessage.getMessage == null ||
          chatMessage.getMessage.equalsIgnoreCase("exit")) {
          break
        }
//        chatLog.acceptMessage(chatMessage)
      }
    }
  }
}
