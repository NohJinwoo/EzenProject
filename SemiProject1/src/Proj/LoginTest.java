package Proj;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JFrame;

public class LoginTest extends WindowAdapter implements ActionListener {
	public Connection con;
	public PreparedStatement pstmt;
	private JFrame f, f2, f3, f4;
	private TextField id, pwd;
	static TextField ppid;
	static TextField pppwd;
	static TextField ppname;
	private TextField tfMsg;
	private TextField tfMsg1;
	static TextField age;
	static TextField address;
	static TextField food;
	static TextField tf;
	static TextArea ta;
	private Button btn1, btn2, btn6;
	private LoginDAO dao;
	private LoginVO Login;
	private ChattingVO Ch;

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##ezen";
	String password = "ezen1234";

	public LoginTest() {
		dao = new LoginDAO();

		f = new JFrame("로그인");
		f.setSize(300, 200);
		f.setLayout(new FlowLayout());
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		Label lid = new Label("    아이디 : ", Label.RIGHT);
		Label lpwd = new Label("비밀번호 : ", Label.RIGHT);

		id = new TextField(20);
		pwd = new TextField(20);
		pwd.setEchoChar('*');

		btn1 = new Button("로그인");
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				tfMsg.setText("");
				if (id.getText().equals("")) {
					tfMsg.setText("ID를 입력하세요.");
				} else if (pwd.getText().equals("")) {
					tfMsg.setText("Password를 입력하세요.");
				} else {
					ArrayList<LoginVO> list = dao.list(id.getText());
					if (list.size() == 0) {
						tfMsg.setText("로그인에 실패하였습니다.");
					} else {
						LoginVO data = (LoginVO) list.get(0);
						String spwd = data.getPwd();
						if (pwd.getText().equals(spwd)) {
							tfMsg.setText("로그인 되었습니다.");
							f3.setVisible(true);
							f.dispose();
						} else {
							tfMsg.setText("패스워드가 틀렸습니다.");
						}

					}
				}

			}
		});

		tfMsg = new TextField(30);
		tfMsg.setEditable(true);

		btn2 = new Button("회원가입");
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f2.setVisible(true);
			}
		});

		f.add(lid);
		f.add(id);
		f.add(lpwd);
		f.add(pwd);
		f.add(btn1);
		f.add(btn2);
		f.add(tfMsg);
		f.setVisible(true);

		f2 = new JFrame("회원가입");
		f2.setSize(300, 500);
		f2.setLayout(new FlowLayout());
		f2.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f2.dispose();
			}
		});

		Label pid = new Label("    아이디 : ", Label.RIGHT);
		Label ppwd = new Label("비밀번호 : ", Label.RIGHT);
		Label pname = new Label("        이름 : ", Label.RIGHT);
		Label page = new Label("        나이 : ", Label.RIGHT);
		Label paddress = new Label("        주소 : ", Label.RIGHT);
		Label pfood = new Label("        음식 : ", Label.RIGHT);

		ppid = new TextField(20);
		pppwd = new TextField(20);
		pppwd.setEchoChar('*');
		ppname = new TextField(20);
		age = new TextField(20);
		address = new TextField(20);
		food = new TextField(20);

		Button btn3 = new Button("확인");
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tfMsg1.setText("");
				if (ppid.getText().equals("")) {
					tfMsg1.setText("ID를 입력하세요.");
				} else {
					ArrayList<LoginVO> list = dao.list(ppid.getText());
					if (list.size() == 0) {
						tfMsg1.setText("가능합니다.");
					} else {
						tfMsg1.setText("중복됩니다.");
					}
				}
			}
		});

		Button btn4 = new Button("회원가입");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tfMsg1.getText().equals("") || tfMsg1.getText().equals("중복 확인하세요.") || tfMsg1.getText().equals("중복됩니다.")) {
					tfMsg1.setText("중복 확인하세요.");
				} else {
					f4.setLocation(50, 50);
					f4.setVisible(true);
				}
			}
		});

		Button btn5 = new Button("취소");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ppid.setText("");
				tfMsg1.setText("");
				pppwd.setText("");
				ppname.setText("");
				age.setText("");
				address.setText("");
				food.setText("");
				f2.dispose();
			}
		});

		tfMsg1 = new TextField(20);
		tfMsg1.setEditable(true);

		f2.add(pid);
		f2.add(ppid);
		f2.add(tfMsg1);
		f2.add(btn3);
		f2.add(ppwd);
		f2.add(pppwd);
		f2.add(pname);
		f2.add(ppname);
		f2.add(page);
		f2.add(age);
		f2.add(paddress);
		f2.add(address);
		f2.add(pfood);
		f2.add(food);
		f2.add(btn4);
		f2.add(btn5);

		f3 = new JFrame("대화창");
		f3.setSize(400, 400);
		f3.setLayout(new BorderLayout());
		f3.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f3.dispose();
			}
		});

		tf = new TextField();
		ta = new TextArea();
		
		ta.setText("도움말을 보시려면 '?'를 입력하세요. \r\n");
		
		Panel p = new Panel(); // 패널 : 컴포넌트를 하나로 묶음
		p.setLayout(new BorderLayout());
		p.add(tf, BorderLayout.CENTER);
		btn6 = new Button("확 인");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				SelectChatting sel = new SelectChatting();
				try {
					sel.selectChatting(Ch);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 이벤트를 발생시킨 컴포넌트
				Component comp = (Component) arg0.getSource();
				if (comp instanceof Button || comp instanceof TextField) { // 버튼이나 텍스트 필드라면
					String msg = tf.getText().trim();
					if (msg.equals("")) // 엔터
						return;
					ta.append(msg + "\r\n");
					tf.setText("");
					// TextFiedl 문자열지우기
					tf.setText("");
					// TextField에 캐럿 가져다 놓기
					tf.requestFocus();
				}

			}
		});

		p.add(btn6, BorderLayout.EAST);

		f3.add(ta, BorderLayout.CENTER);
		f3.add(p, BorderLayout.SOUTH);
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				SelectChatting sel = new SelectChatting();
				try {
					sel.selectChatting(Ch);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				// 이벤트를 발생시킨 컴포넌트
				Component comp = (Component) arg0.getSource();
				if (comp instanceof Button || comp instanceof TextField) { // 버튼이나 텍스트 필드라면
					String msg = tf.getText().trim();
					if (msg.equals("")) // 엔터
						return;
					ta.append(msg + "\r\n");
					tf.setText("");
					// TextFiedl 문자열지우기
					tf.setText("");
					// TextField에 캐럿 가져다 놓기
					tf.requestFocus();
				}			
			}
		});

		f4 = new JFrame("확인창");
		f4.setSize(180, 150);
		f4.setLayout(new FlowLayout());

		Label aid = new Label("가입하시겠습니까?", Label.RIGHT);
		Button btn6 = new Button("확인");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InsertLogin Lo = new InsertLogin();
				try {
					Lo.insertLogin(Login);
					System.out.println("success");
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ppid.setText("");
				tfMsg1.setText("");
				pppwd.setText("");
				ppname.setText("");
				age.setText("");
				address.setText("");
				food.setText("");
				f4.dispose();
				f2.dispose();
			}
		});

		Button btn7 = new Button("취소");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ppid.setText("");
				tfMsg1.setText("");
				pppwd.setText("");
				ppname.setText("");
				age.setText("");
				address.setText("");
				food.setText("");
				f4.dispose();
			}
		});

		f4.add(aid);
		f4.add(btn6);
		f4.add(btn7);
	}

	public static void main(String[] args) {
		new LoginTest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
