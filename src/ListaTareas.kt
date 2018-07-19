class ListaTareas(
    val nombre:String,
    var Seleccionada:Boolean= false,
    var Tareas:ArrayList<Tarea> = ArrayList()
) {
    fun agregarTarea(tarea: Tarea){
        Tareas.add(tarea)
    }
    fun getMenuTareas():String{
        var menu= ""
        for (i in Tareas.indices){
            menu+="${i+1}  ${Tareas[i]}\n"
        }
        return menu
    }

    override fun toString(): String {
        return """
            Lista
            nombre: $nombre""".trimIndent()
    }
    fun getTarea(pos: Int): Tarea{
        var tarea=Tareas[pos]
        return tarea
        }
}
