#include "receiver.h"
#include "ui_receiver.h"
#include <QtNetwork>

Receiver::Receiver(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::Receiver)
{
    ui->setupUi(this);
    receiver=new QUdpSocket(this);
    receiver->bind(45454,QUdpSocket::ShareAddress);
    connect(receiver,SIGNAL(readyRead()),this,SLOT(processPendingDatagram()));

}

Receiver::~Receiver()
{
    delete ui;
}

void Receiver::processPendingDatagram(){
    //等待数据
    while(receiver->hasPendingDatagrams()){
        QByteArray datagram;
        datagram.resize(receiver->pendingDatagramSize());

        //接受数据，存到datagram中
        receiver->readDatagram(datagram.data(),datagram.size());
        ui->label->setText(datagram);
    }
}
