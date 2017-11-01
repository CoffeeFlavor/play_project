import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * User: jennie
 * Date: 2017/7/27
 * Time: 15:12
 */
public class MyRealm2 implements Realm{

    public String getName() {
        return "myrealm1";
    }

    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username=(String)authenticationToken.getPrincipal();
        String password=new String((char[])authenticationToken.getCredentials());
        if (!"wang".equals(username)){
            throw new UnknownAccountException();
        }
        if (!"123".equals(password)){
            throw new IncorrectCredentialsException();
        }

        return new SimpleAuthenticationInfo(username,password,getName());
    }
}
