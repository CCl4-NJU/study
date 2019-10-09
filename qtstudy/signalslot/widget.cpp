#include "widget.h"
#include "ui_widget.h"
#include <dialog.h>
#include <QString>

Widget::Widget(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::Widget)
{
    ui->setupUi(this);


    Dialog *dlg=new Dialog(this);//同时显示两个窗口
    dlg->show();

    connect(dlg,SIGNAL(dlgreturn(int)),this,SLOT(showvalue(int)));//将信号和槽连接起来
}

Widget::~Widget()
{
    delete ui;
}

void Widget::showvalue(int value){   //槽函数
    QString stringValue;

    ui->lineEdit->setText((stringValue.sprintf("%d",value)));

}
