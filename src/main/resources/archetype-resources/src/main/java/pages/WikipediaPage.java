#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.pages;

import io.zahori.framework.core.Locator;
import io.zahori.framework.core.Page;
import io.zahori.framework.core.PageElement;
import io.zahori.framework.core.TestContext;

public class WikipediaPage extends Page {

    private static final long serialVersionUID = -8823897590918241825L;

    private PageElement searchField = new PageElement(this, "Search field", Locator.id("searchInput"));
    private PageElement firstParagraph = new PageElement(this, "First paragraph", Locator.xpath("//*[@id='mw-content-text']/div/p[1]"));

    public WikipediaPage(TestContext testContext) {
        super(testContext);
    }

    public boolean pageLoaded() {
        PageElement logo = new PageElement(this, "Central logo", Locator.xpath("//img[@class='central-featured-logo']"));
        return logo.waitElementVisible();
    }

    public void selectLanguage(String language) {
        PageElement languageLink = new PageElement(this, "Language selector", Locator.xpath("//a/strong[contains(text(),${symbol_escape}"" + language + "${symbol_escape}")]"));
        languageLink.click();

        searchField.waitElementVisible();
    }

    public void search(String textToSearch) {
        searchField.write(textToSearch);

        PageElement searchButton = new PageElement(this, "Search button", Locator.id("searchButton"));
        searchButton.click();

        firstParagraph.waitElementVisible();
    }

    public String getFirstParagraph() {
        return firstParagraph.getText();
    }

}
