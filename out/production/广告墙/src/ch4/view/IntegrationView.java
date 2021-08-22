package ch4.view;


import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import ch4.data.Login;

public class IntegrationView extends JFrame {
    JTabbedPane tabbedPane;	//用选项卡集成下列各个视图
    RegisterView registerView;
    LoginView loginView;
    AddAdvertisementView addAdvertisementView;
    DelAdvertisementView delAdvertisementView;
    ModifyPasswordView modifyPasswordView;
    QueryAllUserADView queryAllUserADView;
    QueryOneUserADView queryOneUserADView;
    AdministratorRegisterView administratorRegisterView;
    Login login;
    AdministratorLoginView administratorLoginView;

    ModifyADContentView modifyADContentView;


    public IntegrationView() {
        registerView = new RegisterView();
        login = new Login();

        loginView = new LoginView();
        addAdvertisementView = new AddAdvertisementView();
        delAdvertisementView = new DelAdvertisementView();
        queryAllUserADView = new QueryAllUserADView();
        queryOneUserADView = new QueryOneUserADView();
        modifyPasswordView = new ModifyPasswordView();
        administratorRegisterView = new AdministratorRegisterView();
        administratorLoginView = new AdministratorLoginView();

        modifyADContentView  = new ModifyADContentView();

        loginView.setLogin(login);
        administratorLoginView.setLogin(login);
        addAdvertisementView.setLogin(login);
//        administratorView.setAdministratorLogin(administrator);
        addAdvertisementView.setLogin(login);
        delAdvertisementView.setLogin(login);
        queryAllUserADView.setLogin(login);
        queryOneUserADView.setLogin(login);
        modifyPasswordView.setLogin(login);

        modifyADContentView.setLogin(login);

        tabbedPane = new JTabbedPane(JTabbedPane.LEFT);//在选项卡在左侧，默认是JTabbedPane.TOP
        tabbedPane.add("登录", loginView);
        tabbedPane.add("注册", registerView);
        tabbedPane.add("添加广告", addAdvertisementView);
        tabbedPane.add("删除广告", delAdvertisementView);


        tabbedPane.add("修改广告内容", modifyADContentView);


        tabbedPane.add("浏览全部用户广告", queryAllUserADView);
        tabbedPane.add("浏览某个用户广告", queryOneUserADView);
        tabbedPane.add("修改密码",modifyPasswordView);
        tabbedPane.add("管理员登录", administratorLoginView);
        tabbedPane.add("管理员注册", administratorRegisterView);
        tabbedPane.validate();
        add(tabbedPane, BorderLayout.CENTER);
        setBounds(250, 150, 1000, 560);
        setTitle("广告墙设计");
        validate();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void main(String args[]) {
        IntegrationView win = new IntegrationView();

    }
}
