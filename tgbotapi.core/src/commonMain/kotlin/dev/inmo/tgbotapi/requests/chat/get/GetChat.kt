package dev.inmo.tgbotapi.requests.chat.get

import dev.inmo.tgbotapi.abstracts.types.ChatRequest
import dev.inmo.tgbotapi.requests.abstracts.SimpleRequest
import dev.inmo.tgbotapi.types.ChatIdWithThreadId
import dev.inmo.tgbotapi.types.ChatIdentifier
import dev.inmo.tgbotapi.types.chat.ExtendedChatSerializer
import dev.inmo.tgbotapi.types.chat.ExtendedChat
import dev.inmo.tgbotapi.types.chatIdField
import kotlinx.serialization.*

@Serializable
data class GetChat(
    @SerialName(chatIdField)
    override val chatId: ChatIdentifier
): ChatRequest, SimpleRequest<ExtendedChat> {
    override fun method(): String = "getChat"
    @Transient
    override val resultDeserializer: DeserializationStrategy<ExtendedChat> = if (chatId is ChatIdWithThreadId) {
        ExtendedChatSerializer.BasedOnForumThread(chatId.threadId)
    } else {
        ExtendedChatSerializer
    }
    override val requestSerializer: SerializationStrategy<*>
        get() = serializer()
}
