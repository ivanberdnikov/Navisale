package test.enums.product;

/**
 * Enum для размеров на странице продукта
 */

public enum SizeEnum {
    XS("X"),
    S("S"),
    M("M"),
    L("L");
    // TODO Дописать оставшиеся варианты для всех кейсов. Подумать над разбивкой по логическим классам.

    private final String name;

    SizeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}