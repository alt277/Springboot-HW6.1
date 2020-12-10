package ru.geekbrains.persist.entity.views;

public final class ProductView extends CommonView {

    public interface IdName extends CommonFull {}
    public interface FullProduct extends CommonFull {}
    public interface IdNamePrceCategory extends FullProduct,CategoryView.WholeCategory {}
}
