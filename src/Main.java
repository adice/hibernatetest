import com.entity.LoginUser;
import com.entity.Menu;
import com.entity.Power;
import com.entity.Role;
import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;
import java.util.Map;

/**
 * Created by adice on 2016/10/20.
 */
public class Main {
    static SessionFactory ourSessionFactory;
    static {
        try {
            //配置类型安全的准服务注册类
            StandardServiceRegistryBuilder ssrb=new StandardServiceRegistryBuilder();
            StandardServiceRegistry sr=ssrb.configure().build();
            //根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂
            ourSessionFactory=new MetadataSources(sr).buildMetadata().buildSessionFactory();

        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
//            List<LoginUser> list = session.createQuery("from LoginUser").list();
//            for (LoginUser lu : list) {
//                System.out.println(lu.getLoginName());
//            }
//            LoginUser lu=new LoginUser();
//            lu.setLoginName("zs");
//            lu.setPassword("123");
//            lu.setEmail("zs@163.com");
//            Transaction tran=session.beginTransaction();
//            session.save(lu);
//            tran.commit();

//            Menu pm=new Menu();
//            pm.setName("fucaidan");
//            pm.setUrl("fu");
//
//            Menu cm=new Menu();
//            cm.setName("zicaidan");
//            cm.setUrl("zi");
//            pm.getMenus().add(cm);
//            cm.setParentMenu(pm);
//
//            Transaction tx=session.beginTransaction();
//            session.save(pm);
//            tx.commit();

            Role role = new Role();
            role.setName("hr");

            Power power=new Power();
            power.setName("aaa");

            role.getPowers().add(power);

            Transaction tx=session.beginTransaction();
            session.save(power);
            tx.commit();

        } finally {
            session.close();
            ourSessionFactory.close();
        }
    }
}