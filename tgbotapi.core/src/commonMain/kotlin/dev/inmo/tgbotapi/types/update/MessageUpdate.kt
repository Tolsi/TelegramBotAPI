package dev.inmo.tgbotapi.types.update

import dev.inmo.tgbotapi.types.UpdateIdentifier
import dev.inmo.tgbotapi.types.message.abstracts.Message
import dev.inmo.tgbotapi.types.update.abstracts.BaseSentMessageUpdate

data class MessageUpdate(
    override val updateId: UpdateIdentifier,
    override val data: Message
) : BaseSentMessageUpdate {
    override fun copy(newData: Message) = copy(updateId, newData)
}
