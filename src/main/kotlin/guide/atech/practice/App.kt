package guide.atech.practice

import java.awt.Dimension
import java.awt.Graphics
import java.util.*
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.WindowConstants
import kotlin.system.exitProcess

/**
 * rockthejvm -> OOP Exercise: The UI
 */
object App {
    private lateinit var frame: JFrame
    private lateinit var imagePanel: ImagePanel

    class ImagePanel(private var image: Image): JPanel() {
        override fun paintComponent(g: Graphics) {
            super.paintComponent(g)
            // render the picture inside this "graphics"
            image.draw(g)
        }

        override fun getPreferredSize(): Dimension =
            Dimension(image.width, image.height)

        fun replaceImage(newImage: Image) {
            image = newImage
            revalidate()
            repaint()
        }

        fun getImage() = image
    }

    fun loadResource(path: String) {
        val image = Image.loadResource(path)
        if (!this::frame.isInitialized) {
            frame = JFrame("Kotlin Rocks Image App")
            imagePanel = ImagePanel(image)

            frame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
            frame.contentPane.add(imagePanel)
            frame.pack()
            frame.isVisible = true
        } else {
            imagePanel.replaceImage(image)
            frame.pack() // resizes the window to the "preferred dimensions"
        }
    }

}