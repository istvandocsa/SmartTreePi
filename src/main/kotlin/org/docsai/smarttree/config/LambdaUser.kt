package org.docsai.smarttree.config

import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Component

@Component
object LambdaUser : User("SmartTreeLambda", "", listOf(SimpleGrantedAuthority("USER"))), Authentication {

    private var authenticated: Boolean = true
    internal val clientId = getClientId()

    private fun getClientId(): String {
        val clientId = System.getenv("ST_LAMBDA_CLIENT_ID")
        if (clientId != null)
            return clientId
        else
            throw IllegalStateException("Lambda ClientId must be provided as an ENV variable.")

    }

    override fun setAuthenticated(isAuthenticated: Boolean) {
        authenticated = isAuthenticated
    }

    override fun getName(): String = username

    override fun getCredentials(): Any = this

    override fun getPrincipal(): Any = this

    override fun isAuthenticated(): Boolean = authenticated

    override fun getDetails(): Any = this
}
