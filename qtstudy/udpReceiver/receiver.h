#ifndef RECEIVER_H
#define RECEIVER_H

#include <QDialog>

namespace Ui {
class Receiver;
}
class QUdpSocket;
class Receiver : public QDialog
{
    Q_OBJECT

public:
    explicit Receiver(QWidget *parent = 0);
    ~Receiver();

private:
    Ui::Receiver *ui;
    QUdpSocket *receiver;
private slots:
    void processPendingDatagram();
};

#endif // RECEIVER_H
