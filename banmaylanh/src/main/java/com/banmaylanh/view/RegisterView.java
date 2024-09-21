package com.banmaylanh.view;

import javax.swing.*;

public class RegisterView extends javax.swing.JFrame {

    private JButton btnDangKy;
    private JLabel lblTenDangNhap;
    private JLabel lblMatKhau;
    private JLabel lblDangKy;
    private JTextField txtTenDangNhap;
    private JPasswordField txtMatKhau;

    public RegisterView() {
        initComponents();
    }

    private void initComponents() {

        // Khởi tạo các thành phần
        lblDangKy = new JLabel();
        btnDangKy = new JButton();
        lblTenDangNhap = new JLabel();
        lblMatKhau = new JLabel();
        txtTenDangNhap = new JTextField();
        txtMatKhau = new JPasswordField();

        // Thiết lập đóng cửa sổ khi tắt
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register");

        // Cấu hình các thành phần
        lblDangKy.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblDangKy.setText("Register");

        lblTenDangNhap.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblTenDangNhap.setText("Username:");

        lblMatKhau.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblMatKhau.setText("Password:");

        txtTenDangNhap.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        txtMatKhau.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        btnDangKy.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        btnDangKy.setText("Register");
        btnDangKy.addActionListener(evt -> btnDangKyActionPerformed(evt));

        // Cấu hình layout
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(lblDangKy))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTenDangNhap)
                            .addComponent(lblMatKhau))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMatKhau)
                            .addComponent(txtTenDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(btnDangKy)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblDangKy)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenDangNhap)
                    .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMatKhau)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(btnDangKy)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        // Điều chỉnh kích thước cửa sổ
        pack();
        setLocationRelativeTo(null); // Căn giữa cửa sổ
    }

    private void btnDangKyActionPerformed(java.awt.event.ActionEvent evt) {
        // Logic xử lý sự kiện đăng ký
        String tenDangNhap = txtTenDangNhap.getText();
        String matKhau = new String(txtMatKhau.getPassword());

        // Ví dụ kiểm tra logic đơn giản
        if (tenDangNhap.isEmpty() || matKhau.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the fields.");
        } else {
            // Thực hiện logic đăng ký (lưu vào database...)
            JOptionPane.showMessageDialog(this, "Registration successful!");
        }
    }

    // Getter cho các thành phần
    public String getTenDangNhap() {
        return txtTenDangNhap.getText();
    }

    public String getMatKhau() {
        return new String(txtMatKhau.getPassword());
    }

    public JButton getBtnDangKy() {
        return btnDangKy;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new RegisterView().setVisible(true));
    }
}
