package com.example.adat03_proyectoAPI.security

import org.springframework.boot.context.properties.ConfigurationProperties
import java.security.interfaces.RSAPrivateKey
import java.security.interfaces.RSAPublicKey


@ConfigurationProperties
data class RSAKeysProperties(
    var publicKey: RSAPublicKey,
    var privateKey: RSAPrivateKey
)