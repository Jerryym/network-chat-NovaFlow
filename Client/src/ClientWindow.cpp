#include "ClientWindow.h"

ClientWindow::ClientWindow(QWidget *parent)
    : QMainWindow(parent)
{
    ui.setupUi(this);
    setWindowTitle("NovaFlow");

    ui.textEdit_chatHistory->setReadOnly(true);
    ui.lineEdit->setFocus();
    connect(ui.Button_Send, SIGNAL(clicked()), this, SLOT(SendMessage()));
}

ClientWindow::~ClientWindow()
{}

void ClientWindow::SendMessage()
{
    QString SMsg = ui.lineEdit->text();
    if (SMsg.isEmpty() == true)     return;
    ui.textEdit_chatHistory->append(SMsg);
    ui.lineEdit->clear();
}

void ClientWindow::setLoginInfo(const QString & SName, const QString & SIPAddr, int nPort)
{
    m_SName = SName;
    m_SIPAddr = SIPAddr;
    m_nPort = nPort;
}

void ClientWindow::keyPressEvent(QKeyEvent* ev)
{
    if (ev->key() == Qt::Key_Enter || ev->key() == Qt::Key_Return)
    {
        SendMessage();
    }
}
