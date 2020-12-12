package ru.geekbrains.entity.views;

public final class CategoryView extends CommonView {

//  public interface IdName1 extends CommonFull{}         обозвать можно как угодно

    public interface CategoryId extends CommonFull{}
    public interface WholeCategory extends CategoryId {}   // выведет и те над которыми стоит IdName

}
