class Tarea (
        val nombre: String,
        var Completa:Boolean= false)
{fun completarTarea(){Completa=true}
    override fun toString(): String {
        return """
            nombre: $nombre""".trimIndent()
    }
}

