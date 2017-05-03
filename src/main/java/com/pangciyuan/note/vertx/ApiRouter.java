package com.pangciyuan.note.vertx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pangciyuan.note.common.Constants;
import com.pangciyuan.note.facade.NoteFacade;
import com.pangciyuan.note.facade.UserFacade;

import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;

@Service
public class ApiRouter {

	@Autowired
	private NoteFacade noteFacade;
	@Autowired
	private UserFacade userFacade;
	@Autowired
	private Filter filter;

	// private final ThymeleafTemplateEngine engine =
	// ThymeleafTemplateEngine.create();

	// 路由信息
	public void router(Router router) {
		// 静态资源访问
		StaticHandler handler = StaticHandler.create();
		handler.setWebRoot("webRoot");
		handler.setIndexPage("index.html");
		router.route(Constants.STATIC_RESOURES).handler(handler);

		// 设置拦截
		router.route().handler(filter::verifyData);

		/* 注册 */
		/** 检查用户名称时候存在 */
		router.post(Constants.CHECK_USERNAME).handler(userFacade::checkUserName);
		/** 用户注册 */
		router.post(Constants.SIGN_UP).handler(userFacade::signUp);
		/** 登录 */
		router.post(Constants.SIGN_IN).handler(userFacade::signIn);
		/** 退出登录 */
		router.post(Constants.SIGN_OUT).handler(userFacade::signOut);
		/** 获取登录用户 */
		router.get(Constants.GET_USER_BY_SIGN).handler(userFacade::getUserSign);
		/** 更新登录用户 */
		router.patch(Constants.USER_INFO).handler(userFacade::updateUser);
		/** 修改密码 */
		router.patch(Constants.USER_UPDATE_PWD).handler(userFacade::updatePwd);
		/** 获取用户笔记本 */
		router.get(Constants.NOTE_BOOK).handler(noteFacade::getNoteBook);
		/** 添加笔记本 */
		router.post(Constants.NOTE_BOOK).handler(noteFacade::addNoteBook);
		/** 修改笔记本 */
		router.patch(Constants.NOTE_BOOK).handler(noteFacade::updateNoteBook);
		/** 删除笔记本 */
		router.delete(Constants.NOTE_BOOK_DELETE).handler(noteFacade::deleteNoteBook);
		/** 查询笔记 */
		router.get(Constants.GET_NOTE_LIST_BY_BOOKID).handler(noteFacade::getNoteList);
		/** 添加笔记 */
		router.post(Constants.NOTE).handler(noteFacade::addNote);
		/** 更新笔记 */
		router.patch(Constants.NOTE).handler(noteFacade::updateNote);
		/** 删除笔记 */
		router.delete(Constants.NOTE_DELETE).handler(noteFacade::deleteNote);
		/** 分享笔记*/
		router.post(Constants.SHARE_NOTE).handler(noteFacade::shareNote);

		/** 查看分享*/
		router.get(Constants.S_S).handler(noteFacade::getShare);
		/** 获取笔记*/
		router.post(Constants.S_S).handler(noteFacade::getShareNote);

		// router.get("/test/sse").handler(context -> {
		// SSEResponse.setResponse(context.response());
		// MultiMap headers = SSEResponse.getResponse().headers();
		// headers.set("content-type", "text/event-stream");
		// headers.set("other-header", "wibble");
		// SSEResponse.getResponse().setChunked(true);
		// MultiMap trailers = SSEResponse.getResponse().trailers();
		// trailers.set("X-wibble", "woobble").set("X-quux", "flooble");
		// SSEResponse.getResponse().write("hello world!");
		//
		// });
		// router.get("/test/sse/:abc").handler(context -> {
		// String sseStr = context.request().getParam("abc");
		// if (SSEResponse.getResponse() != null) {
		// SSEResponse.getResponse().write(sseStr + "\n");
		// } else {
		// sseStr = "response is null";
		// }
		// context.response().end(sseStr);
		// });
	}
}
