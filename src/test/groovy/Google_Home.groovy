import geb.Browser
import geb.Page
import geb.spock.GebSpec
import org.openqa.selenium.By
import spock.lang.Specification
import geb.driver.*


class Google_Home extends Specification {
    static url = "https://www.google.co.uk"
    public static content = {
        searchBox { $("input", name: "q") }

        searchButton { $("button", name: "btnG") }

        searchResultsLinks(wait: true) { $("h3.r") }
    }

    def Page() {
        System.setProperty("webdriver.gecko.driver", "/Users/ShittulPatel/Downloads/geckodriver")


        given: "User enters a URL and is navigated to Google homepage"
        Browser.drive() {
            go url
            assert title == "Google"
        }

        expect: "Confirms the page Title"
        println("We are google homepage")

    }


    def Search() {
        System.setProperty("webdriver.gecko.driver", "/Users/ShittulPatel/Downloads/geckodriver")

        given: "User Enter a search and Result are returned"
        Browser.drive() {
            go url
            assert title == "Google"

            when: "Enter search words GEB"

            $("input", name: "q").value("gebish")
            $("button", name: "btnG").click()

            waitFor { $("#search").displayed }


            $("h3.r").first().click()

            then: "We verify the result"
            waitFor { title == "Geb - Very Groovy Browser Automation" }

        }
    }
}








