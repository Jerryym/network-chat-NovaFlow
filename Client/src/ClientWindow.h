#pragma once

#include <QtWidgets/QMainWindow>
#include "ui_ClientWindow.h"

#include <QKeyEvent>

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

protected:
    void keyPressEvent(QKeyEvent* ev) override;
    void Initialize();

private:
    Ui::ClientWindowClass ui;
    QString m_SName;        //Ãû×Ö
    QString m_SIPAddr;      //IPµØÖ·
    int m_nPort = 8080;     //¶Ë¿ÚºÅ
};
