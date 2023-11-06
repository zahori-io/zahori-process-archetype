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

    private PageElement searchField = new PageElement(this, "Search field", Locator.name("search"));
    private PageElement firstParagraph = new PageElement(this, "First paragraph", Locator.xpath("//*[@id='mw-content-text']/div/p[not(contains(@class,'mw-empty-elt'))][1]"));

    public WikipediaPage(TestContext testContext) {
        super(testContext);
    }

    public boolean pageLoaded() {
        PageElement logo = new PageElement(this, "Central logo", Locator.xpath("//img[@class='central-featured-logo']"));
        return logo.waitElementVisible();
    }

    public void selectLanguage(String language) {
        PageElement languageLink = new PageElement(this, "Language selector", Locator.xpath("//a/strong[contains(text(),\"" + language + "\")]"));
        languageLink.click();

        PageElement mainContent = new PageElement(this, "Main content", Locator.xpath("//*[@id='content']"));
        mainContent.waitElementVisible();
    }

    public void search(String textToSearch) {
        if (!searchField.isVisibleWithoutWait()) {
            PageElement searchIcon = new PageElement(this, "Search icon", Locator.xpath("//*[@id='p-search']/a"));
            searchIcon.click();
        }

        searchField.write(textToSearch);

        PageElement searchButton = new PageElement(this, "Search button", Locator.xpath("//form[@id='searchform']//button"));
        searchButton.click();

        firstParagraph.waitElementVisible();
    }

    public String getFirstParagraph() {
        return firstParagraph.getText();
    }

}
