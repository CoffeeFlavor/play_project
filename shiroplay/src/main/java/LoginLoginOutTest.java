import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

import java.net.URL;

/**
 * User: jennie
 * Date: 2017/7/27
 * Time: 14:10
 */
public class LoginLoginOutTest {

    @Test
    public void testHelloWorld(){

        URL url=this.getClass().getClassLoader().getResource("shiro-config.ini");

        Factory<SecurityManager>  factory=new IniSecurityManagerFactory(url.getPath());


        SecurityManager securityManager=factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject=SecurityUtils.getSubject();

        UsernamePasswordToken token=new UsernamePasswordToken("zhang","123");

        subject.login(token);
        Assert.assertEquals(true,subject.isAuthenticated());
    }

    @Test
    public void testJDBCRealm(){
        URL url=this.getClass().getClassLoader().getResource("shiro-jdbc-realm.ini");
        Factory<SecurityManager> factory=new IniSecurityManagerFactory(url.getPath());
        SecurityManager securityManager=factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("zhang","1234");
        subject.login(token);
        Assert.assertEquals(true,subject.isAuthenticated());
        subject.logout();
    }
}
