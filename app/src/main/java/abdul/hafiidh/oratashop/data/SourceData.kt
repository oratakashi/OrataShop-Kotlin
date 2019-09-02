package abdul.hafiidh.oratashop.data

import abdul.hafiidh.oratashop.R

object SourceData {
    private val productName = arrayOf(
        "Samsung A70 2019",
        "Oppo a11 Pro",
        "Redmi Note 7",
        "Samsung S10",
        "Asus ROG GL553VD",
        "Lenovo Yoga 730",
        "HP 14-D004AX",
        "Hp Printer 2622",
        "Canon Pixma MP 287",
        "Armaggeddon Nuke 11"
    )
    private val productPrice = intArrayOf(
        5700000,
        2300000,
        2400000,
        12700000,
        10800000,
        16400000,
        3200000,
        700000,
        600000,
        350000
    )
    private val productPhoto = intArrayOf(
        R.drawable.samsunga70,
        R.drawable.oppof11,
        R.drawable.reno7,
        R.drawable.s10,
        R.drawable.roggl553vd,
        R.drawable.yoga730,
        R.drawable.hp14,
        R.drawable.hp2622,
        R.drawable.canonpixma,
        R.drawable.armageddonnuke
    )

    val listData: ArrayList<ModelProduct>
        get() {
            val list = arrayListOf<ModelProduct>()
            for (position in productName.indices) {
                val product = ModelProduct()
                product.name = productName[position]
                product.price = productPrice[position]
                product.photo = productPhoto[position]
                list.add(product)
            }
            return list
        }
}