#include "dialog.h"
#include <QApplication>
#include <QLabel>
#include <QTextCodec>
#include <QFont>
#include <QDebug>
#include <QWidget>

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    Dialog w;
    w.resize(400,400);//设置对话框大小

    QLabel lbl(&w);   //设置Label
    lbl.move(100,100); //移动到100，100的位置

    //设置字体
//    QTextCodec::setCodecForLocale(QTextCodec::codecForName("utf8"));
//    QFont font("AR PL UKai CN");
//    a.setFont(font);
//    lbl.setText(QObject::tr("用代码设置的label"));
     lbl.setText("用代码设置的label");

    int x=w.x();
    int y=w.y();

    QRect geometry=w.geometry();  //边框的位置
    QRect framegeometry=w.frameGeometry();

    qDebug("x=%d",x);
    qDebug("y=%d",y);

    qDebug()<<geometry;
    qDebug()<<framegeometry;

    QWidget *c=new QWidget();
    QLabel *d=new QLabel(c);//d是c的子窗口

    c->show();


   w.show();

    return a.exec();
}
