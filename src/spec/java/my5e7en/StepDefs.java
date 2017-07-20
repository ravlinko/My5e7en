package my5e7en;

import com.my5e7en.web.my5e7en.My5e7enApplication;

import org.fluentlenium.adapter.cucumber.FluentCucumberTest;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import my5e7en.page.CreateUserFormPage;


@ContextConfiguration
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes = My5e7enApplication.class
)
public class StepDefs extends FluentCucumberTest {
	private int port;

	@Page
	private CreateUserFormPage page;

	public StepDefs(@Value("${local.server.port}") int port) {
		setScreenshotPath("build/cucumber/report");
		this.port = port;
	}

	@Override
	public WebDriver newWebDriver() {
		System.setProperty("webdriver.chrome.driver", "src/spec/resources/driver/chromedriver_mac64");
		return new ChromeDriver();
	}

	@Override
	public String getBaseUrl() {
		return "http://localhost:" + port;
	}

	@Before
	public void before(Scenario scenario) {
		super.before(scenario);
	}

	@After
	public void after(Scenario scenario) {
		super.after(scenario);
	}

	@Given("^application is up$")
	public void application_is_up() {
	}

	@Then("^navigation panel is available$")
	public void navigation_panel_is_available() {
	}

	@Then("^there are available tabs$")
	public void there_are_available_tabs(final List<String> tabNames) {
	}

	@Given("^([^\"]*) user logged in with password ([^\"]*)")
	public void user_logged_in_with_password(final String login, final String password) {
	}

	@Then("^user role selector is available$")
	public void user_role_selector_is_available() {
	}

	@Then("^there are available roles$")
	public void there_are_available_roles(final List<String> rolesNames) {
	}

	@Given("^a ([^\"]*) page is opened$")
	public void page_is_opened(final String pageName) {
	}

	@When("^click on ([^\"]*) button$")
	public void click_on_button(final String buttonName) {
	}


	@Then("^companies table contains new company with name \"([^\"]*)\"$")
	public void table_contains_new_with_name(final String name) {
	}

	@Then("^users table contains new user with email \"([^\"]*)\"$")
	public void table_contains_new_with_email(final String email) {
	}

	@Then("^reports table is$")
	public void table_is(DataTable table) {
	}

	@Then("^company ([^\"]*) view page is opened$")
	public void company_JK_Assistance_inc_view_page_is_opened(final String companyName) {
	}

	@Then("^([^\"]*) button is present and active$")
	public void company_edit_button_is_present_and_active(final String buttonName) {
	}

	@Given("^company ([^\"]*) edit page is opened$")
	public void company_edit_page_is_opened(final String companyName) {
	}

	@Given("^form is filled out as$")
	public void form_is_filled_out_as(Map<String, String> formData) {
	}

	@Given("^enter address ([^\"]*)$")
	public void enter_address(final String inputValue) {
	}

	@Then("^company ([^\"]*) view page with address ([^\"]*)$")
	public void company_view_page_with_address(final String companyName, final String address) {
	}

	@Given("^employees of ([^\"]*) view page is opened$")
	public void employees_of_is_opened(final String companyName) {
	}

	@Given("^employees table is$")
	public void employees_table_is(DataTable arg1) {
	}

	@Given("^([^\"]*) buttons are present and active$")
	public void buttons_are_present_and_active(final String buttonsGroupName) {
	}

	@Given("^([^\"]*) employee of ([^\"]*) edit page is opened$")
	public void employee_of_edit_page_is_opened(final String userEmail, final String companyName) {
	}

	@Given("^enter phone ([^\"]*)$")
	public void enter_phone(final String phone) {
	}

	@Then("^([^\"]*) employee of ([^\"]*) view page is opened$")
	public void employee_of_view_page_is_opened(final String userEmail, final String companyName) {
	}

	@Then("^employee view contains$")
	public void employee_view_contains(final Map<String, String> fieldValues) {
	}

	@When("^click on delete button at ([^\"]*) employee$")
	public void click_on_delete_button_at_employee(final String email) {
	}

	@Then("^report table is$")
	public void report_table_is(DataTable arg1) {
	}

	@When("^click on ([^\"]*) line$")
	public void click_on(final String reportName) {
	}

	@Then("^report view contains$")
	public void report_view_contains(DataTable arg1) {
	}

	@Then("^users page contains$")
	public void users_page_contains(DataTable arg1) {
	}

	@Given("^fill out form$")
	public void fill_out_form(DataTable arg1) {
	}

	@Then("^successful info pop-up is displayed with message$")
	public void successful_info_pop_up_is_displayed_with_message(final String popupMessage) {
	}

}
