package PageUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import PageContainers.ourworldindata_population_container;
import Utilities.ExcelUtilities;
import webUtils.ActionUtils;
import webUtils.JavascrpitUtils;

public class worldpopulation_utils {

	private static WebDriver driver;
	private static ourworldindata_population_container population_container;
	private static JavascrpitUtils jsUtils;

	public worldpopulation_utils(WebDriver driver) {
		worldpopulation_utils.driver = driver;
		population_container = PageFactory.initElements(driver, ourworldindata_population_container.class);
		jsUtils = PageFactory.initElements(driver, JavascrpitUtils.class);
	}

	public void user_collects_data_from_graph_and_writes_in_excel() {
		HashMap<String, HashMap<String, String>> populationdata = new HashMap<String, HashMap<String, String>>();
		ActionUtils.ActionWait(5);
		try {
			jsUtils.scrollIntoView(population_container.population_growth_graph_section);
			ActionUtils.ActionWait(2);
			for (int k = 0; k < population_container.population_growth_circle_dots.size(); k++) {
				HashMap<String, String> curr_population_data = new HashMap<String, String>();
				ActionUtils.hoveringAction(population_container.population_growth_circle_dots.get(k), 2);
				for (int i = 0; i < population_container.population_growth_tooltip_country_txt.size(); i++) {
					curr_population_data.put(
							population_container.population_growth_tooltip_country_txt.get(i).getText().trim(),
							population_container.population_growth_tooltip_population_value_txt.get(i).getText()
									.trim());
				}
               
				populationdata.put(population_container.population_growth_tooltip_year_txt.getText().trim(),
						curr_population_data);

				ActionUtils.ActionWait(2);
			}

			System.out.println(populationdata);
			List<String> Year=new ArrayList<String>();
			for(String key: populationdata.keySet()) {
				Year.add(key);
			}
			ExcelUtilities.writeDatainOneRowforpopulation("Population", "Year",Year);
			

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
