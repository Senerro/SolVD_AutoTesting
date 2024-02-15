package com.solvd.demoautotesting.web.catalog_onliner.helpers.enums;

public enum ProductPageButtonsRuEnum {
    NOTEBOOK ("Ноутбуки"),
    TV ("Телевизоры"),
    VIDEO_CARD ("Видеокарты"),
    ROBOT_CLEANER ("Роботы-пылесосы"),
    SSD ("SSD"),
    TABLET_PC("Планшеты"),
    HEADPHONES ("Наушники и гарнитуры"),
    DISPLAY ("Мониторы"),
    CONSOLE ("Игровые приставки"),
    WASHING_MACHINES ("Стиральные машины"),
    REFRIGERATOR("Холодильники"),
    VACUUM_CLEANER ("Пылесосы"),
    COFFEE ("Кофеварки и кофемашины"),
    HAIRDRYER ("Фены"),
    ;
    ;final String buttonName;

    ProductPageButtonsRuEnum(String buttonName) {
        this.buttonName = buttonName;
    }
    public String getButtonName(){
        return buttonName;
    }
    public String getName(){
        return this.name().toLowerCase().replace("_", "");
    }

}
