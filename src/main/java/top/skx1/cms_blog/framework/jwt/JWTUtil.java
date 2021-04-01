package top.skx1.cms_blog.framework.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;
import top.skx1.cms_blog.entity.User;
import top.skx1.cms_blog.framework.exception.MyException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/*
 * @Author shaokexiang
 * @Date 2021/2/2 22:41
 * @Description //jwt的工具类
 * @Param
 * @return
 **/
public class JWTUtil {


    public static String token = "token";
    //密钥
    public static String jwt_secret="skx@cmsblog@1294234770.";
    //过期时长
    public static long jwt_expr = 3600*24*1000;

    //1、生成token
    public static String sign(User user){
        //指定签名的时候使用签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //生成签发时间
        long nowMillis = System.currentTimeMillis();
        Date date = new Date(nowMillis);

        //创建playload的私有声明
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",user.getId());
        claims.put("userName",user.getUserName());//id写错

        //生成签发人
        String subject = user.getUserName();
        JwtBuilder builder = Jwts.builder().setClaims(claims).setId(UUID.randomUUID().toString()).setIssuedAt(date).setSubject(subject).signWith(signatureAlgorithm,jwt_secret);
        //设置过期时间
        Date expDate = new Date(nowMillis + jwt_expr);
        builder.setExpiration(expDate);
        return builder.compact();
    }
    //2、验证token
    public static boolean verify(String token){
        try{
            if (StringUtils.isEmpty(token)){
                return false;
            }
            Jwts.parser().setSigningKey(jwt_secret).parseClaimsJws(token).getBody();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
    //3、获取用户信息

    public static User getUser(String token){
        try{
            if (StringUtils.isEmpty(token)){
                throw new MyException("token不能为空");
            }
            if(verify(token)){
                Claims claims = Jwts.parser().setSigningKey(jwt_secret).parseClaimsJws(token).getBody();
                User user = new User();
                user.setId(Integer.parseInt(claims.get("id")+""));
                user.setUserName(claims.get("userName")+"");
                return user;
            }else {
                throw new MyException("超时或不合法token");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new MyException("超时或不合法token");
        }
    }

    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setUserName("admin");
        System.out.println(sign(user));
    }


}
