package test.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.elements.Header;
import test.enums.catalog.LeftMenuEnum;
import test.enums.catalog.RightMenuEnum;
import test.enums.product.SizeEnum;
import test.pages.CartPage;
import test.pages.ProductPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Проверка названия и цены товара на странице заказа и в корзине
 * <p>
 * checkNameAndPriceTest:
 * Проверяем, что название товара на странице товара равно названию товара в корзине
 * Проверяем, что цена товара на странице товара равна цене товара в корзине
 */

public class CheckParametersTest extends BaseTest {
    Header header = new Header();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

    @Test
    @DisplayName("Проверка названия и цены товара на странице заказа и в корзине")
    public void checkNameAndPriceTest() throws InterruptedException {
        String productName = "Lifestyle Women Vest Kadın Siyah Yelek Wnv3229-bk";
        String priceOnProductPage;
        String priceOnCartPage;

        open("");
        header.clickCatalog()
                .moveOnLeftMenu(LeftMenuEnum.ЖЕНЩИНАМ.getName())
                .clickRightMenu(RightMenuEnum.ЖИЛЕТЫ.getName())
                .findAndClick(productName)
                .selectSize(SizeEnum.L.getName())
                .addToCart();
        priceOnProductPage = productPage.getPriceOnProductPage();
        Thread.sleep(3000); // TODO убрать слип, заменить на ожидание
        header.clickBasket();
        assertEquals(productName, cartPage.getNameOnCartPage());
        priceOnCartPage = cartPage.getPriceOnCartPage();
        assertEquals(priceOnProductPage, priceOnCartPage.substring(0, priceOnCartPage.length() - 2));
    }
}