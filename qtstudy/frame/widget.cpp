#include "widget.h"
#include "ui_widget.h"
#include <QPixmap>
#include <QMovie>
#include <QDebug>

Widget::Widget(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::Widget)
{
    ui->setupUi(this);


    QPixmap pixmap("../frame/1.jpg");//图片
    ui->label->setPixmap(pixmap);

    QMovie *movie=new QMovie("../frame/2.gif");//gif动画
    ui->label_2->setMovie(movie);
    movie->start();

    QByteArray byte="g456";
    QString string;
    string = QString(byte);
    qDebug()<<byte;
    qDebug()<<byte;
}

Widget::~Widget()
{
    delete ui;
}
