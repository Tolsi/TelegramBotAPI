package com.github.insanusmokrassar.TelegramBotAPI.requests.abstracts

import com.github.insanusmokrassar.TelegramBotAPI.utils.StorageFile
import kotlinx.serialization.*
import kotlinx.serialization.internal.StringDescriptor

@Serializable(InputFileSerializer::class)
sealed class InputFile {
    abstract val fileId: String
}

// TODO:: add checks for file url/file id regex
/**
 * Contains file id or file url
 */
@Serializable(InputFileSerializer::class)
data class FileId(
    override val fileId: String
) : InputFile()

fun String.toInputFile() = FileId(this)

@Serializer(InputFile::class)
internal object InputFileSerializer : KSerializer<InputFile> {
    override val descriptor: SerialDescriptor = StringDescriptor.withName(FileId::class.toString())
    override fun serialize(encoder: Encoder, obj: InputFile) = encoder.encodeString(obj.fileId)
    override fun deserialize(decoder: Decoder): FileId = FileId(decoder.decodeString())
}

// TODO:: add checks for files size
/**
 * Contains info about file for sending
 */
@Serializable(InputFileSerializer::class)
data class MultipartFile (
    val file: StorageFile,
    val mimeType: String = file.contentType,
    val filename: String = file.fileName
) : InputFile() {
    override val fileId: String = file.generateCustomName()
}
