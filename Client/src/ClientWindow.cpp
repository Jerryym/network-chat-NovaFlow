#include "ClientWindow.h"

ClientWindow::ClientWindow(QWidget *parent)
    : QMainWindow(parent)
{
    ui.setupUi(this);
    setWindowTitle("NovaFlow");
    Initialize();
    connect(ui.Button_Send, SIGNAL(clicked()), this, SLOT(SendMessage()));
}

ClientWindow::~ClientWindow()
{}

void ClientWindow::SendMessage()
{
    QString SMsg = ui.lineEdit->text();
    if (SMsg.isEmpty() == true)     return;
    SMsg = m_SName + ": " + SMsg;
    ui.textEdit_chatHistory->append(SMsg);
    ui.lineEdit->clear();
}

void ClientWindow::setLoginInfo(const QString & SName, const QString & SIPAddr, int nPort)
{
    m_SName = SName;
    m_SIPAddr = SIPAddr;
    m_nPort = nPort;

    QString SMsg = QString("Attemping a connection to %1:%2, user: %3").arg(SIPAddr).arg(nPort).arg(SName);
    ui.textEdit_chatHistory->append(SMsg);
}

void ClientWindow::keyPressEvent(QKeyEvent* ev)
{
    if (ev->key() == Qt::Key_Enter || ev->key() == Qt::Key_Return)
    {
        SendMessage();
    }
}

void ClientWindow::Initialize()
{
    ui.textEdit_chatHistory->setReadOnly(true);
    ui.lineEdit->setFocus();
}
