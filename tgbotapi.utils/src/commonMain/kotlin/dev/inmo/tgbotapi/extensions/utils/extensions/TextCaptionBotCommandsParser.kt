package dev.inmo.tgbotapi.extensions.utils.extensions

import dev.inmo.tgbotapi.abstracts.TextedWithTextSources
import dev.inmo.tgbotapi.types.message.abstracts.ContentMessage
import dev.inmo.tgbotapi.types.message.content.TextContent
import dev.inmo.tgbotapi.types.message.textsources.BotCommandTextSource
import dev.inmo.tgbotapi.types.message.textsources.TextSource


val defaultArgsSeparator = Regex(" ")
/**
 * Parse commands and their args. Logic will find command, get all subsequent data as args until new command
 */
fun List<TextSource>.parseCommandsWithParams(
    argsSeparator: Regex = defaultArgsSeparator
): MutableMap<String, Array<String>> {
    val result = mutableMapOf<String, Array<String>>()
    var currentBotCommandSource: BotCommandTextSource? = null
    var currentArgs = ""
    fun includeCurrent() = currentBotCommandSource ?.let {
        currentArgs = currentArgs.trim()
        result[it.command] = if (currentArgs.isNotEmpty()) {
            currentArgs.split(argsSeparator).toTypedArray()
        } else {
            emptyArray()
        }
        currentArgs = ""
        currentBotCommandSource = null
    }
    for (textSource in this) {
        if (textSource is BotCommandTextSource) {
            includeCurrent()
            currentBotCommandSource = textSource
        } else {
            currentArgs += textSource.source
        }
    }
    includeCurrent()
    return result
}

/**
 * Parse commands and their args. Logic will find command, get all subsequent data as args until new command
 */
fun TextedWithTextSources.parseCommandsWithParams(
    argsSeparator: Regex = defaultArgsSeparator
) = textSources ?.parseCommandsWithParams(argsSeparator) ?: emptyMap()

/**
 * Parse commands and their args. Logic will find command, get all subsequent data as args until new command
 */
fun ContentMessage<TextContent>.parseCommandsWithParams(
    argsSeparator: Regex = defaultArgsSeparator
) = content.parseCommandsWithParams(argsSeparator)
