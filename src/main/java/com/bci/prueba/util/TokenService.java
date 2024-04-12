package com.bci.prueba.util;


import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenService {

  private static final String SECRET_KEY = "2D4A614E645267556B58703273357638792F423F4428472B4B6250655368566D";
  private static final long EXPIRATION_TIME = 3600000;

  public String generateToken(String userId) {
    // Obtener la fecha actual
    Date now = new Date();
    
    // Calcular la fecha de expiración
    Date expirationDate = new Date(now.getTime() + EXPIRATION_TIME);

    // Construir el token JWT
    return Jwts.builder()
            .setSubject(userId) // ID del usuario como contenido del token
            .setIssuedAt(now) // Fecha de emisión del token
            .setExpiration(expirationDate) // Fecha de expiración del token
            .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // Firmar el token con el algoritmo HMAC-SHA256 y la clave secreta
            .compact();
}
}
