import geb.Page
import geb.spock.GebSpec
import geb.Browser
import org.openqa.selenium.By
import spock.lang.Specification


/**
 * Created by ShittulPatel on 18/08/2016.
 */
class GoogleHome1 extends Page {
    static url = "http://www.google.com"

    static content = {
        searchBox { $("input", name: "q") }

        searchButton { $("button", name: "btnG") }

        searchResultsLinks(wait: true) { $("h3.r") }
    }

}

Browser.drive {

    to url

    searchBox = "Gebish"

    searchButton.click()

    searchResultsLinks.first().click()

    assert at(GoogleHomePage1)

}
