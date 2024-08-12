package test.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Page Object для страницы Каталога
 */

public class CatalogPage {
    ProductPage productPage = new ProductPage();

    private final ElementsCollection
            name = $$(".product-listing-card-info__content");

    public ProductPage findAndClick(String value) {
        SelenideElement productName = name.findBy(text(value));
        productName.click();

        return productPage;
    }
}