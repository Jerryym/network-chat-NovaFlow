#include "LoginWidget.h"
 
#include <QRegularExpression>
#include <QRegularExpressionValidator>
#include <QMessagebox>

LoginWidget::LoginWidget(QWidget *parent)
	: QDialog(parent)
{
	ui.setupUi(this);
	setWindowTitle("Login");
	Initialize();

	connect(ui.Button_Login, SIGNAL(clicked()), this, SLOT(Login()));
}

LoginWidget::~LoginWidget()
{}

void LoginWidget::Login()
{
	m_SName = ui.Edit_Name->text();
	m_SIPAddr = ui.Edit_IPAddr->text();
	QString SPort = ui.Edit_Port->text();

	if (m_SName.isEmpty() == true)
	{
		QMessageBox::warning(0, "NovaFlow", "昵称不可为空");
		return;
	}
	if (m_SIPAddr.isEmpty() == true)
	{
		QMessageBox::warning(0, "NovaFlow", "IP地址不可为空");
		return;
	}
	if (SPort.isEmpty() == true)
	{
		QMessageBox::warning(0, "NovaFlow", "端口号不可为空");
		return;
	}
	m_nPort = SPort.toInt();

	accept();
}

void LoginWidget::Initialize()
{
	ui.Edit_Name->setFocus();

	QRegularExpression PortregExp("^[0-9]*$");
	ui.Edit_Port->setValidator(new QRegularExpressionValidator(PortregExp));
}
