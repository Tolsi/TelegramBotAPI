package dev.inmo.tgbotapi.extensions.api.edit.reply_markup

import dev.inmo.tgbotapi.bot.TelegramBot
import dev.inmo.tgbotapi.requests.edit.reply_markup.EditInlineMessageReplyMarkup
import dev.inmo.tgbotapi.types.InlineMessageIdentifier
import dev.inmo.tgbotapi.types.buttons.InlineKeyboardMarkup

/**
 * @param replyMarkup Some [InlineKeyboardMarkup]. See [dev.inmo.tgbotapi.extensions.utils.types.buttons.inlineKeyboard]
 * as a builder for that
 */
suspend fun TelegramBot.editMessageReplyMarkup(
    inlineMessageId: InlineMessageIdentifier,
    replyMarkup: InlineKeyboardMarkup? = null
) = execute(EditInlineMessageReplyMarkup(inlineMessageId, replyMarkup))
