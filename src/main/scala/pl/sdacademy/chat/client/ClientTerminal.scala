package pl.sdacademy.chat.client

import java.io.{IOException, ObjectOutputStream}
import java.net.Socket
import java.util.Scanner

class ClientTerminal {
  private var streamToServer: ObjectOutputStream = _
  private var scanner: Scanner = _
  private var connectionToServer: Socket = _

  try {
    connectionToServer = new Socket("192.168.0.11", 5567)
  } catch {
    case ex: IOException => {
      println(ex.getMessage)
    }
  }

  def run() {
    try {
      streamToServer = new ObjectOutputStream(connectionToServer.getOutputStream)
      scanner = new Scanner(System.in)
    } catch {
      case ex: IOException => {}
    } finally {
      streamToServer.close()
    }
  }
}
