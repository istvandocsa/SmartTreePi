package org.docsai.smarttree

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.integration.annotation.IntegrationComponentScan

@SpringBootApplication(scanBasePackages = ["org.docsai.smarttree"])
@IntegrationComponentScan
class SmartTreeApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(SmartTreeApplication::class.java)
        }
    }

}