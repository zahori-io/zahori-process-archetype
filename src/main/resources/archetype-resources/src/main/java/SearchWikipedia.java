#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

import io.zahori.framework.core.TestContext;
import io.zahori.framework.core.ZahoriProcess;
import io.zahori.model.process.CaseExecution;
import ${package}.pages.WikipediaPage;

@RestController
public class SearchWikipedia extends ZahoriProcess {

    /*
     * Warning! Do not declare any variables here, values are overwritten when
     * several cases are executed in parallel.
     */

    @Override
    public void run(TestContext testContext, CaseExecution caseExecution) {

        // Read case data
        Map<String, String> data = caseExecution.getCas().getDataMap();
        String language = data.get("Language");
        String searchText = data.get("Search");

        // Load page
        String url = caseExecution.getConfiguration().getEnvironmentUrl();
        testContext.getBrowser().loadPage(url);

        WikipediaPage wiki = new WikipediaPage(testContext);
        if (wiki.pageLoaded()) {
            testContext.logStepPassedWithScreenshot("Page loaded");
        }

        wiki.selectLanguage(language);
        testContext.logStepPassedWithScreenshot("Language selected: {}", language);

        wiki.search(searchText);
        testContext.logStepPassedWithScreenshot("Search: {}", searchText);

        String firstParagraph = wiki.getFirstParagraph();
        testContext.logStepPassed("First paragraph: {}", firstParagraph);
    }
}
