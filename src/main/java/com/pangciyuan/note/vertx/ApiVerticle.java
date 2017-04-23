package com.pangciyuan.note.vertx;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;

import com.pangciyuan.note.common.Constants;
import com.pangciyuan.note.common.util.ApplicationContextUtils;
import com.pangciyuan.note.common.util.PropertiesUtil;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.CookieHandler;
import io.vertx.ext.web.handler.CorsHandler;
import io.vertx.ext.web.handler.SessionHandler;
import io.vertx.ext.web.sstore.LocalSessionStore;
import io.vertx.ext.web.sstore.SessionStore;

/**
 * Hello world!
 *
 */
public class ApiVerticle extends AbstractVerticle {
	private static Logger log = Logger.getLogger(ApiVerticle.class);

	@Override
	public void start() throws BeansException, ClassNotFoundException {
		// CORS support
		Set<String> allowHeaders = new HashSet<>();
		allowHeaders.add("x-requested-with");
		allowHeaders.add("Access-Control-Allow-Origin");
		allowHeaders.add("origin");
		allowHeaders.add("Content-Type");
		allowHeaders.add("accept");
		Set<HttpMethod> allowMethods = new HashSet<>();
		allowMethods.add(HttpMethod.GET);
		allowMethods.add(HttpMethod.POST);
		allowMethods.add(HttpMethod.DELETE);
		allowMethods.add(HttpMethod.PATCH);
		log.info("初始化router");
		Router router = Router.router(getVertx());
		router.route().handler(CorsHandler.create("*").allowedHeaders(allowHeaders).allowedMethods(allowMethods));
		router.route().handler(BodyHandler.create());
		
		log.info("创建自己的路由 获取路由对象");
		ApiRouter apiRouter = ApplicationContextUtils.getContext().getBean(ApiRouter.class);
		// SessionHandler
		
		router.route().handler(CookieHandler.create());
		SessionStore store = LocalSessionStore.create(vertx);
		SessionHandler sessionHandler = SessionHandler.create(store);
		router.route().handler(sessionHandler);
		
		apiRouter.router(router);// 分别对不同的访问绑定不同的过滤器和处理器
		router.get("/test/evetnBus/:msg").handler(con -> {
			HttpServerRequest request = con.request();
			String msg = request.getParam("msg");
			System.out.println("msg：sdfsdf" + msg);
			con.response().end();
		});
		
		vertx.createHttpServer().requestHandler(router::accept)
				.listen(PropertiesUtil.getIntPropertie(Constants.HTTP_PORT, Constants.HTTP_PORT_DEF));

	}
}
