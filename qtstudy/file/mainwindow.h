#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QString>
#include "string.h"
#include <string>

namespace Ui {
class MainWindow;
}

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    explicit MainWindow(QWidget *parent = 0);
    ~MainWindow();
    void newFile();   // 新建操作
    bool maybeSave(); // 判断是否需要保存
    bool save();      // 保存操作
    bool saveAs();    // 另存为操作
    bool saveFile(const QString &fileName); // 保存文件

private slots:
    void on_actionNew_N_triggered();

    void on_actionPrint_p_triggered();

    void on_actionAsSave_triggered();

private:
    Ui::MainWindow *ui;
    //为真表示文件未被保存过
    bool isUntitled;
    //文件的路径
    QString curFile;
};

#endif // MAINWINDOW_H
