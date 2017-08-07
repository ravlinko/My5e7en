package my5e7en;

import com.my5e7en.web.my5e7en.My5e7enApplication;

import org.fluentlenium.adapter.cucumber.FluentCucumberTest;
import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.conditions.FluentListConditions;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import my5e7en.page.CompaniesPage;
import my5e7en.page.CompanyCreatePage;
import my5e7en.page.CreateUserPage;
import my5e7en.page.DashboardPage;
import my5e7en.page.HealthPage;
import my5e7en.page.LoginPage;
import my5e7en.page.RegistrationPage;
import my5e7en.page.ReportsPage;
import my5e7en.page.UsersPage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


@ContextConfiguration
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes = My5e7enApplication.class
)
public class StepDefs extends FluentCucumberTest {
	private int port;

	@Page
	private HealthPage healthPage;
	@Page
	private RegistrationPage registrationPage;
	@Page
	private LoginPage loginPage;
	@Page
	private DashboardPage dashboardPage;
	@Page
	private CreateUserPage createUserPage;
	@Page
	private CompanyCreatePage companyCreatePage;
	@Page
	private CompaniesPage companiesPage;
	@Page
	private UsersPage usersPage;
	@Page
	private ReportsPage reportsPage;

	private Map<String, FluentPage> sitePages = new HashMap<>();

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
		this.sitePages.put("registration", this.registrationPage);
		this.sitePages.put("login", this.loginPage);
		this.sitePages.put("dashboard", this.dashboardPage);
		this.sitePages.put("create user", this.createUserPage);
		this.sitePages.put("company create", this.companyCreatePage);
		this.sitePages.put("companies", this.companiesPage);
		this.sitePages.put("users", this.usersPage);
		this.sitePages.put("reports", this.reportsPage);
	}

	@After
	public void after(Scenario scenario) {
		super.after(scenario);
	}

	@Given("^application is ([^\"]*)$")
	public void application_is_up(final String status) {
		goTo(healthPage);
		assertThat(healthPage.isStatus(status)).isTrue();
	}

	@Given("^a ([^\"]*) page is opened$")
	public void page_is_opened(final String pageName) {
		final FluentPage page = this.sitePages.get(pageName);
		assertNotNull(String.format("There are no page object for %s", pageName), page);
		goTo(page);
		page.takeScreenShot();
	}

	@Given("^fill out form at ([^\"]*) page$")
	public void fill_out_form(final String pageName, final Map<String, String> form) {
		final FluentPage page = sitePages.get(pageName);
		form.forEach((k, v) -> {
			page.el(By.id(k)).write(v);
		});
		page.takeScreenShot();
	}

	@When("^click on ([^\"]*) button$")
	public void click_on_button(final String buttonName) {
		$(By.id(buttonName.replace(" ", "_"))).click();
	}

	@Given("^the user is at ([^\"]*) page$")
	public void user_is_at_page(final String pageName) {
		final FluentPage page = this.sitePages.get(pageName);
		assertNotNull(String.format("There are no page object for %s", pageName), page);
		page.isAt();
	}

	@Given("^([^\"]*) user is logging in with password ([^\"]*)")
	public void user_is_logging_in_with_password(final String login, final String password) throws InterruptedException {
		final FluentPage page = sitePages.get("login");
		page.switchTo();
		page.$(By.id("username")).write(login);
		page.$(By.id("password")).write(password);
		page.$(By.id("sign_in")).click();
		assertTrue(dashboardPage.$(By.id("navLogOutButton")).one().present());
	}

	@Then("^([^\"]*) page contains$")
	public void employee_view_contains(final String pageName, final Map<String, String> fieldValues) {
		final FluentPage page = sitePages.get(pageName);
		fieldValues.forEach((k, v) -> assertEquals(v, page.$(By.id(k)).text()));
	}

	@Then("^navigation panel is available$")
	public void navigation_panel_is_available() {
		assertNotNull("Page does not contains navigation panel", dashboardPage.$(By.tagName("nav")).one());
	}

	@Then("^there are available tabs$")
	public void there_are_available_tabs(final List<String> tabNames) {
		final FluentList<FluentWebElement> navigationButtons = dashboardPage.$(By.id("navigationGroup")).$(By.tagName("a"));
		assertTrue(navigationButtons.textContents().containsAll(tabNames));
	}

	@Then("^user role selector is available$")
	public void user_role_selector_is_available() {
		assertNotNull("User role selector is not available", createUserPage.$(By.tagName("select")));
	}

	@Then("^there are available roles$")
	public void there_are_available_roles(final List<String> rolesNames) {
		assertTrue($(By.tagName("option")).textContents().containsAll(rolesNames));
	}

	@Then("^companies table contains new company with name \"([^\"]*)\"$")
	public void table_contains_new_with_name(final String companyName) {
		assertTrue(String.format("There is no company with name: %s", companyName), companiesPage.$(By.className("companyNameCell")).textContents().contains(companyName));
	}

	@Then("^users table contains new user with email \"([^\"]*)\"$")
	public void table_contains_new_with_email(final String email) {
		assertTrue(String.format("There is no user with email: %s", email), usersPage.$(By.className("userEmailCell")).textContents().contains(email));
	}

	@Then("^reports table contains reports with names$")
	public void table_is(List<String> reportNames) {
		reportNames.forEach( r ->
		assertTrue(String.format("There is no report with name: %s", r), reportsPage.$(By.className("reportNameCell")).textContents().contains(r))
		);
	}

	@Then("^company ([^\"]*) view page is opened$")
	public void company_JK_Assistance_inc_view_page_is_opened(final String companyName) {
		final FluentList<FluentWebElement> companyViewComponent = companiesPage.$(By.className("companyViewComponent"));
		assertTrue(companyViewComponent.one().present());
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

	@Then("^successful info pop-up is displayed with message$")
	public void successful_info_pop_up_is_displayed_with_message(final String popupMessage) {
	}

}
