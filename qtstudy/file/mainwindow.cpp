#include "mainwindow.h"
#include "ui_mainwindow.h"
#include <QAction>
#include <QIcon>
#include <QFileDialog>
#include <QPushButton>
#include <QTextStream>
#include <QMessageBox>

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    //添加新动作
    QAction *openfile = new QAction(tr("&OPEN"),this);
    //添加图标
    QIcon Icon(":./img/4.png");
    openfile->setIcon(Icon);
    //设置快捷键
    openfile->setShortcut(QKeySequence("Ctrl+0"));
    //在文件菜单中设置新的打开动作  menubar 在菜单栏添加选项，如果已有选项可以用”menu_括号中的字母“ 来添加子选项
    ui->menuBar->addAction(openfile);
    //ui->menu_F->addAction(openfile);
    isUntitled = true;
    curFile =tr("未命名.txt");
    setWindowTitle(curFile);


}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::newFile()
{
    if (maybeSave()) {
         isUntitled = true;
         curFile = tr("未命名.txt");
         setWindowTitle(curFile);
         ui->textEdit->clear();
         ui->textEdit->setVisible(true);
     }
}
bool MainWindow::maybeSave()
{
   // 如果文档被更改了
if (ui->textEdit->document()->isModified()) {
// 自定义一个警告对话框
       QMessageBox box;
       box.setWindowTitle(tr("警告"));
       box.setIcon(QMessageBox::Warning);
       box.setText(curFile + tr(" 尚未保存，是否保存？"));
       QPushButton *yesBtn = box.addButton(tr("是(&Y)"),
                        QMessageBox::YesRole);
       box.addButton(tr("否(&N)"), QMessageBox::NoRole);
       QPushButton *cancelBut = box.addButton(tr("取消"),
                        QMessageBox::RejectRole);
       box.exec();
       if (box.clickedButton() == yesBtn)
            return save();
       else if (box.clickedButton() == cancelBut)
            return false;
   }
   // 如果文档没有被更改，则直接返回true
   return true;
}
bool MainWindow::save()
{
   if (isUntitled) {
       return saveAs();
   } else {
       return saveFile(curFile);
   }
}
bool MainWindow::saveAs()
{
   QString fileName = QFileDialog::getSaveFileName(this,
                                         tr("另存为"),curFile);
   if (fileName.isEmpty()) return false;
   return saveFile(fileName);
}
bool MainWindow::saveFile(const QString &fileName)
{
   QFile file(fileName);

   if (!file.open(QFile::WriteOnly | QFile::Text)) {

       // %1和%2分别对应后面arg两个参数，/n起换行的作用
       QMessageBox::warning(this, tr("多文档编辑器"),
                   tr("无法写入文件 %1：/n %2")
                  .arg(fileName).arg(file.errorString()));
       return false;
   }
   QTextStream out(&file);
   // 鼠标指针变为等待状态
   QApplication::setOverrideCursor(Qt::WaitCursor);
   out << ui->textEdit->toPlainText();
   // 鼠标指针恢复原来的状态
   QApplication::restoreOverrideCursor();
   isUntitled = false;
   // 获得文件的标准路径
   curFile = QFileInfo(fileName).canonicalFilePath();
   setWindowTitle(curFile);
   return true;
}
void MainWindow::on_actionNew_N_triggered()
{
    newFile();
}

void MainWindow::on_actionPrint_p_triggered()
{
    save();
}

void MainWindow::on_actionAsSave_triggered()
{
    saveAs();
}
