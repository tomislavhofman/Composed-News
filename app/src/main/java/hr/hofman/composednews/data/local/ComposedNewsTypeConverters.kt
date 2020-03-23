package hr.hofman.composednews.data.local

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.threeten.bp.Instant
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter


object ComposedNewsTypeConverters {
    private val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
    private val requestValues by lazy { Request.values() }
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @TypeConverter
    @JvmStatic
    fun toOffsetDateTime(value: String?) =
        value?.let { formatter.parse(value, OffsetDateTime::from) }

    @TypeConverter
    @JvmStatic
    fun fromOffsetDateTime(date: OffsetDateTime?): String? = date?.format(formatter)

    @TypeConverter
    @JvmStatic
    fun toInstant(value: Long?) = value?.let { Instant.ofEpochMilli(it) }

    @TypeConverter
    @JvmStatic
    fun fromInstant(date: Instant?) = date?.toEpochMilli()

    @TypeConverter
    @JvmStatic
    fun fromRequest(value: Request) = value.tag

    @TypeConverter
    @JvmStatic
    fun toRequest(value: String) = requestValues.firstOrNull { it.tag == value }
}