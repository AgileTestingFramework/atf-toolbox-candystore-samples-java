package com.agiletestingframework.automationpractice.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.annotations.Test;

import com.agiletestingframework.toolbox.managers.ConfigurationManager;
import static org.assertj.core.api.Assertions.assertThat;

public class IndexPageSmokeTest {
	Document doc;
	
	@Test
	public void automationPracticeSmokeTest() throws IOException{
		String url = ConfigurationManager.getInstance().getWebBaseUrl();
		
		doc = Jsoup.connect(url).get();
		
		Elements elements = doc.select("#block_top_menu a:contains(Women)");
		assertThat(elements.size()).isEqualTo(1);
	}

}
