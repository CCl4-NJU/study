#include "dialog.h"
#include "ui_dialog.h"
#include <QColorDialog>
#include <QColor>
#include <qDebug>
#include <QFileDialog>
#include <QFont>
#include <QFontDialog>
#include <QInputDialog>
#include <QProgressDialog>


Dialog::Dialog(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::Dialog)
{
    ui->setupUi(this);
}

Dialog::~Dialog()
{
    delete ui;
}

void Dialog::on_pushButton_clicked()
{
    QColor color=QColorDialog::getColor(Qt::red,this,tr("color"));
    qDebug()<<color;
}

void Dialog::on_pushButton_2_clicked()
{
    QFileDialog::getOpenFileName(this,"file dialog");//(this,"file dialog","文件路径","(*png *jpg)");文件过滤器
}

void Dialog::on_pushButton_3_clicked()
{
    bool ok;
    QFont font=QFontDialog::getFont(&ok,this);

    if(true==ok){
        ui->pushButton_3->setFont(font);
    }
}

void Dialog::on_pushButton_4_clicked()
{
    bool ok;
    QString string=QInputDialog::getText(this,"input dialog","please input your name",QLineEdit::Normal,"admin",&ok);
    qDebug()<<string;
  //int value=QInputDialog::getInt();
  // QStringList item=QInputDialog::getItem();     下拉框
}

void Dialog::on_pushButton_5_clicked()
{
    QProgressDialog progress("Progress Dialog","cancel",0,500000,this);
    for (int i=0;i<5000000;i++){
        progress.setValue(i);
        QCoreApplication::processEvents();//释放资源

        if(progress.wasCanceled()){
            break;
        }
    }
}
