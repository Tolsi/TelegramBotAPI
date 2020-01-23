package com.github.insanusmokrassar.TelegramBotAPI.types.buttons

import com.github.insanusmokrassar.TelegramBotAPI.types.*
import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Serializable(KeyboardButtonPollTypeSerializer::class)
sealed class KeyboardButtonPollType {
    abstract val type: String
}

@Serializable
class UnknownKeyboardButtonPollType internal constructor(override val type: String): KeyboardButtonPollType()

@Serializable
object RegularKeyboardButtonPollType : KeyboardButtonPollType() {
    override val type: String = regularPollType
}

@Serializable
object QuizKeyboardButtonPollType : KeyboardButtonPollType() {
    override val type: String = quizPollType
}

@Serializer(KeyboardButtonPollType::class)
internal object KeyboardButtonPollTypeSerializer : KSerializer<KeyboardButtonPollType> {
    override fun deserialize(decoder: Decoder): KeyboardButtonPollType {
        val asJson = JsonElementSerializer.deserialize(decoder)

        val type = when (asJson) {
            is JsonPrimitive -> asJson.content
            else -> asJson.jsonObject.getPrimitive(typeField).content
        }

        return when (type) {
            regularPollType -> RegularKeyboardButtonPollType
            quizPollType -> QuizKeyboardButtonPollType
            else -> UnknownKeyboardButtonPollType(type)
        }
    }

    override fun serialize(encoder: Encoder, obj: KeyboardButtonPollType) {
        when (obj) {
            RegularKeyboardButtonPollType -> RegularKeyboardButtonPollType.serializer().serialize(encoder, RegularKeyboardButtonPollType)
            QuizKeyboardButtonPollType -> QuizKeyboardButtonPollType.serializer().serialize(encoder, QuizKeyboardButtonPollType)
            is UnknownKeyboardButtonPollType -> UnknownKeyboardButtonPollType.serializer().serialize(encoder, obj)
        }
    }
}
