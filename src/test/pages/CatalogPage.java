package test.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Page Object для страницы Каталога
 */

public class CatalogPage {
    ProductPage productPage = new ProductPage();

    private final ElementsCollection
            name = $$(".product-listing-card-info__content"),
            rightMenu = $$("[class=\"mega-burger__sub-content mega-burger__sub-content_show\"] .mega-burger-content-menu__title");

    public ProductPage findAndClick(String value) {
        SelenideElement menu = name.findBy(text(value));
        menu.click();

        return productPage;
    }
}