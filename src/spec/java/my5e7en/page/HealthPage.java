package my5e7en.page;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

@PageUrl("/health")
public class HealthPage extends FluentPage {

	@FindBy(tagName = "body")
	private FluentWebElement body;

	public boolean isStatus(final String status) {
		if (body.text().contains(String.format("\"status\":\"%s\"", status))) {
			return true;
		}
		return false;
	}
}
