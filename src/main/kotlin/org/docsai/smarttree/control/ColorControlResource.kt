package org.docsai.smarttree.control

import org.docsai.smarttree.config.MQTTConfig
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import java.awt.Color

@RestController
@RequestMapping("/color")
class ColorControlResource(val mqttGateway: MQTTConfig.MQTTGateway) {

    companion object {
        val LOG: Logger = LoggerFactory.getLogger(this.javaClass)
    }

    @PostMapping
    fun setColor(@RequestBody colorHsb: Map<String, Double>): String {
        LOG.info("setColor: $colorHsb")
        val rgbMessage = hsvToRgbMessage(colorHsb)
        mqttGateway.publish("color", rgbMessage)
        return rgbMessage
    }

    private fun hsbToRGBMessage(colorHsb: Map<String, Double>): String {
        val hue = colorHsb.getOrDefault("hue", 350.5).toFloat()
        val saturation = colorHsb.getOrDefault("saturation", 0.7138).toFloat()
        val brightness = colorHsb.getOrDefault("brightness", 0.6524).toFloat()

        val color = Color.getHSBColor(hue, saturation, brightness)

        return "" + color.red + "_" + color.green + "_" + color.blue
    }

    private fun hsvToRgbMessage(colorHsb: Map<String, Double>): String {
        val hue = colorHsb.getOrDefault("hue", 350.5).toFloat()
        val saturation = colorHsb.getOrDefault("saturation", 0.7138).toFloat()
        val value = colorHsb.getOrDefault("brightness", 0.6524).toFloat()

        val h = (hue * 6).toInt()
        val f = hue * 6 - h
        val p = value * (1 - saturation)
        val q = value * (1 - f * saturation)
        val t = value * (1 - (1 - f) * saturation)

        when (h) {
            0 -> return rgbToString(value, t, p)
            1 -> return rgbToString(q, value, p)
            2 -> return rgbToString(p, value, t)
            3 -> return rgbToString(p, q, value)
            4 -> return rgbToString(t, p, value)
            5 -> return rgbToString(value, p, q)
            else -> throw RuntimeException("Something went wrong when converting from HSV to RGB. Input was $hue, $saturation, $value")
        }
    }

    private fun rgbToString(r: Float, g: Float, b: Float): String {
        val rs = Integer.toHexString((r * 256).toInt())
        val gs = Integer.toHexString((g * 256).toInt())
        val bs = Integer.toHexString((b * 256).toInt())
        return rs + "_" + gs + "_" + bs
    }
}