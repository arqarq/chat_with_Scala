package pl.sdacademy.chat.model

import java.time.LocalDateTime

class DatedChatMessage(chatMessage: ChatMessage)
  extends ChatMessage(chatMessage.getAuthor, chatMessage.getMessage) {
  private final val receiveDate: LocalDateTime = LocalDateTime.now()

  def getReceiveDate: LocalDateTime = {
    receiveDate
  }
}
