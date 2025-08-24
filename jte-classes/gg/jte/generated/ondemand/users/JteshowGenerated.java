package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UserPage;
public final class JteshowGenerated {
	public static final String JTE_NAME = "users/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,12,12,12,12,12,12,12,13,13,13,17,17,17,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UserPage page) {
		jteOutput.writeContent("\r\n<html lang=\"en\">\r\n<head>\r\n    <meta charset=\"utf-8\" />\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n    <title>Пользователь</title>\r\n</head>\r\n<body>\r\n<div class=\"mx-auto p-4 py-md-5\">\r\n    <main>\r\n        <h2>");
		jteOutput.setContext("h2", null);
		jteOutput.writeUserContent(page.getUser().getFirstName());
		jteOutput.writeContent(" ");
		jteOutput.setContext("h2", null);
		jteOutput.writeUserContent(page.getUser().getLastName());
		jteOutput.writeContent("</h2>\r\n        <div>");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(page.getUser().getEmail());
		jteOutput.writeContent("</div>\r\n    </main>\r\n</div>\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UserPage page = (UserPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
