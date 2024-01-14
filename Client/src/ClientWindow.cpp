#include "ClientWindow.h"

ClientWindow::ClientWindow(QWidget *parent)
    : QMainWindow(parent)
{
    ui.setupUi(this);
    setWindowTitle("NovaFlow");
}

ClientWindow::~ClientWindow()
{}

void ClientWindow::SendMessage()
{

}

void ClientWindow::setLoginInfo(const QString & SName, const QString & SIPAddr, int nPort)
{
    m_SName = SName;
    m_SIPAddr = SIPAddr;
    m_nPort = nPort;
}
