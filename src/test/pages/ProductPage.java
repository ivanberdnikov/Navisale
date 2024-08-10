package test.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Page Object для страницы Продукта
 */

public class ProductPage {
    private final SelenideElement
            name = $("#name"),
            price = $(".price__regular"),
            cart = $("[data-selector=\"add-to-cart-btn\"]");

    private final ElementsCollection
            size = $$(".options-group__list-item");

    public String getNameOnProductPage() {
        return name.innerText();
    }

    public ProductPage selectSize(String value) throws InterruptedException {
        SelenideElement menu = size.findBy(exactText(value));
        menu.click();
        Thread.sleep(3000); // TODO убрать слип, заменить на ожидание
        menu.click();
        Thread.sleep(3000); // TODO убрать слип, заменить на ожидание
        return this;
    }

    public void addToCart() throws InterruptedException {
        cart.hover();
        Thread.sleep(2000); // TODO убрать слип, заменить на ожидание
        cart.click();
    }

    public String getPriceOnProductPage() {
        return price.getOwnText().replaceAll("[^\\d]", "");
    }
}