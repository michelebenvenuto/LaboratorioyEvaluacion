class ListaTareas(
    val nombre:String,
    var Seleccionada:Boolean= false,
    var Tareas:ArrayList<Tarea> = ArrayList()
) {
    fun agregarTarea(tarea: Tarea){
        Tareas.add(tarea)
    }


    fun seleccionarTarea(){
        Seleccionada=true
    }

    override fun toString(): String {
        return """
            Lista
            nombre: $nombre""".trimIndent()
    }
}
