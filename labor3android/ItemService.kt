class ItemService(val itemrepository: ItemRepository) {
    private var lista = mutableListOf<Item>()
    fun selectRandomItems(n: Int): List<Item> {

        while (lista.size < n) {
            if (!lista.contains(itemrepository.randomItem())) {
                lista.add(itemrepository.randomItem())
            }
        }
        return lista
    }
}