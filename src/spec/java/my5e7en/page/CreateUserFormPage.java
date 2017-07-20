package my5e7en.page;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

@PageUrl("/user/create")
public class CreateUserFormPage extends FluentPage {

	private FluentWebElement role;

	@FindBy(css = "body > div.container > form > div > button")
	private FluentWebElement createButton;

	@Override
	public void isAt() {
		assertThat(window().title()).contains("New user");
	}

	public void clickOnUserCreateButton() {
		createButton.click();
	}

	public void fillOutInput(final String name, final String value) {
		$(By.id(name)).first().fill().with(value);
	}

	public void selectRole(final String roleValue) {
		role.fillSelect().withText(roleValue);
	}
}
