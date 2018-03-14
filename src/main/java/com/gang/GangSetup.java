package com.gang;

import org.nutz.dao.Dao;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;
import org.nutz.resource.Scans;

import com.gang.bean.User;

public class GangSetup implements Setup{
	
	private static final Log log = Logs.get();
	
	public void init(NutConfig config) {
		log.debug("config ioc =" + config.getIoc());
		Dao dao = config.getIoc().get(Dao.class);
		for (Class<?> klass : Scans.me().scanPackage("com.gang.nutz")) {
			if (null != klass.getAnnotation(Table.class)) {
				dao.create(klass,false);
			}
			
			if (dao.count(User.class) == 0) {
				User admin = new User();
				admin.setName("admin");
				admin.setName("123456");
				dao.insert(admin);
			}
		}
	}

	public void destroy(NutConfig nc) {
		// TODO Auto-generated method stub
		
	}

}
