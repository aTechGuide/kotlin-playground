package guide.atech.practice

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

/**
 * rockthejvm -> OOP Exercise
 */
// manipulating images
// 24bit integer = Int
// 00000000rrrrrrrrggggggggbbbbbbbb

class Color(r: Int, g: Int, b: Int) {

    val red: Int = clampColor(r) // 000000000000000000000000rrrrrrrr
    val green: Int = clampColor(g) // 000000000000000000000000gggggggg
    val blue: Int = clampColor(b) // 000000000000000000000000bbbbbbbb

    // 00000000rrrrrrrr0000000000000000
    // 0000000000000000gggggggg00000000
    // 000000000000000000000000bbbbbbbb
    // 00000000rrrrrrrrggggggggbbbbbbbb
    fun toInt() =
        (red shl 16) or (green shl 8) or blue

    fun clampColor(v: Int) =
        if (v <= 0) 0
        else if (v >= 255) 255
        else v

    fun draw(width: Int, height: Int, path: String) {
        val pixelInt = toInt()
        val image = BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
        val pixels = IntArray(width * height) { pixelInt }
        image.setRGB(0,0,width,height, pixels, 0, width)
        ImageIO.write(image, "JPG", File(path))
    }

    companion object {
        val BLACK = Color(0,0,0)
        val RED = Color(255,0,0)
        val GREEN = Color(0,255,0)
        val BLUE = Color(0,0,255)
        val GRAY = Color(128,128,128)

        fun fromHex(arg: Int): Color {
            val red = (arg and 0xFF0000) shr 16
            val green = (arg and 0xFF00) shr 8
            val blue = arg and 0xFF
            return Color(red, green, blue)
        }
    }

}

fun main() {
    val red = Color(255, 0, 0)
    red.draw(20, 20, "src/main/resources/red.jpg")
}

