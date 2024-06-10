package vn.edu.vti.vmall.vmall_user_manager.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;
import javax.crypto.SecretKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JwtUtil {

  private byte[] generateKey(String key) {
    try {
      MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
      byte[] hash = sha256.digest(key.getBytes(StandardCharsets.UTF_8));
      return Arrays.copyOf(hash, 32); // Ensure the key is exactly 32 bytes long
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("SHA-256 algorithm not found", e);
    }
  }

  private SecretKey getKey(){
    String stringKey = "your-secret-key-string";
    byte[] keyBytes = generateKey(stringKey);
    return Keys.hmacShaKeyFor(keyBytes);
  }

  public String genToken(String username){
    String jwt = Jwts.builder()
        .issuer("vmall-user-manager")
        .issuedAt(new Date()) // Set the issue time
        .expiration(new Date(System.currentTimeMillis() + 3600000))
        .claim("username", username) // Set custom claims
        .signWith(getKey()) // Sign the JWT with the key
        .compact(); // Build and serialize the JWT to a URL-safe string
    return jwt;
  }

  public Claims validate(String token){
    try {
      return Jwts.parser().
          verifyWith(getKey())
          .build()
          .parseSignedClaims(token)
          .getPayload();
    }catch (Exception e){
      log.error("(validate)Exception with message: [{}]",
          e.getMessage());
    }
    return null;
  }
}
