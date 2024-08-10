package test.enums.catalog;

/**
 * Enum для значений, находящихся в левой стороне Page Elementa Каталог
 */

public enum LeftMenuEnum {
    МУЖЧИНАМ("Мужчинам"),
    ЖЕНЩИНАМ("Женщинам"),
    ОБУВЬ("Обувь"),
    СУМКИ_И_ЧЕМОДАНЫ("Сумки и чемоданы"),
    АКСЕССУАРЫ("Аксессуары"),
    ZARA("Zara");

    private final String name;

    LeftMenuEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}