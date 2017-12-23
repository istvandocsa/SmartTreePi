package org.docsai.smarttree.common.iface

object PowerController: ReportingAlexaInterface() {
    override val `interface`: String
        get() = "Alexa.PowerController"
    override val properties: InterfaceProperties<Map<String, String>>
        get() = InterfaceProperties(listOf(mapOf("name" to "powerState")))

}