package dev.inmo.tgbotapi.types.InlineQueries.ChosenInlineResult

import dev.inmo.tgbotapi.types.*
import dev.inmo.tgbotapi.types.chat.User
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseChosenInlineResult(
    override val resultId: InlineQueryIdentifier,
    @SerialName(fromField)
    override val from: User,
    override val inlineMessageId: InlineMessageIdentifier?,
    override val query: String
) : ChosenInlineResult
