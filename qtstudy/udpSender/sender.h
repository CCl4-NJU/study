#ifndef SENDER_H
#define SENDER_H

#include <QDialog>

namespace Ui {
class Sender;

}
class QUdpSocket;
class Sender : public QDialog
{
    Q_OBJECT

public:
    explicit Sender(QWidget *parent = 0);
    ~Sender();


private slots:
    void on_pushButton_clicked();

private:
    Ui::Sender *ui;
    QUdpSocket *sender;
};



#endif // SENDER_H
