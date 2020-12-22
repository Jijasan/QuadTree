class QuadTree(
    var ld: QuadTree? = null,
    var lu: QuadTree? = null,
    var rd: QuadTree? = null,
    var ru: QuadTree? = null
) {

    fun remove(x: Int, y: Int, x1: Int, y1: Int, x2: Int, y2: Int) {
        println(x1.toString() + ":" + y1.toString() + "-" + x2.toString() + ":" + y2.toString() + " = "
            + x.toString() + ":" + y.toString())
        if (x == x1 && x == x2 - 1 && y == y1 && y == y2 - 1) {
            return
        }
        if (ld == null) {
            ld = QuadTree()
        }
        if (lu == null) {
            lu = QuadTree()
        }
        if (rd == null) {
            rd = QuadTree()
        }
        if (ru == null) {
            ru = QuadTree()
        }
        val xm = (x1 + x2) / 2
        val ym = (y1 + y2) / 2
        var cnt = 0
        if (x < xm) {
            if (y < ym) {
                ld!!.remove(x, y, x1, y1, xm, ym)
                ++cnt
            }
            else {
                lu!!.remove(x, y, x1, ym, xm, y2)
                ++cnt
            }
        }
        else {
            if (y < ym) {
                rd!!.remove(x, y, xm, y1, x2, ym)
                ++cnt
            }
            else {
                ru!!.remove(x, y, xm, ym, x2, y2)
                ++cnt
            }
        }
        println(cnt)
    }

    override fun toString(): String {
        var ans = ""
        ans += "["
        if (ld != null) {
            ans += ld!!.toString()
        }
        if (lu != null) {
            ans += lu!!.toString()
        }
        if (rd != null) {
            ans += rd!!.toString()
        }
        if (ru != null) {
            ans += ru!!.toString()
        }
        ans += "]"
        return ans
    }

}