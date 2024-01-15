#pragma once

#include <QDialog>
#include "ui_LoginWidget.h"

class LoginWidget : public QDialog
{
	Q_OBJECT

public:
	LoginWidget(QWidget *parent = nullptr);
	~LoginWidget();

public:
	QString getName() const { return m_SName; }
	QString getIPAddr() const { return m_SIPAddr; }
	int getPort() const { return m_nPort; }

public slots:
	void Login();

private:
	void Initialize();

private:
	Ui::LoginWidget ui;
	QString m_SName;        //Ãû×Ö
	QString m_SIPAddr;      //IPµØÖ·
	int m_nPort;			//¶Ë¿ÚºÅ
};
