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
            cart = $("[data-selector=\"add-to-cart-btn\"]"),
            sizeSelected = $(".options-group__value"),
            count = $(".quantity-group__number");

    private final ElementsCollection
            sizeSelection = $$(".options-group__list-item");

    public String getNameOnProductPage() {
        return name.innerText();
    }

    public String getNameWithoutColorAndSizeOnProductPage() {
        return getNameOnProductPage().substring(0, getNameOnProductPage().indexOf(" Цвет:"));
    }

    public String getPriceOnProductPage() {
        return price.getOwnText().replaceAll("[^\\d]", "");
    }

    public String getSizeOnProductPage() {
        return sizeSelected.innerText();
    }

    public String getColorOnProductPage() {
        return getNameOnProductPage().substring(getNameOnProductPage().indexOf("Цвет:") + 6, getNameOnProductPage().indexOf("Размер:") - 2);

    }

    public String getCountOnProductPage() {
        return count.innerText();
    }

    public ProductPage selectSize(String value) throws InterruptedException {
        SelenideElement size = sizeSelection.findBy(exactText(value));
        size.click();
        Thread.sleep(3000); // TODO убрать слип, заменить на ожидание
        size.click();
        Thread.sleep(3000); // TODO убрать слип, заменить на ожидание
        return this;
    }

    public void addToCart() throws InterruptedException {
        cart.hover();
        Thread.sleep(2000); // TODO убрать слип, заменить на ожидание
        cart.click();
    }
}