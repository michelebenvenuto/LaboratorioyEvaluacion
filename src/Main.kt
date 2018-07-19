import com.sun.org.apache.xpath.internal.operations.Bool
import sun.applet.Main

fun main(arg:Array<String>){
    val menu1:String=("""
        Menu:
        1)Crear Lista de Tareas
        2)Salir
        """.trimIndent())
    val menu2:String=("""
        Menu:
        1)Crear lista de Tareas
        2)Ver Todas las listas de Tareas
        3)Seleccionar una lista de Tareas
        4)Salir
        """.trimIndent())
    val menu3: String=("""
        Menu:
        1)Deseleccionar Lista actual
        2)Agregar una Tarea
        3)Completar una Tarea
        4)Ver todas las Tareas en la lista
        5)Salir
        """.trimIndent())
    var wantsToContinue:Boolean=true
    var mylista= ListadeListas()
    do {
        if(mylista.listadelistas.count()==0){
            println(menu1)
            print("Escoga una de las opciones:")
            var opcion= readLine()!!.toInt()
            if(opcion==1){
                println("Ingrese el nombre de la lista de su nueva lista de tareas")
                var nombre = readLine()!!
                var listadetarea = ListaTareas(nombre = nombre)
                mylista.agregarLista(listadetarea)}
            else if(opcion==2){
                wantsToContinue=false
            } else {
                println("Esta opcion no esta en el menu")
            }
        }
         else if(mylista.listadelistas.count()>0 && mylista.getListaSeleccionada()==null ) {
            println(menu2)
            print("Escoja una de las opciones")
            var opcion = readLine()!!.toInt()
            if (opcion==1){
                println("Ingrese el nombre de la lista de su nueva lista de tareas")
                var nombre = readLine()!!
                var listadetarea = ListaTareas(nombre = nombre)
                mylista.agregarLista(listadetarea)
            }
            else if(opcion==2){
                for(x in mylista.listadelistas){
                    println(x)
                }
            }
            else if(opcion==3) {
                for (i in mylista.getMenuListas()) {
                    println(i)
                }
            }
        }
    }while(wantsToContinue)

}