#include "sender.h"
#include "ui_sender.h"
#include <QByteArray>
#include <QtNetwork>

Sender::Sender(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::Sender)
{
    ui->setupUi(this);
    sender=new QUdpSocket(this);
}

Sender::~Sender()
{
    delete ui;
}

void Sender::on_pushButton_clicked()
{
    QByteArray datagram="h,1,1,1,1";
    sender->writeDatagram(datagram.data(),datagram.size(),QHostAddress::Broadcast,45454);

}


