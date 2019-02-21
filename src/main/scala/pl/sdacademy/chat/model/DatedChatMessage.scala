package pl.sdacademy.chat.model

import java.time.LocalDateTime

class DatedChatMessage(private val chatMessage: ChatMessage)
  extends ChatMessage(chatMessage.getAuthor, chatMessage.getMessage) {
  private val receiveDate = LocalDateTime.now()

  def getReceiveDate: LocalDateTime = {
    receiveDate
  }
}
