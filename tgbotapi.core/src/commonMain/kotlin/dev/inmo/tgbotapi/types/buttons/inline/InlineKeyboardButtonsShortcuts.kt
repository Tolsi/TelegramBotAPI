package dev.inmo.tgbotapi.types.buttons.inline

import dev.inmo.tgbotapi.types.LoginURL
import dev.inmo.tgbotapi.types.buttons.InlineKeyboardButtons.*
import dev.inmo.tgbotapi.types.webapps.WebAppInfo

/**
 * Creates and put [PayInlineKeyboardButton]
 *
 * @see inlineKeyboard
 * @see InlineKeyboardBuilder.row
 */
inline fun payInlineButton(
    text: String
) = PayInlineKeyboardButton(text)

/**
 * Creates and put [CallbackDataInlineKeyboardButton]
 *
 * @see inlineKeyboard
 * @see InlineKeyboardBuilder.row
 */
inline fun dataInlineButton(
    text: String,
    data: String
) = CallbackDataInlineKeyboardButton(text, data)

/**
 * Creates and put [CallbackGameInlineKeyboardButton]
 *
 * @see inlineKeyboard
 * @see InlineKeyboardBuilder.row
 */
inline fun gameInlineButton(
    text: String
) = CallbackGameInlineKeyboardButton(text)

/**
 * Creates and put [LoginURLInlineKeyboardButton]
 *
 * @see inlineKeyboard
 * @see InlineKeyboardBuilder.row
 */
inline fun loginInlineButton(
    text: String,
    loginUrl: LoginURL
) = LoginURLInlineKeyboardButton(text, loginUrl)

/**
 * Creates and put [SwitchInlineQueryCurrentChatInlineKeyboardButton]
 *
 * @see inlineKeyboard
 * @see InlineKeyboardBuilder.row
 */
inline fun inlineQueryInCurrentChatInlineButton(
    text: String,
    data: String
) = SwitchInlineQueryCurrentChatInlineKeyboardButton(text, data)

/**
 * Creates and put [SwitchInlineQueryInlineKeyboardButton]
 *
 * @see inlineKeyboard
 * @see InlineKeyboardBuilder.row
 */
inline fun inlineQueryInlineButton(
    text: String,
    data: String
) = SwitchInlineQueryInlineKeyboardButton(text, data)

/**
 * Creates and put [URLInlineKeyboardButton]
 *
 * @see inlineKeyboard
 * @see InlineKeyboardBuilder.row
 */
inline fun urlInlineButton(
    text: String,
    url: String
) = URLInlineKeyboardButton(text, url)

/**
 * Creates and put [WebAppInlineKeyboardButton]. Please, remember that this button is available in private chats only
 *
 * @see inlineKeyboard
 * @see InlineKeyboardBuilder.row
 */
inline fun webAppInlineButton(
    text: String,
    webApp: WebAppInfo
) = WebAppInlineKeyboardButton(text, webApp)

/**
 * Creates and put [WebAppInlineKeyboardButton]. Please, remember that this button is available in private chats only
 *
 * @see inlineKeyboard
 * @see InlineKeyboardBuilder.row
 */
inline fun webAppInlineButton(
    text: String,
    url: String
) = webAppInlineButton(text, WebAppInfo(url))
