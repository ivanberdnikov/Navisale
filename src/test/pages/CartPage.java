package test.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Page Object для страницы Корзины
 */

public class CartPage {

    private final SelenideElement
            price = $(".cart-item-default__price"),
            name = $(".cart-item-default__title"),
            size = $("//li[@class=\"cart-item-default__props-item\"][1]"),
            color = $("//li[@class=\"cart-item-default__props-item\"][2]"),
            count = $("quantity-group__input-wrapper");

    public String getNameOnCartPage() {
        return name.getOwnText();
    }

    public String getPriceOnCartPage() {
        return price.getOwnText().replaceAll("[^\\d]", "");
    }

    public String getSizeOnCartPage() {
        return size.getOwnText();
    }

    public String getColorOnCartPage() {
        return color.getOwnText();
    }

    public String getCountOnCartPage() {
        return count.getOwnText();
    }
}