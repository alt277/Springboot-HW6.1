package ru.geekbrains.entity.views;

public final class CustomerView extends CommonView {

//  public interface IdName1 extends CommonFull{}         обозвать можно как угодно

    public interface IdName extends CommonFull{}
    public interface FullCustomer extends IdName {}   // выведет и те над которыми стоит IdName

}
