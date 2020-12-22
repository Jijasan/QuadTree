import java.awt.Canvas
import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.image.BufferStrategy
import javax.swing.DebugGraphics
import javax.swing.JFrame

fun print(tree: QuadTree?, graphics: Graphics, x: Int, y: Int, width: Int, height: Int) {
    if (tree == null) {
        return
    }
    if (tree.ld == null && tree.lu == null && tree.rd == null && tree.ru == null) {
        graphics.color = Color.WHITE
        graphics.drawRect(x, y, width, height)
        return
    }
    print(tree.ld, graphics, x, y, width / 2, height / 2)
    print(tree.lu, graphics, x, y + height / 2, width / 2, height / 2)
    print(tree.rd, graphics, x + width / 2, y, width / 2, height / 2)
    print(tree.ru, graphics, x + width / 2, y + height / 2, width / 2, height / 2)
}

fun main() {
    val frame = JFrame("QuadTree")
    frame.setSize(1100, 1100)
    frame.isResizable = false
    frame.isVisible = true
    val canvas = Canvas()
    canvas.setSize(1024, 1024)
    canvas.background = Color.BLACK
    canvas.isVisible = true

    val listener = MyListener()
    canvas.addMouseListener(listener)
    canvas.addMouseMotionListener(listener)

    frame.add(canvas)

    canvas.createBufferStrategy(3)

    val tree = QuadTree()

    while (true) {
        val strategy = canvas.bufferStrategy
        val graphics = strategy.drawGraphics

        if (listener.flag) {
            if (listener.x >= 10 && listener.y >= 10 && listener.x < 1034 && listener.y < 1034) {
                tree.remove(listener.x - 10, listener.y - 10, 0, 0, 1024, 1024)
            }
            println(listener.x.toString() + ":" + listener.y.toString())
            listener.flag = false
        }


        graphics.clearRect(0, 0, 1024, 1024)
        print(tree, graphics, 10, 10, 1024, 1024)

        strategy.show()
        graphics.dispose()
    }

}