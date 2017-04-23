package com.pangciyuan.note;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.hazelcast.config.Config;
import com.hazelcast.config.GroupConfig;
import com.pangciyuan.note.common.Constants;
import com.pangciyuan.note.common.util.ApplicationContextUtils;
import com.pangciyuan.note.common.util.PropertiesUtil;
import com.pangciyuan.note.common.util.Runner;
import com.pangciyuan.note.vertx.ApiVerticle;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.VertxOptions;
import io.vertx.core.eventbus.EventBusOptions;
import io.vertx.core.spi.cluster.ClusterManager;
import io.vertx.spi.cluster.hazelcast.HazelcastClusterManager;

/**
 * Hello world!
 *
 */
public class App {
	private static Logger log = Logger.getLogger(App.class);

	public static void main(String[] args) {
		initData();
		Config cfg = new Config();
		GroupConfig group = new GroupConfig();
		group.setName("p-dev");
		group.setPassword("p-dev");
		cfg.setGroupConfig(group);
		ClusterManager mgr = new HazelcastClusterManager(cfg);
		Runner.runExample(
				ApiVerticle.class, new VertxOptions().setWorkerPoolSize(46).setClustered(true).setClusterManager(mgr)
						.setEventBusOptions(new EventBusOptions().setClustered(true)),
				new DeploymentOptions().setInstances(1));
	}

	private static void initData() {
		// 初始化log4j
		PropertyConfigurator.configure(
				App.class.getResource(PropertiesUtil.getPropertie(Constants.LOG4J_PATH, Constants.LOG4J_INSIDE)));
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
		log.info("初始化log4j结束!");
		// 初始化 application
		ApplicationContextUtils.getContext();

	}
}
