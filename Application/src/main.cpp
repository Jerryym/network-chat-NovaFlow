#include "ClientWindow.h"
#include "LoginWidget.h"
#include <QtWidgets/QApplication>

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    ClientWindow* pWindow = new ClientWindow;
    LoginWidget* login = new LoginWidget;
    if (login->exec() == QDialog::Accepted)
    {
        pWindow->setLoginInfo(login->getName(), login->getIPAddr(), login->getPort());
        pWindow->show();
        return a.exec();
    }
    return 0;
}
