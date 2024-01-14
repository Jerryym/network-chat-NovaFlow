#pragma once

#include <QtWidgets/QMainWindow>
#include "ui_ClientWindow.h"

class ClientWindow : public QMainWindow
{
    Q_OBJECT

public:
    ClientWindow(QWidget *parent = nullptr);
    ~ClientWindow();

public:
    void setLoginInfo(const QString& SName, const QString& SIPAddr, int nPort);

public slots:
    void SendMessage();

private:
    Ui::ClientWindowClass ui;
    QString m_SName;        //����
    QString m_SIPAddr;      //IP��ַ
    int m_nPort = 8080;     //�˿ں�
};
