package hr.hofman.composednews.data.remote

import java.io.File

class Utils {

    companion object {
        fun getJson(path: String): String {
            val uri = this::class.java.classLoader!!.getResource(path)
            val file = File(uri.path)
            return String(file.readBytes())
        }
    }
}

