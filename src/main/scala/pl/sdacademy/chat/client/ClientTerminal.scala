package pl.sdacademy.chat.client

import java.io.{IOException, ObjectOutputStream}
import java.net.Socket
import java.util.Scanner

import pl.sdacademy.chat.model.ChatMessage

class ClientTerminal(private final val connectionToServer: Socket
                     = new Socket("192.168.0.11", 5567)
                    ) extends Thread {
  override def run() {
    var streamToServer: ObjectOutputStream = null

    try {
      streamToServer = new ObjectOutputStream(connectionToServer.getOutputStream)
      val scanner = new Scanner(System.in)
      var message: String = null

      print("Your username: ")
      val username: String = scanner.nextLine
      do {
        print("> ")
        message = scanner.nextLine
        val messageToSend = new ChatMessage(username, message)
        streamToServer.writeObject(messageToSend)
        streamToServer.flush()
      } while (!message.equalsIgnoreCase("exit"))
    } catch {
      case ex: IOException =>
        println("Server closed connection.")
        ex.printStackTrace()
    } finally {
      if (streamToServer != null) {
        try {
          streamToServer.close()
        } catch {
          case ex: IOException =>
            println("Cannot close output stream.")
            ex.printStackTrace()
        }
      }
    }
    println("Disconnecting")
  }
}
