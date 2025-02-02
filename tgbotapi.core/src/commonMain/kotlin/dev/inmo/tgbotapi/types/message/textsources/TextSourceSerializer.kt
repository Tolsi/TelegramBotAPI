package dev.inmo.tgbotapi.types.message.textsources

import dev.inmo.micro_utils.serialization.typed_serializer.TypedSerializer
import kotlinx.serialization.KSerializer

private val baseSerializers: Map<String, KSerializer<out TextSource>> = mapOf(
    "regular" to RegularTextSource.serializer(),
    "text_link" to TextLinkTextSource.serializer(),
    "code" to CodeTextSource.serializer(),
    "url" to URLTextSource.serializer(),
    "pre" to PreTextSource.serializer(),
    "bot_command" to BotCommandTextSource.serializer(),
    "strikethrough" to StrikethroughTextSource.serializer(),
    "italic" to ItalicTextSource.serializer(),
    "bold" to BoldTextSource.serializer(),
    "email" to EMailTextSource.serializer(),
    "underline" to UnderlineTextSource.serializer(),
    "mention" to MentionTextSource.serializer(),
    "phone_number" to PhoneNumberTextSource.serializer(),
    "text_mention" to TextMentionTextSource.serializer(),
    "hashtag" to HashTagTextSource.serializer(),
    "cashtag" to CashTagTextSource.serializer(),
    "spoiler" to SpoilerTextSource.serializer(),
    "custom_emoji" to CustomEmojiTextSource.serializer(),
)

object TextSourceSerializer : TypedSerializer<TextSource>(TextSource::class, baseSerializers) {
    override fun <T: TextSource> include(type: String, serializer: KSerializer<T>) {
        require(type !in baseSerializers.keys)
        super.include(type, serializer)
    }

    override fun exclude(type: String) {
        require(type !in baseSerializers.keys)
        super.exclude(type)
    }
}
