package pl.sdacademy.chat.model

class ChatMessage(private final val author: String, private final val message: String)
  extends Serializable {
  protected final val serialVersionUID: Long = 1

  def getAuthor: String = {
    author
  }

  def getMessage: String = {
    message
  }
}
