package com.programming.techie.springngblog.security.jwt;

        import com.programming.techie.springngblog.exception.SpringBlogException;
        import com.programming.techie.springngblog.repository.UserRepository;
        import io.jsonwebtoken.Claims;
        import io.jsonwebtoken.Jwts;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.security.core.Authentication;
        import org.springframework.security.core.userdetails.User;
        import org.springframework.stereotype.Service;
        import javax.annotation.PostConstruct;
        import java.io.IOException;
        import java.io.InputStream;
        import java.security.*;
        import java.security.cert.CertificateException;
        import java.util.Date;

@Service
public class JwtProvider {
    private KeyStore keyStore;

    @Autowired
    UserRepository userRepository;

    @PostConstruct
    public void init() {
        try {
            keyStore = KeyStore.getInstance("JKS");
            InputStream resourceAsStream = getClass().getResourceAsStream("/springblog.jks");
            keyStore.load(resourceAsStream, "secret".toCharArray());
        } catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e) {
            throw new SpringBlogException("Exception occured while loading keystore");
        }
    }


    public String generateToken(Authentication authentication) {
        User principal = (User) authentication.getPrincipal();
        com.programming.techie.springngblog.model.User user =
                userRepository.findByUsername(principal.getUsername()).get();
        /* Handle the expiration of the token */
        long jwtExpirationMs = 6000000;
        /* Handle the content of the token */
        return Jwts.builder()
                .setSubject(principal.getUsername())
                .signWith(getPrivateKey())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .claim("role", principal.getAuthorities())
                .compact();
    }

    private PrivateKey getPrivateKey() {
        try {
            return (PrivateKey) keyStore.getKey("springblog", "secret".toCharArray());
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
            throw new SpringBlogException("Exception occured while retrieving public key from keystore");
        }
    }

    public boolean validateToken(String jwt) {
        Jwts.parser().setSigningKey(getPublickey()).parseClaimsJws(jwt);
        return true;
    }

    private PublicKey getPublickey() {
        try {
            return keyStore.getCertificate("springblog").getPublicKey();
        } catch (KeyStoreException e) {
            throw new SpringBlogException("Exception occured while retrieving public key from keystore");
        }
    }

    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(getPublickey())
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

}
