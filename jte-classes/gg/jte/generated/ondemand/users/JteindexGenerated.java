package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UsersPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,12,12,12,12,14,14,17,17,17,20,20,20,20,20,20,20,20,20,20,23,23,29,29,29,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\r\n<html lang=\"en\">\r\n<head>\r\n    <meta charset=\"utf-8\" />\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n    <title>Пользователи</title>\r\n</head>\r\n<body>\r\n<div class=\"mx-auto p-4 py-md-5\">\r\n    <main>\r\n        <h1>");
		jteOutput.setContext("h1", null);
		jteOutput.writeUserContent(page.getHeader());
		jteOutput.writeContent("</h1>\r\n        <table class=\"table table-striped\">\r\n            ");
		for (var user : page.getUsers()) {
			jteOutput.writeContent("\r\n                <tr>\r\n                    <td>\r\n                        ");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(user.getId());
			jteOutput.writeContent("\r\n                    </td>\r\n                    <td>\r\n                        <a href=\"/users/");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(user.getId());
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\">");
			jteOutput.setContext("a", null);
			jteOutput.writeUserContent(user.getFirstName());
			jteOutput.writeContent(" ");
			jteOutput.setContext("a", null);
			jteOutput.writeUserContent(user.getLastName());
			jteOutput.writeContent("</a>\r\n                    </td>\r\n                </tr>\r\n            ");
		}
		jteOutput.writeContent("\r\n        </table>\r\n    </main>\r\n</div>\r\n</body>\r\n</html>\r\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UsersPage page = (UsersPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
