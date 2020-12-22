import java.awt.event.MouseEvent
import javax.swing.event.MouseInputAdapter

class MyListener: MouseInputAdapter() {

    var x = 0
    var y = 0
    var flag = false

    override fun mouseClicked(e: MouseEvent?) {
        x = e!!.x
        y = e!!.y
        flag = true
    }

    override fun mousePressed(e: MouseEvent?) {
        x = e!!.x
        y = e!!.y
        flag = true
    }

    override fun mouseDragged(e: MouseEvent?) {
        x = e!!.x
        y = e!!.y
        flag = true
    }

}