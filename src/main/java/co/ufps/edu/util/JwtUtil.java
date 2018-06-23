package co.ufps.edu.util;

import java.io.UnsupportedEncodingException;
import java.util.Map.Entry;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {

	// @Value("${jwt.secret}")
	private String secret = "secret";

	/**
	 * Tries to parse specified String as a JWT token. If successful, returns User
	 * object with username, id and role prefilled (extracted from token). If
	 * unsuccessful (token is invalid or not containing all required user
	 * properties), simply returns null.
	 * 
	 * @param token
	 *            the JWT token to parse
	 * @return the User object extracted from specified token or null if a token is
	 *         invalid.
	 */

	public int parseToken(String token) {
		try {
			Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
			int codigo = Integer.parseInt(body.get("codigo").toString());
			return codigo;
		} catch (JwtException | ClassCastException e) {
			return 0;
		} catch(Exception ex) {
			return 0;
		}
		
	}

	/**
	 * Generates a JWT token containing username as subject, and userId and role as
	 * additional claims. These properties are taken from the specified User object.
	 * Tokens validity is infinite.
	 * 
	 * @param u
	 *            the user for which the token will be generated
	 * @return the JWT token
	 */
	public String generateToken(String rol, String codigo) {
		Claims claims = Jwts.claims().setSubject("users/" + rol);
		claims.put("codigo", codigo);
		claims.put("rol", rol);

		return Jwts.builder()
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}
}
