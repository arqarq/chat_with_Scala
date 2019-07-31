package pl.sdacademy.chat.server

import java.io.{IOException, ObjectInputStream}
import java.net.Socket

import pl.sdacademy.chat.model.ChatMessage

import scala.util.control.Breaks._

class ServerSocketReaderRunnable(private val client: Socket,
                                 private val chatLog: ChatLog)
  extends Thread {
  override def run(): Unit = {
    var clientInput = None: Option[ObjectInputStream]
    //var clientInput: ObjectInputStream = null

    if (!chatLog.register(client)) {
    }
    try {
      clientInput = Some(new ObjectInputStream(client.getInputStream))
      //clientInput = new ObjectInputStream(client.getInputStream)
      processClientInput(clientInput.get)
      //processClientInput(clientInput)
    } catch {
      case ex: IOException =>
        println("### Client disconnected due to network problem ###")
      case ex: ClassNotFoundException =>
        println("### Client disconnected due to invalid message format ###")
    } finally {
      if (clientInput.isDefined) {
        clientInput.get.close()
      }
    }
    chatLog.unregister(client)
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
        chatLog.acceptMessage(chatMessage)
      }
    }
  }
}
