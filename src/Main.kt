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
    val mylista= ListadeListas()
    do {
        if(mylista.listadelistas.count()==0){
            println(menu1)
            print("Escoga una de las opciones:")
            var opcion= readLine()!!.toInt()
            if(opcion==1){
                print("Ingrese el nombre de la lista de su nueva lista de tareas:")
                val nombre = readLine()!!
                val listadetarea = ListaTareas(nombre = nombre)
                mylista.agregarLista(listadetarea)}
            else if(opcion==2){
                wantsToContinue=false
            } else {
                println("Esta opcion no esta en el menu")
            }
        }
         else if(mylista.listadelistas.count()>0 && mylista.getListaSeleccionada()==null ) {
            println(menu2)
            print("Escoja una de las opciones:")
            var opcion = readLine()!!.toInt()
            if (opcion==1){
                print("Ingrese el nombre de la lista de su nueva lista de tareas:")
                val nombre = readLine()!!
                val listadetarea = ListaTareas(nombre = nombre)
                mylista.agregarLista(listadetarea)
            }
            else if(opcion==2){
                for(x in mylista.listadelistas){
                    println(x)
                    print("")
                }
            }
            else if(opcion==3) {
                println(mylista.getMenuListas())
                print("Escoga la lista que desea seleccionar:")
                opcion = readLine()!!.toInt()
                val listaEscogida= mylista.getLista(opcion-1)
                listaEscogida.Seleccionada=true
                println("Se a seleccionado la lista de tareas ${listaEscogida.nombre}")
            }
            else if (opcion==4){
                wantsToContinue=false
            }else{
                println("Esta opcion no esta en el menu")}
        }
        else if (mylista.listadelistas.count()>0 && mylista.getListaSeleccionada()!=null){
            println(menu3)
            print("Escoga una de las opciones:")
            val opcion = readLine()!!.toInt()
            if(opcion==1){
                val listaActual= mylista.getListaSeleccionada()
                listaActual!!.Seleccionada=false
                println("La lista ${listaActual.nombre} a sido deseleccionada")
            }
            else if (opcion==2){
                print("Ingrese el nombre de la tarea:")
                val nombreTarea= readLine()!!
                val nuevaTarea= Tarea(nombreTarea)
                val listaActual= mylista.getListaSeleccionada()
                listaActual!!.agregarTarea(nuevaTarea)
            }
            else if (opcion==3){
                val listaActual= mylista.getListaSeleccionada()
                if (listaActual!!.Tareas.count()==0){
                    println("No hay tareas")
                }else{
                println(listaActual!!.getMenuTareas())
                val tareaCompletada = readLine()!!.toInt()
                val completada= listaActual!!.getTarea(tareaCompletada-1)
                if(completada.Completa==false){
                    completada.completarTarea()
                    println("La tarea ${completada.nombre} se ha completado")
                }else{completada.Completa=true
                    println("La tarea ${completada.nombre} se ha descompletado")}

            }}
            else if (opcion==4){
                val listaActual= mylista.getListaSeleccionada()
                println(listaActual!!.getMenuTareas())
            }
            else if(opcion==5){
                wantsToContinue= false
            }else{
                println("Esta opcion no esta en el menu")}
        }
    }while(wantsToContinue)

}