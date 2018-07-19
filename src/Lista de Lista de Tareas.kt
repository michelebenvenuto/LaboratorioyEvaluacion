class ListadeListas(
        var listadelistas:ArrayList<ListaTareas> = ArrayList()
)
{fun agregarLista(lista: ListaTareas){
  listadelistas.add(lista)
}
 fun getListaSeleccionada():ListaTareas?{
     var listasFiltradas= listadelistas.filter { it.Seleccionada}
     if(listasFiltradas.count()>0){
         return listasFiltradas[0]
     }else{return null}
    }
 fun getMenuListas():String{
     var menu= ""
     for (i in listadelistas.indices){
         menu+="${i+1}  ${listadelistas[i]}\n"
     }
     return menu
 }
 fun getLista(pos: Int): ListaTareas{
     var lista=listadelistas[pos]
     return lista
 }
}
